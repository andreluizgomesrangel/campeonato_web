package br.com.mobilesaude.cliente.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.JAXBException;

import br.com.mobilesaude.cliente.CPartida;
import br.com.mobilesaude.cliente.CTime;
import br.com.mobilesaude.cliente.source.Partida;
import br.com.mobilesaude.cliente.source.Time;

@ManagedBean
@ViewScoped
public class CampeonatoBean {

	boolean iniciou;
	boolean terminou;
	List<Time> times = new ArrayList<Time>();
	List<Partida> partidas = new ArrayList<Partida>();
	
	public CampeonatoBean() throws JAXBException{
		CTime ctime = new CTime();
		times = ctime.getLista();
		CPartida cpartida = new CPartida();
		partidas = cpartida.getLista();
		
		if(times.isEmpty()==false){
			if( partidas.isEmpty() ){
				setIniciou(false);
			}else setIniciou(true);
			
			if( partidas.get( partidas.size()-1 ).isAcabou()==true ){
				setTerminou(true);
			}else setTerminou(false);
		}
	}

	
	public String nomeTime_novoTime;
	public String nomeJogador_novoTime;
	public void pegarTime() throws JAXBException{
		CTime ctime = new CTime();
		ctime.inserir(nomeTime_novoTime, nomeJogador_novoTime);
	}
	
	
	public boolean isIniciou() {
		return iniciou;
	}

	public void setIniciou(boolean iniciou) {
		this.iniciou = iniciou;
	}

	public boolean isTerminou() {
		return terminou;
	}

	public void setTerminou(boolean terminou) {
		this.terminou = terminou;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}


	public String getNomeJogador_novoTime() {
		return nomeJogador_novoTime;
	}


	public void setNomeJogador_novoTime(String nomeJogador_novoTime) {
		this.nomeJogador_novoTime = nomeJogador_novoTime;
	}


	public String getNomeTime_novoTime() {
		return nomeTime_novoTime;
	}


	public void setNomeTime_novoTime(String nomeTime_novoTime) {
		this.nomeTime_novoTime = nomeTime_novoTime;
	}
	
	
}
