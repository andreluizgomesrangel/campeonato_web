package br.com.mobilesaude.cliente.source;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Gol {
	
	long id;
	long idPartida;
	Partida partida;
	String nomeArtilheiro;
	Artilheiro artilheiro;
	long idTime;
	Time time;
	
	public Gol(){
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(long idPartida) {
		
		this.idPartida = idPartida;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public Artilheiro getArtilheiro() {
		return artilheiro;
	}
	public void setArtilheiro(Artilheiro artilheiro) {
		this.artilheiro = artilheiro;
	}
	public long getIdTime() {
		return idTime;
	}
	public void setIdTime(long idTime) {
		this.idTime = idTime;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

	public String getNomeArtilheiro() {
		return nomeArtilheiro;
	}

	public void setNomeArtilheiro(String nomeArtilheiro) {
		this.nomeArtilheiro = nomeArtilheiro;
	}
	
	public void mostrar(){
		System.out.println(nomeArtilheiro+" "+idTime+" "+idPartida);
	}
	
}
