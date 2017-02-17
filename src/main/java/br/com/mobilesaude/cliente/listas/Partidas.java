package br.com.mobilesaude.cliente.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.mobilesaude.cliente.source.Partida;

@XmlRootElement(name = "collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class Partidas {
	
	@XmlElement(name = "partida")
	List<Partida> partidas = new ArrayList<Partida>();

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
	
	
	
}
