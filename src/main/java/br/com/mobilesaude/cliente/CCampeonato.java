package br.com.mobilesaude.cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.mobilesaude.cliente.source.Campeonato;

public class CCampeonato{

	private static int HTTP_COD_SUCESSO = 200;

	public CCampeonato(){
	}
	
	public Campeonato inciar(int rodadas) throws JAXBException{
		Campeonato c = new Campeonato();
		try {
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/campeonato/iniciar?rodadas="+rodadas);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Campeonato.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			c = (Campeonato) jaxbUnmarshaller.unmarshal(br);

			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return c;
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