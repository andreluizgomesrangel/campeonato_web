package br.com.mobilesaude.cliente.source;

import java.util.List;


public class Artilheiro  implements Comparable<Artilheiro>  {

	long id;
	List<Partida> partidas;
	int gols;
	Time time;
	String nome;
	int posicao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Partida> getPartidas() {
		return partidas;
	}
	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int compareTo(Artilheiro o) {
		// TODO Auto-generated method stub
		if( this.gols < o.gols) return 1;
		if( this.gols > o.gols ) return -1;
		if( this.gols == o.gols ){
			if( this.time.getPosicao() > o.time.getPosicao() ) return 1;
			if( this.time.getPosicao() < o.time.getPosicao() ) return -1;
		}
		
		return 0;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	
}
