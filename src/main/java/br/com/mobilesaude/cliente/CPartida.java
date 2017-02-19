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

import br.com.mobilesaude.cliente.listas.Partidas;
import br.com.mobilesaude.cliente.source.Partida;
import br.com.mobilesaude.cliente.source.Time;


public class CPartida {

	private static int HTTP_COD_SUCESSO = 200;

	public CPartida(){
	}
	
	public List<Partida> getLista() throws JAXBException{
		Partidas partidas = new Partidas();
		try {
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/partida/listar");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Partidas.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			partidas = (Partidas) jaxbUnmarshaller.unmarshal(br);
			
			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return partidas.getPartidas();
	}
	
	public List<Partida> alterarPartida(long id, long ida, long idb, int placara, int placarb, boolean acabou ) throws JAXBException{
		Partidas partidas = new Partidas();
		try {
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/partida/alterar?id="+id+"&idTimeA="+ida+"&idTimeB="+idb+"&placarA="+placara+"&placarB="+placarb+"&acabou="+acabou);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Partidas.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			partidas = (Partidas) jaxbUnmarshaller.unmarshal(br);
			
			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return partidas.getPartidas();
	}
	
	public List<Partida> inserirPartida(long ida, long idb) throws JAXBException{
		Partidas partidas = new Partidas();
		try {
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/partida/insere?idTimeA="+ida+"&idTimeB="+idb+"&placarA=0&placarB=0&acabou=false");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Partidas.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			partidas = (Partidas) jaxbUnmarshaller.unmarshal(br);
			
			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return partidas.getPartidas();
	}
	
	public List<Partida> golA() throws JAXBException{
		List<Partida> partidas = getLista();
		
		long id = 0;
		
		if(!partidas.isEmpty()){
			for(Partida p : partidas){
				if(p.isAcabou()==false){
					id = p.getId();
					break;
				}
			}
		}
		
		Partida atual = partidas.get( (int) (id - 1) );
		Time tA, tB;
		tA = atual.getTimeA();
		tB = atual.getTimeB();
		int placarA = atual.getPlacarA();
		atual.setPlacarA( placarA + 1 );
		
		return alterarPartida(id, tA.getId(), tB.getId(), atual.getPlacarA(), atual.getPlacarB(), atual.isAcabou());
		
	}
	
	
	public List<Partida> golB() throws JAXBException{
		List<Partida> partidas = getLista();
		
		long id = 0;
		
		if(!partidas.isEmpty()){
			for(Partida p : partidas){
				if(p.isAcabou()==false){
					id = p.getId();
					break;
				}
			}
		}
		
		Partida atual = partidas.get( (int) (id - 1) );
		Time tA, tB;
		tA = atual.getTimeA();
		tB = atual.getTimeB();
		int placarB = atual.getPlacarB();
		atual.setPlacarB( placarB + 1 );
		
		return alterarPartida(id, tA.getId(), tB.getId(), atual.getPlacarA(), atual.getPlacarB(), atual.isAcabou());
		
	}
	
	public List<Partida> finalizar(long id) throws JAXBException{
		Partidas partidas = new Partidas();
		try {
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/partida/finalizar?id="+id);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			if (con.getResponseCode() != HTTP_COD_SUCESSO) {
			
			throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
			}
			
			InputStream in = con.getInputStream();
			InputStreamReader inputStream = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inputStream);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Partidas.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			partidas = (Partidas) jaxbUnmarshaller.unmarshal(br);
			
			con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return partidas.getPartidas();
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
