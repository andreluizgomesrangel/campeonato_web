package br.com.mobilesaude.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.mobilesaude.cliente.listas.Times;
import br.com.mobilesaude.cliente.source.Time;

public class CTime {

	private static int HTTP_COD_SUCESSO = 200;

	public CTime(){
	}
	
	public List<Time> getLista() throws JAXBException{
		Times times = new Times();
		try {
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/time/listar");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Times.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			times = (Times) jaxbUnmarshaller.unmarshal(br);

			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		times.getTimes().sort(null);
		return times.getTimes();
	}
	
	public List<Time> alterar(long id, String nome, int pontos, int jogos, int vitorias, int empates, int derrotas, int gp, int gc, int gs, String jogador) throws JAXBException{
		Times times = new Times();
		try {
			
			String nom, jog;
			nom = tratarString(nome);
			jog = tratarString(jogador);
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/time/alterar?id="+id+"&nome="+nom+"&pontos="+pontos+"&jogos="+jogos+"&vitorias="+vitorias+"&empates="+empates+"&derrotas="+derrotas+"&gp="+gp+"&gc="+gc+"&gs="+gs+"&jogador="+jog);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Times.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			times = (Times) jaxbUnmarshaller.unmarshal(br);

			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return times.getTimes();
	}

	public List<Time> inserir(String nome, String jogador) throws JAXBException{
		Times times = new Times();
		try {
			
			String nom, jog;
			nom = tratarString(nome);
			jog = tratarString(jogador);
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/time/inserir?nome="+nom+"&pontos=0&jogos=0&vitorias=0&empates=0&derrotas=0&gp=0&gc=0&gs=0&jogador="+jog);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Times.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			times = (Times) jaxbUnmarshaller.unmarshal(br);
			
			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return times.getTimes();
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