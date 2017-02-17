package br.com.mobilesaude.main;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.mobilesaude.cliente.CPartida;
import br.com.mobilesaude.cliente.CTime;
import br.com.mobilesaude.cliente.source.Partida;
import br.com.mobilesaude.cliente.source.Time;

public class Main {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		CPartida cliente = new CPartida();
		CTime ctime = new CTime();
		
		//ctime.alterar(1,"nome", 12, 5, 3, 0, 2, 10, 5, 5, "jhonete");
		//ctime.inserir(6, "outro", "rocco");
	}

}
