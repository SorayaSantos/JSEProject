package io.altar.jseproject.model;

import java.util.ArrayList;

public class Product extends Entity{
	
	private ArrayList<Shelf> shelves_list= new ArrayList<Shelf>();
	private int discount;
	private int iva;
	private int pvp;

	public Product(ArrayList<Shelf> shelves_list, int discount, int iva, int pvp) {
		super();
		this.shelves_list = shelves_list;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}

	public ArrayList<Shelf> getShelves_list() {
		return shelves_list;
	}

	public void setShelves_list(ArrayList<Shelf> shelves_list) {
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
	private String getStringOfShelves(){
		String str="";
		for(int i=0;i<shelves_list.size();i++){
			str+=shelves_list.get(i).getId();
			str+=", ";
		}
		return str;
	}

	@Override
	public String toString() {
		return "Product"+getId()+" [shelves_list=" + getStringOfShelves()+ " discount=" + discount + ", iva=" + iva + ", pvp=" + pvp
				+ "]";
	}

}
