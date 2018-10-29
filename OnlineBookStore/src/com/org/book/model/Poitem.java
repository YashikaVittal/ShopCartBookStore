package com.org.book.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

/**
 * Maps each book item purchased in one Order by any one user with the help of poitem.hbm file
 */
@Entity
public class Poitem implements Serializable {
	private static final long serialVersionUID = -2897372956778524179L;
	@Id
    @Column(name = "id", nullable = false)
	private int id;
	private int bookid;
	private int price;
	private int quantity;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Poitem [id=" + id + ", bookid=" + bookid + ", price=" + price + "]";
	}
	
	

}
