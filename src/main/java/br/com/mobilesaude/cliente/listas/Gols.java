package br.com.mobilesaude.cliente.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.mobilesaude.cliente.source.Gol;

@XmlRootElement(name = "collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class Gols {

	@XmlElement(name = "gol")
	private List<Gol> gols = new ArrayList<Gol>();

	public List<Gol> getGols() {
		return gols;
	}

	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}
	
	
}
