package model;

import java.time.LocalDate;

public class Book {

	private Integer id;

	private String name;
	private int price;
	private LocalDate publishedDate;
	private int authorId;
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", publishedDate=" + publishedDate
				+ ", authorId=" + authorId + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	
	

	
		
	

}
