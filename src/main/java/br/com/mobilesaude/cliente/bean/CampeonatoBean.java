package br.com.mobilesaude.cliente.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.mobilesaude.cliente.CCampeonato;
import br.com.mobilesaude.cliente.CPartida;
import br.com.mobilesaude.cliente.CTime;
import br.com.mobilesaude.cliente.source.Partida;
import br.com.mobilesaude.cliente.source.Time;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

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
		
		if(!partidas.isEmpty()){
			long idpMax = partidas.get(partidas.size()-1).getId();
			for(Partida p : partidas){
				if(p.isAcabou()==false){
					partidaAtual = p;
					int idp = (int) p.getId();
					if(idp<idpMax){
						proxPartida = partidas.get( idp );
					}
					if(idp>1){
						anterPartida = partidas.get( idp - 2);
					}
					break;
				}
			}
		}

	}

	
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
	
	public String nomeTime_novoTime;
	public String nomeJogador_novoTime;
	public void pegarTime() throws JAXBException{
		CTime ctime = new CTime();
		if( !nomeTime_novoTime.isEmpty() && !nomeJogador_novoTime.isEmpty() ){
			ctime.inserir(nomeTime_novoTime, nomeJogador_novoTime);
			refresh();
		}
	}
	
	public int rodadas;
	public void gerarPartidas() throws JAXBException{
		CCampeonato ccamp = new CCampeonato();
		if(rodadas==1 || rodadas==2){
			ccamp.inciar(rodadas);
			refresh();
		}
	}
	
	
	public Partida partidaAtual;
	public Partida proxPartida;
	public Partida anterPartida;
	
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


	public int getRodadas() {
		return rodadas;
	}


	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}


	public Partida getPartidaAtual() {
		return partidaAtual;
	}


	public void setPartidaAtual(Partida partidaAtual) {
		this.partidaAtual = partidaAtual;
	}


	public Partida getProxPartida() {
		return proxPartida;
	}


	public void setProxPartida(Partida proxPartida) {
		this.proxPartida = proxPartida;
	}


	public Partida getAnterPartida() {
		return anterPartida;
	}


	public void setAnterPartida(Partida anterPartida) {
		this.anterPartida = anterPartida;
	}
	
	
}
