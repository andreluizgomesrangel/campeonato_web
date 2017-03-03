package br.com.mobilesaude.cliente.source;

import java.util.ArrayList;
import java.util.List;

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
	
	int posicao;
	
	String confronto;
	String confronto_placar;
	
	List<Artilheiro> artilheiros = new ArrayList<Artilheiro>();
	List<Gol> gols = new ArrayList<Gol>();
	
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
	public List<Artilheiro> getArtilheiros() {
		return artilheiros;
	}
	public void setArtilheiros(List<Artilheiro> artilheiros) {
		this.artilheiros = artilheiros;
	}
	public List<Gol> getGols() {
		return gols;
	}
	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}
	
	public void addGol(Gol g){
		gols.add(g);
	}
	
	public String confronto(){
		return timeA.getNome()+" x "+timeB.getNome();
	}
	
	public String confronto_placar(){
		return timeA.getNome()+" "+placarA+" x "+placarB+" "+timeB.getNome();
	}
	
	public String getConfronto() {
		if(acabou==true) return confronto_placar();
		return confronto();
	}
	public void setConfronto(String confronto) {
		this.confronto = confronto();
	}
	public String getConfronto_placar() {
		return confronto_placar();
	}
	public void setConfronto_placar(String confronto_placar) {
		this.confronto_placar = confronto_placar();
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
}
