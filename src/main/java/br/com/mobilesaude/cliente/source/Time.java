package br.com.mobilesaude.cliente.source;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Time implements Comparable<Time> {

	private long id;
	private String nome;
	private int pontos;
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int gp;
	private int gc;
	private int gs;
	double rendimento;
	List<Partida> partidas = new ArrayList<Partida>();
	String jogador;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getJogos() {
		return jogos;
	}
	public void setJogos(int jogos) {
		this.jogos = jogos;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getGp() {
		return gp;
	}
	public void setGp(int gp) {
		this.gp = gp;
	}
	public int getGc() {
		return gc;
	}
	public void setGc(int gc) {
		this.gc = gc;
	}
	public int getGs() {
		return gs;
	}
	public void setGs(int gs) {
		this.gs = gs;
	}
	public List<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public double getRendimento() {
		return rendimento;
	}
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
	public void mostrarPartidasJogadas(){
		for(Partida p : partidas){
			p.mostrar();
		}
	}
	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		if( this.pontos < o.pontos) return 1;
		if( this.pontos > o.pontos ) return -1;
		if( this.pontos == o.pontos ){
			if( this.jogos > o.jogos ) return 1;
			if( this.jogos < o.jogos ) return -1;
			if( this.jogos == o.jogos){
				if( this.gp > o.gp ) return 1;
				if( this.gp < o.gp ) return -1;
			}
		}
		return 0;
	}
	
	
}
