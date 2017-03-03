package br.com.mobilesaude.teste.bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mobilesaude.teste.objetos.Book;

//import javax.faces.bean.ManagedBean;

@ManagedBean
@ViewScoped
public class AdminBooksBean implements Serializable{
	
	private Book product = new Book();
	private List<Book> products;
	private String mensagem = "Quem é você?";
	private String nome; 
	
	List<String> frases;
	
	
	
	public AdminBooksBean(){
		products = new ArrayList<Book>();
		System.out.println("AdminBooksBean");
		
		frases = new ArrayList<String>();
		frases.add("Andre");
		frases.add("ta");
		frases.add("Esquecendo");
		frases.add("algo");
	}
	
	public void save(){
		System.out.println("save");
		product.mostrar();
	}
	
	 public Book getProduct() {
		 
		 System.out.println("getProduct\n");
		 product.setDescription(product.getTitle());
		 return product;
	 
	 }

	public List<Book> getProducts() {
		System.out.println("getProducts\n");
		Book b1 = new Book(1,"titulo1","descricao1",10,new BigDecimal(10));
		Book b2 = new Book(2,"titulo2","descricao2",11,new BigDecimal(11));
		Book b3 = new Book(3,"titulo3","descricao3",12,new BigDecimal(12));
		products.add(b1);
		products.add(b2);
		products.add(b3);
		return this.products;
	}

	public void setProducts(List<Book> products) {
		System.out.println("setProducts\n");
		this.products = products;
	}

	public void setProduct(Book product) {
		System.out.println("setProduct\n");
		this.product = product;
	}
	public String getHorario() {
		System.out.println("getHorario\n");
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	    return "Atualizado em " + sdf.format(new Date());
	}
	public String getMensagem() {
		System.out.println("getMensagem");
	    return mensagem;
	  }
	
	public String getNome() {
		System.out.println("getNome\n");
	    return nome;
	  }
	public void setNome(String nome){
		System.out.println("setNome\n");
		this.nome=nome;
	}
	public void nomeFoiDigitado() {
		System.out.println("nomeFoiDigitado");
		System.out.println(nome);
	    System.out.println("Chamou o botão\n");
	  }

	public List<String> getFrases() {
		return frases;
	}

	public void setFrases(List<String> frases) {
		this.frases = frases;
	}
}

