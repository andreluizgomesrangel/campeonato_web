package br.com.mobilesaude.cliente.source;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class Partida {

	private Time timeA;
	private Time timeB;
	
	private int placarA;
	private int placarB;
	
	long id;
	private long hash;
	boolean acabou;
	
	public Time getTimeA() {
		return timeA;
	}
	public void setTimeA(Time timeA) {
		this.timeA = timeA;
	}
	public Time getTimeB() {
		return timeB;
	}
	public void setTimeB(Time timeB) {
		this.timeB = timeB;
	}
	public int getPlacarA() {
		return placarA;
	}
	public void setPlacarA(int placarA) {
		this.placarA = placarA;
	}
	public int getPlacarB() {
		return placarB;
	}
	public void setPlacarB(int placarB) {
		this.placarB = placarB;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getHash() {
		return hash;
	}
	public void setHash(long hash) {
		this.hash = hash;
	}
	public boolean isAcabou() {
		return acabou;
	}
	public void setAcabou(boolean acabou) {
		this.acabou = acabou;
	}
	
	public void mostrarConfronto(){
		System.out.println(timeA.getNome()+"  x  "+timeB.getNome());
	}
	
	public void mostrar(){
		System.out.println("hash: "+hash);
		System.out.println(timeA.getNome()+"  x  "+timeB.getNome());
		System.out.println("  "+placarA    +"    x    "+placarB);
	}
	
	
}
