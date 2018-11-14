package io.altar.jseproject.model;

public class Shelf {

	private int id;
	private int capacity;
	private Product product;
	private int price;
	
	public Shelf(int id, int capacity, Product product, int price) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.product = product;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
