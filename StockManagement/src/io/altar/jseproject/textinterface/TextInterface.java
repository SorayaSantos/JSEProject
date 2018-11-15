package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;

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

		char choice_list_product = ' ';
		Scanner product_sc = new Scanner(System.in);

		do {

			System.out.println("Please select one of the follow options: ");
			System.out.println("");
			System.out.println("1) Create a new product");
			System.out.println("2) Edit a existing product");
			System.out.println("3) Consult product details");
			System.out.println("4) Remove a product");
			System.out.println("5) Return to the initial menu");

			String line_products = product_sc.nextLine();

			if (line_products.length() > 1 || line_products.length() == 0) {
				System.out.println("Invalid input");
				continue;
			}

			choice_list_product = line_products.charAt(0);

			switch (choice_list_product) {

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
		} while (choice_list_product > '5' || choice_list_product < '1');

		product_sc.close();
	}

	public static void ListShelves() {

		char choice_list_shelf = ' ';
		Scanner shelf_sc = new Scanner(System.in);
		String line_shelf = "";
		do {
			System.out.println("Please select one of the follow options: ");
			System.out.println("");
			System.out.println("1) Create a new shelf");
			System.out.println("2) Edit a existing shelf");
			System.out.println("3) Consult shelf details");
			System.out.println("4) Remove a shelf");
			System.out.println("5) Return to the initial menu");

			line_shelf = shelf_sc.nextLine();

			// statements that may cause an exception

			if (line_shelf.length() > 1 || line_shelf.length() == 0) {
				System.out.println("Invalid Input");
				continue;
			}

			choice_list_shelf = line_shelf.charAt(0);

			switch (choice_list_shelf) {

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

		while (choice_list_shelf > '5' || choice_list_shelf < '1');

		shelf_sc.close();
	}

	public static void DisplayProduct() {
		// Product[] listOfProducts;

		// for i in listOfProducts

	}
}
