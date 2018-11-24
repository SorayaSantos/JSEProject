package io.altar.jseproject.model;

public class Shelf extends Entity{


	private long capacity;
	private Product product;
	private double price;
	
	public Shelf(long capacity, Product product, double price) {
		super();
		
		this.capacity = capacity;
		this.product = product;
		this.price = price;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Shelf"+getId() + ", Shelf [capacity=" + capacity + ", product=" + product.toString() + ", price=" + price + "]";
	}
	
	
}
