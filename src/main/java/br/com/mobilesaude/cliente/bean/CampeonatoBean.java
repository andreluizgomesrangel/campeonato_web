package br.com.mobilesaude.cliente.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.mobilesaude.cliente.CCampeonato;
import br.com.mobilesaude.cliente.CGol;
import br.com.mobilesaude.cliente.CPartida;
import br.com.mobilesaude.cliente.CTime;
import br.com.mobilesaude.cliente.source.Artilheiro;
import br.com.mobilesaude.cliente.source.Gol;
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
	List<Gol> gols = new ArrayList<Gol>();
	List<Artilheiro> artilheiros = new ArrayList<Artilheiro>();
	
	public CampeonatoBean() throws JAXBException{
		CTime ctime = new CTime();
		times = ctime.getLista();
		CPartida cpartida = new CPartida();
		partidas = cpartida.getLista();
		CGol cgol = new CGol();
		gols = cgol.getLista();
		
		
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
		times.sort(null);
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
	
	String artilheiro;
	
	public void golA() throws JAXBException{
		CPartida p = new CPartida();
		partidas = p.golA();
		
		CGol cgol = new CGol();
		cgol.inserir(artilheiro, partidaAtual.getTimeA().getId(),partidaAtual.getId());
		//System.out.println(artilheiro+" "+partidaAtual.getId()+" "+partidaAtual.getTimeA().getId());
		
		CTime t = new CTime();
		times = t.fazerGol(partidaAtual.getTimeA().getId());
		times = t.levarGol(partidaAtual.getTimeB().getId());
		
		refresh();
	}
	
	public void golB() throws JAXBException{
		CPartida p = new CPartida();
		partidas = p.golB();
		
		CGol cgol = new CGol();
		cgol.inserir(artilheiro, partidaAtual.getTimeB().getId(),partidaAtual.getId());
		//System.out.println(artilheiro+" "+partidaAtual.getId()+" "+partidaAtual.getTimeB().getId());
		
		CTime t = new CTime();
		times = t.fazerGol(partidaAtual.getTimeB().getId());
		times = t.levarGol(partidaAtual.getTimeA().getId());
		refresh();
	}
	
	public void finalizarPartida() throws JAXBException{
		CPartida p = new CPartida();
		p.finalizar(partidaAtual.getId());
		refresh();
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


	public String getArtilheiro() {
		return artilheiro;
	}


	public void setArtilheiro(String artilheiro) {
		this.artilheiro = artilheiro;
	}


	public List<Gol> getGols() {
		return gols;
	}


	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}


	public List<Artilheiro> getArtilheiros() {
		return artilheiros;
	}


	public void setArtilheiros(List<Artilheiro> artilheiros) {
		this.artilheiros = artilheiros;
	}
	
	
}
