package io.altar.jseproject.model;

import java.util.ArrayList;

public class Product extends Entity{
	
	private ArrayList<Shelf> shelves_list= new ArrayList<Shelf>();
	private double discount;
	private double iva;
	private double pvp;

	public Product(ArrayList<Shelf> shelves_list, double discount, double iva, double pvp) {
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
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
