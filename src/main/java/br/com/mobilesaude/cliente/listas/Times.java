package br.com.mobilesaude.cliente.listas;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.mobilesaude.cliente.source.Time;


@XmlRootElement(name = "collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class Times {
	
	@XmlElement(name = "time")
	private List<Time> times = new ArrayList<Time>();

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
	
}
