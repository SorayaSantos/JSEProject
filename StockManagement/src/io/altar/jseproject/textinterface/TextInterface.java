package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.Iterator;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	static ProductRepository productRepository1 = ProductRepository.getInstance();
	static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {

		BeginMenu();
	}

	public static void BeginMenu() {
		char choice = ' ';
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
				ConsultProducts();
				break;

			case '2':
				ConsultShelves();
				break;

			case '3':
				System.out.println("Application closed. ");
				sc.close();
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}

		} while (choice > '3' || choice < '1');

	}

	public static void ConsultProducts() {
		
		ListProducts();

		char choice = ' ';
		String line = "";

		do {

			System.out.println("Please select one of the follow options: ");
			System.out.println("");
			System.out.println("1) Create a new product");
			System.out.println("2) Edit a existing product");
			System.out.println("3) Consult product details");
			System.out.println("4) Remove a product");
			System.out.println("5) Return to the initial menu");

			line = sc.nextLine();

			if (line.length() > 1 || line.length() == 0) {
				System.out.println("Invalid input");
				continue;
			}

			choice = line.charAt(0);

			switch (choice) {

			case '1':  CreateProduct();
				break;

			case '2':  EditProduct();
				break;

			case '3':  ConsultProduct();
				break;
			case '4':  RemoveProduct();
				break;
			case '5':
				BeginMenu();
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}
		} while (choice > '5' || choice < '1');

	}

	public static void ConsultShelves() {
		
		ListShelves();
		char choice = ' ';
		String line = "";
		do {
			System.out.println("Please select one of the follow options: ");
			System.out.println("");
			System.out.println("1) Create a new shelf");
			System.out.println("2) Edit a existing shelf");
			System.out.println("3) Consult shelf details");
			System.out.println("4) Remove a shelf");
			System.out.println("5) Return to the initial menu");

			line = sc.nextLine();

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
	}

	public static void ListProducts() {
		
		//Iterator<Product> productIterator = productRepository1.ConsultEntities2();
		//while (productIterator.hasNext()){
			//System.out.println(productIterator.next().toString());
		//}
		//System.out.println(productRepository1.ConsultEntities());
		Collection<Product> values = productRepository1.ConsultEntities();
		
		for (Product product : values ) {
			System.out.println(product);
		} //dúvida como é que o programa sabe que tem que passar para string se não uso a funçao to string?;
	}
	
	public static void ListShelves() {
		//shelfRepository1.ConsultEntities();
	}
	
	public static void CreateProduct() {
		System.out.println("Please insert the discount: ");
		int discount = sc.nextInt();
		System.out.println("Please insert the iva: ");
		int iva = sc.nextInt();
		System.out.println("Please insert the pvp: ");
		int pvp = sc.nextInt();
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		
		Product product = new Product(shelvesList, discount, iva, pvp);
		productRepository1.CreateEntities(product);
		sc.nextLine();
		BeginMenu(); 
	}
	public static void EditProduct() {
		System.out.println("Please insert the id of the product: ");
		long id = sc.nextInt();
		System.out.println("Please insert the new discount: ");
		int discount = sc.nextInt();
		System.out.println("Please insert the new iva: ");
		int iva = sc.nextInt();
		System.out.println("Please insert the new pvp: ");
		int pvp = sc.nextInt();
		
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		
		Product product = new Product(shelvesList, discount, iva, pvp);
		product.setId(id);
		
		productRepository1.EditEntityById(id,product);//ver o que fazer em relação às shelves
		sc.nextLine();
		BeginMenu(); 
	}
	public static void ConsultProduct() {
		System.out.println("Please insert the id of the product: ");
		long id = sc.nextInt();
		
		System.out.println(productRepository1.ConsultEntityById(id));
		sc.nextLine();
		BeginMenu(); 
	}
	public static void RemoveProduct() {
		System.out.println("Please insert the id of the product to be removed: ");
		long id = sc.nextInt();
		
		productRepository1.RemoveEntityById(id);
		sc.nextLine();
		BeginMenu(); 
	}
}
