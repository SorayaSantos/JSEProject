package io.altar.jseproject.model;

public class Product {
	
	private int id;
	private Shelf[] shelves_list;
	private int discount;
	private int iva;
	private int pvp;
	
	public Product(int id, Shelf[] shelves_list, int discount, int iva, int pvp) {
		super();
		this.id = id;
		this.shelves_list = shelves_list;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shelf[] getShelves_list() {
		return shelves_list;
	}

	public void setShelves_list(Shelf[] shelves_list) {
		this.shelves_list = shelves_list;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getPvp() {
		return pvp;
	}

	public void setPvp(int pvp) {
		this.pvp = pvp;
	}
	
	

}
