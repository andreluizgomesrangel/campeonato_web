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

import br.com.mobilesaude.cliente.listas.Gols;
import br.com.mobilesaude.cliente.listas.Times;
import br.com.mobilesaude.cliente.source.Gol;
import br.com.mobilesaude.cliente.source.Time;

public class CGol {

	private static int HTTP_COD_SUCESSO = 200;
	
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
			
			URL url = new URL("http://localhost:8080/Campeonato/ws/servico/gol/inserir?artilheiro="+nome+"&idTime="+idTime+"&idPartida="+idPartida);
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
	
}
