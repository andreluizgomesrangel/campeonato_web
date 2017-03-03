package br.com.mobilesaude.main;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.mobilesaude.cliente.CCampeonato;
import br.com.mobilesaude.cliente.CGol;
import br.com.mobilesaude.cliente.CGolPost;
import br.com.mobilesaude.cliente.CPartida;
import br.com.mobilesaude.cliente.CTime;
import br.com.mobilesaude.cliente.source.Gol;
import br.com.mobilesaude.cliente.source.Partida;
import br.com.mobilesaude.cliente.source.Time;

public class Main {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		
		CGolPost gol = new CGolPost();
 		gol.inserir2("Aguero", "42", "1");
	}

}
