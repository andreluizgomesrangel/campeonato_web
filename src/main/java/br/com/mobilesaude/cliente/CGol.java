package br.com.mobilesaude.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.mobilesaude.cliente.listas.Gols;
import br.com.mobilesaude.cliente.listas.Times;
import br.com.mobilesaude.cliente.source.Gol;
import br.com.mobilesaude.cliente.source.Time;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CGol {

	private static int HTTP_COD_SUCESSO = 200;
	
	
	/*private String redditApiRequest(String urlStr, String method, int oauthMode, HashMap<String, String> formData) throws RedditApiException {
	    String json;
	    // create client if null
	    if (httpClient == null) {
	        createHttpClient();
	    }
	    try {
	        Request.Builder httpRequest = new Request.Builder().url(urlStr);
	        RequestBody httpRequestBody;
	        String requestStr = "";
	        if (formData!=null) {
	            FormEncodingBuilder formBuilder = new FormEncodingBuilder();
	            Iterator iterator = formData.keySet().iterator();
	            String key;
	            while (iterator.hasNext()){
	                key = (String) iterator.next();
	                formBuilder.add(key, formData.get(key));
	            }
	            httpRequestBody = formBuilder.build();
	        } else {
	            if (!method.equals("GET")) {
	                int queryIndex = urlStr.indexOf("?");
	                if (queryIndex!=-1)
	                    urlStr = urlStr.substring(queryIndex);
	                requestStr = URLEncoder.encode(urlStr, "UTF-8");
	            }
	            httpRequestBody = RequestBody.create(POST_ENCODED, requestStr);
	        }

	        switch (method){
	            case "POST":
	                httpRequest.post(httpRequestBody);
	                break;
	            case "PUT":
	                httpRequest.put(httpRequestBody);
	                break;
	            case "DELETE":
	                httpRequest.delete(httpRequestBody);
	                break;
	            case "GET":
	            default:
	                httpRequest.get();
	                break;
	        }
	        if (oauthMode==REQUEST_MODE_OAUTHREQ) {
	            // For oauth token retrieval and refresh
	            httpRequest.addHeader("Authorization", "Basic " + Base64.encodeToString((OAUTH_CLIENTID + ":").getBytes(), Base64.URL_SAFE | Base64.NO_WRAP));
	        } else if (isLoggedIn() && oauthMode==REQUEST_MODE_AUTHED) {
	            if (isTokenExpired()) {
	                refreshToken();
	            }
	            // add auth headers
	            String tokenStr = getTokenValue("token_type") + " " + getTokenValue("access_token");
	            httpRequest.addHeader("Authorization", tokenStr);
	        }

	        Response response = httpClient.newCall(httpRequest.build()).execute();
	        json = response.body().string();
	        int errorCode = response.code();
	        if (errorCode<200 || errorCode>202) {
	            String errorMsg = getErrorText(json);
	            throw new RedditApiException("Error "+String.valueOf(errorCode)+": "+(errorMsg.equals("")?response.message():errorMsg)+(errorCode==403?" (Authorization with Reddit required)":""), errorCode==403, errorCode);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        throw new RedditApiException("Error: "+e.getMessage());
	    }

	    return json;
	}
	*/
	///////////////////////////////////////////////////////////////
	public static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");

	OkHttpClient client = new OkHttpClient();
	
	String post(String url, String xml) throws IOException {
		  RequestBody body = RequestBody.create(XML, xml);
		  Request request = new Request.Builder()
		      .url(url)
		      .post(body)
		      .build();
		  Response response = client.newCall(request).execute();
		  return response.body().string();
		}
	///////////////////////////////////////////////////////////////
	public List<Gol> getLista() throws JAXBException{
		Gols gols = new Gols();
		try {
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/gol/listar");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Gols.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			gols = (Gols) jaxbUnmarshaller.unmarshal(br);

			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return gols.getGols();
	}
	
	public List<Gol> inserir( String nome, long idTime, long idPartida ) throws JAXBException{
		Gols gols = new Gols();
		try {
			
			String nom = tratarString(nome);
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/gol/inserir?artilheiro="+nom+"&idTime="+idTime+"&idPartida="+idPartida);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			
			
			System.out.println(con.toString());
			
			System.out.println(in.toString());
			
			System.out.println(inputStream.toString());
			
			System.out.println(br.toString());
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Gols.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			
			
			
			gols = (Gols) jaxbUnmarshaller.unmarshal(br);

			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return gols.getGols();
	}
	
	public String tratarString(String palavra) {
		  char one;
	      StringBuffer n = new StringBuffer( palavra.length() );
	      for (int i=0; i<palavra.length(); i++) {
	         one = palavra.charAt(i);
	         switch( one ) {
	            case ' ':
			   n.append('%');
			   n.append('2');
			   n.append('0');
	               break;
	            default:
	               n.append( one );
	          }
	      }
		  return n.toString();
	   }
	
}
