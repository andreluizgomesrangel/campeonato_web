package br.com.mobilesaude.cliente;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Node;

import br.com.mobilesaude.cliente.listas.Gols;
import br.com.mobilesaude.cliente.source.Gol;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CGolPost {

	public void inserir(String artilheiro, String idTime, String idPartida){
		@SuppressWarnings("unused")
		RequestBody requestBody = new MultipartBody.Builder()
				.setType(MultipartBody.FORM)
				.addFormDataPart("artilheiro", artilheiro)
				.addFormDataPart("idTime", idTime)
				.addFormDataPart("idPartida", idPartida)
				.build();
		
		Request request = new Request.Builder()
				.url("http://localhost:8080/Campeonato/ws/servico/gol/inserir2")
				.method("POST", RequestBody.create(null, new byte[0]) )
                .post(requestBody)
                .build();
	}
	
	//funciona
	public void inserir2(String artilheiro, String idTime, String idPartida) throws JAXBException{
		OkHttpClient client = new OkHttpClient();
	
		RequestBody formBody = new FormBody.Builder()
		        .add("artilheiro", artilheiro)
		        .add("idTime", idTime)
		        .add("idPartida", idPartida)
		        .build();
		Request request = new Request.Builder()
		        .url("http://localhost:8080/Campeonato/ws/servico/gol/inserir2")
		        .post(formBody)
		        .build();
	
		
		
		try {
		    Response response = client.newCall(request).execute();
		    
		    String xmlString = new String(response.body().string());
		    //System.out.println(response.body().string());
		    //System.out.println(response.body().string());
		    
		    ///response.body().t
		    
		    // convert String into InputStream
		   // InputStream is = new ByteArrayInputStream(response.body().toString().getBytes());
		    
		    
		    // read it with BufferedReader
		   // BufferedReader br = new BufferedReader(new InputStreamReader(is) );
		    
		    /*JAXBContext context = JAXBContext.newInstance( Gols.class );
		    Unmarshaller unMarshaller = context.createUnmarshaller();
		    Gols param = (Gols) unMarshaller.unmarshal( br );*/
		    //String xmlString = response.body().string();
		    JAXBContext jaxbContext = JAXBContext.newInstance(Gols.class);
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		    StringReader reader = new StringReader( xmlString );
		    Gols gols = (Gols) unmarshaller.unmarshal(reader);
		    gols.getGols().get(0).mostrar();
		    
		    // Do something with the response.
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
