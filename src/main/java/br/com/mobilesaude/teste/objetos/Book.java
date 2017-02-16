package br.com.mobilesaude.teste.objetos;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class Book {
	
	private Integer id;
	private String title;
	private String description;
	private int numberOfPages;
	private BigDecimal price;
	
	public Book(){
		
	}
	
	public Book(int id, String title, String description, int numberOfPages, BigDecimal price ){
		this.id = (Integer)id;
		this.title=title;
		this.description=description;
		this.numberOfPages=numberOfPages;
		this.price = price;
		
	}
	
	public Integer getId() {
		System.out.println("getId");
		return id;
	}
	public void setId(Integer id) {
		System.out.println("setId");
		this.id = id;
	}
	public String getTitle() {
		System.out.println("getTitle");
		return title;
	}
	public void setTitle(String title) {
		System.out.println("setTitle");
		this.title = title;
	}
	public String getDescription() {
		System.out.println("getDescription");
		return description;
	}
	public void setDescription(String description) {
		System.out.println("setDescription");
		this.description = description;
	}
	public int getNumberOfPages() {
		System.out.println("getNumberOfPages");
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		System.out.println("setNumberOfPages");
		this.numberOfPages = numberOfPages;
	}
	public BigDecimal getPrice() {
		System.out.println("getPrice");
		return price;
	}
	public void setPrice(BigDecimal price) {
		System.out.println("setPrice");
		this.price = price;
	}
	
	public void mostrar(){
		System.out.println(title+" "+description+" "+numberOfPages+" "+price);
	}
	 
}
