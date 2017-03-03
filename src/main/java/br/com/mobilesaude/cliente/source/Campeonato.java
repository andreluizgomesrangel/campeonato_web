package br.com.mobilesaude.cliente.source;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "campeonato")
@XmlAccessorType(XmlAccessType.FIELD)
public class Campeonato {

	List<Time> times;
	long idTime;
	
	boolean iniciou = false;
	boolean fim = false;
	
	List<Partida> partidas;
	Partida partidaAtual;
	long idPartida;
	
	public List<Time> getTimes() {
		return times;
	}
	public void setTimes(List<Time> times) {
		this.times = times;
	}
	public long getIdTime() {
		return idTime;
	}
	public void setIdTime(long idTime) {
		this.idTime = idTime;
	}
	public boolean isIniciou() {
		return iniciou;
	}
	public void setIniciou(boolean iniciou) {
		this.iniciou = iniciou;
	}
	public boolean isFim() {
		return fim;
	}
	public void setFim(boolean fim) {
		this.fim = fim;
	}
	public List<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	public Partida getPartidaAtual() {
		return partidaAtual;
	}
	public void setPartidaAtual(Partida partidaAtual) {
		this.partidaAtual = partidaAtual;
	}
	public long getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(long idPartida) {
		this.idPartida = idPartida;
	}
	
	
}
