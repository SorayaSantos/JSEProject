package io.altar.jseproject.model;

public class Shelf extends Entity{


	private int capacity;
	private Product product;
	private int price;
	
	public Shelf(int capacity, Product product, int price) {
		super();
		
		this.capacity = capacity;
		this.product = product;
		this.price = price;
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

	@Override
	public String toString() {
		return "Shelf [capacity=" + capacity + ", product=" + product.toString() + ", price=" + price + "]";
	}
	
	
}
