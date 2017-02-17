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
			
			/*if(operadoras.getOp()!=null){
			int i;
			for(i=0; i<operadoras.getOp().size(); i++)
			System.out.println(operadoras.getOp().get(i).toString());
			}else
			System.out.println("lista nula");*/
			
			//con.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
		return partidas.getPartidas();
	}
	
}
