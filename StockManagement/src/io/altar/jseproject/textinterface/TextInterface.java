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

			case '1':
				CreateProduct();
				break;

			case '2':
				EditProduct();
				break;

			case '3':
				ConsultProduct();
				break;
			case '4':
				RemoveProduct();
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

			case '1':
				CreateShelf();
				break;

			case '2':
				EditShelf();
				break;

			case '3':
				ConsultShelf();
				break;
			case '4':
				RemoveShelf();
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

		// Iterator<Product> productIterator =
		// productRepository1.ConsultEntities2();
		// while (productIterator.hasNext()){
		// System.out.println(productIterator.next().toString());
		// }
		// System.out.println(productRepository1.ConsultEntities());
		Collection<Product> values = productRepository1.ConsultEntities();

		for (Product product : values) {
			System.out.println(product);
		}
	}

	public static void ListShelves() {
		Collection<Shelf> values = shelfRepository1.ConsultEntities();

		for (Shelf shelf : values) {
			System.out.println(shelf);
		}
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
		ConsultProducts();
	}

	public static void CreateShelf() {
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		System.out.println("Please insert shelf capacity: ");
		long capacity = sc.nextLong();
		System.out.println("Please insert id of the product to be stored: ");
		long productId = sc.nextLong();
		System.out.println("Please insert rent price (diary): ");
		double price = sc.nextDouble();
		int found = 0;

		Collection<Product> values = productRepository1.ConsultEntities();
		for (Product prod : values) {
			if (prod.getId() == productId) {
				Shelf shelf = new Shelf(capacity, prod, price);
				shelvesList = prod.getShelves_list();
				shelvesList.add(shelf);
				prod.setShelves_list(shelvesList);
				shelfRepository1.CreateEntities(shelf);
				found = 1;
				break;
			}
		}
		if (found == 0) {
			System.out.println("Id of product not found. Create the product first.");
			sc.nextLine();
			ConsultProducts();
		}
		sc.nextLine();
		ConsultShelves();
	}

	public static void EditProduct() {
		System.out.println("Please insert the id of the product to be changed: ");
		long id = sc.nextLong();
		System.out.println("Please insert the new discount: ");
		int discount = sc.nextInt();
		System.out.println("Please insert the new iva: ");
		int iva = sc.nextInt();
		System.out.println("Please insert the new pvp: ");
		int pvp = sc.nextInt();

		Product product = productRepository1.ConsultEntityById(id);
		product.setDiscount(discount);
		product.setIva(iva);
		product.setPvp(pvp);

		productRepository1.EditEntityById(id, product);

		sc.nextLine();
		ConsultProducts();
	}

	public static boolean verificaVariavel(String var, String tipo) {
		try {
			switch (tipo) {
			case "long":
				Long.parseLong(var);
				break;
			case "int":
				Integer.parseInt(var);
				break;
			case "float":
				Float.parseFloat(var);
				break;
			case "double":
				Double.parseDouble(var);
				break;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static String cicleInput(String line, String type) {
		String idString = "";
		
		do {		idString = sc.nextLine();
			if (!verificaVariavel(idString, type)) {
				System.out.println("Invalid input!");
				System.out.println(line);
			}
		} while (!verificaVariavel(idString, type));
		return idString;
	}
	
	public static void EditShelf() {
		
		String capacityString = "";
		String idProductString = "";
		String priceString = "";
		String inputId = "";

		String idString = "";
		long id=0, capacity=0, idProduct=0;
		double price=01;
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		ArrayList<Shelf> actualShelvesList = new ArrayList<Shelf>();
		Collection<Product> values = productRepository1.ConsultEntities();
		
		inputId = "Please insert the id of the shelf to be changed: ";
		System.out.println(inputId);
		idString = cicleInput(inputId,"long");
		id = Long.parseLong(idString);
		
		Shelf shelfToBeChanged = shelfRepository1.ConsultEntityById(id);
		if (shelfToBeChanged == null){
			System.out.println("Id of shelf not found. Create the shelf first.");
			ConsultShelves();
		}else{
		
		long actualCapacity = shelfToBeChanged.getCapacity();
		Product actualProduct = shelfToBeChanged.getProduct();
		long actualIdProduct = actualProduct.getId();
		double actualPrice = shelfToBeChanged.getPrice();
		actualShelvesList = actualProduct.getShelves_list();

		
		while (!verificaVariavel(capacityString, "long") || !verificaVariavel(idProductString, "long") || !verificaVariavel(priceString, "double")){
			System.out.println( "Please insert the new shelf capacity:            Actual capacity: (" + actualCapacity + ")");
			capacityString = sc.nextLine();
			System.out.println("Please insert new id of the product to be stored:            Actual id: (" + actualIdProduct + ")");
			idProductString=sc.nextLine();
			System.out.println("Please insert the new rent price (diary):            Actual rent price: (" + actualPrice + ")");
			priceString = sc.nextLine();
			System.out.println(priceString);
			if (!verificaVariavel(capacityString, "long") || !verificaVariavel(idProductString, "long") || !verificaVariavel(priceString, "double"))
				System.out.println("Inputs of shelf not valid, please insert valid inputs for shelf");			
		}
		idProduct= Long.parseLong(idProductString);
		capacity = Long.parseLong(capacityString);
		price = Double.parseDouble(priceString);

		for (Product product : values) {
			if (product.getId() == idProduct) {
				Shelf shelf = shelfRepository1.ConsultEntityById(id);
				shelf.setCapacity(capacity);
				shelf.setProduct(product);
				shelf.setPrice(price);

				shelvesList = product.getShelves_list();
				shelvesList.remove(shelfToBeChanged);
				actualShelvesList.remove(shelfToBeChanged);
				actualProduct.setShelves_list(actualShelvesList);
				shelvesList.add(shelf);
				product.setShelves_list(shelvesList);

				shelfRepository1.EditEntityById(id, shelf);
			}
		}
		//sc.nextLine();
		ConsultShelves();
		}
	}

	public static void ConsultProduct() {
		System.out.println("Please insert the id of the product: ");
		long id = sc.nextLong();

		System.out.println(productRepository1.ConsultEntityById(id));
		sc.nextLine();
		BeginMenu();
	}

	public static void ConsultShelf() {
		System.out.println("Please insert the id of the shelf: ");
		long id = sc.nextLong();

		System.out.println(shelfRepository1.ConsultEntityById(id));
		sc.nextLine();
		BeginMenu();
	}

	public static void RemoveProduct() {
		System.out.println("Please insert the id of the product to be removed: ");
		long id = sc.nextLong();

		productRepository1.RemoveEntityById(id);
		sc.nextLine();
		ConsultProducts();
	}

	public static void RemoveShelf() {
		System.out.println("Please insert the id of the shelf to be removed: ");
		long id = sc.nextLong();

		Shelf shelf = shelfRepository1.ConsultEntityById(id);
		Product product = shelf.getProduct();
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		shelvesList = product.getShelves_list();
		shelvesList.remove(shelf);

		shelfRepository1.RemoveEntityById(id);
		sc.nextLine();
		ConsultShelves();
	}
}
