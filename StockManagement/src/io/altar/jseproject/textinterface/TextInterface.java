package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class TextInterface {

	public static void main(String[] args) {
		BeginMenu();
	}

	public static void BeginMenu() {
		char choice = ' ';
		Scanner sc = new Scanner(System.in);
		String line = "";
		do {
			System.out.println("Please select one of the follow options: ");
			System.out.println("");
			System.out.println("1) List produts");
			System.out.println("2) List shelves");
			System.out.println("3) Quit");

				line = sc.nextLine();

			if (line.length() > 1 || line.length() == 0) {
				System.out.println("Invalid input");
				continue;
			}
			choice = line.charAt(0);

			switch (choice) {

			case '1':
				ListProducts();
				break;

			case '2':
				ListShelves();
				break;

			case '3':
				System.out.println("Application closed. ");
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}

		} while (choice > '3' || choice < '1');

		sc.close();
	}

	public static void ListProducts() {

		char choice= ' ';
		Scanner sc = new Scanner(System.in);
		String line="";

		do {

			System.out.println("Please select one of the follow options: ");
			System.out.println("");
			System.out.println("1) Create a new product");
			System.out.println("2) Edit a existing product");
			System.out.println("3) Consult product details");
			System.out.println("4) Remove a product");
			System.out.println("5) Return to the initial menu");

			line =sc.nextLine();

			if (line.length() > 1 || line.length() == 0) {
				System.out.println("Invalid input");
				continue;
			}

			choice= line.charAt(0);

			switch (choice) {

			case '1': // CreateProduct();
				break;

			case '2': // EditProduct();
				break;

			case '3': // ConsultProduct();
				break;
			case '4': // RemoveProduct();
				break;
			case '5':
				BeginMenu();
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}
		} while (choice > '5' || choice < '1');

		sc.close();
	}

	public static void ListShelves() {

		char choice = ' ';
		Scanner sc = new Scanner(System.in);
		String line = "";
		do {
			System.out.println("Please select one of the follow options: ");
			System.out.println("");
			System.out.println("1) Create a new shelf");
			System.out.println("2) Edit a existing shelf");
			System.out.println("3) Consult shelf details");
			System.out.println("4) Remove a shelf");
			System.out.println("5) Return to the initial menu");

			line= sc.nextLine();

			// statements that may cause an exception

			if (line.length() > 1 || line.length() == 0) {
				System.out.println("Invalid Input");
				continue;
			}

			choice = line.charAt(0);

			switch (choice) {

			case '1': // CreateShelf();
				break;

			case '2': // EditShelf();
				break;

			case '3': // ConsultShelf();
				break;
			case '4': // RemoveShelf();
				break;
			case '5':
				BeginMenu();
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}
		}

		while (choice > '5' || choice < '1');

		sc.close();
	}

	public static void DisplayProduct() {
		// Product[] listOfProducts;

		// for i in listOfProducts

	}
	public static void CreateProduct(int id, Shelf[] shelves_list, int discount, int iva, int pvp) {
		// Product[] listOfProducts;

		// for i in listOfProducts

	}
}
