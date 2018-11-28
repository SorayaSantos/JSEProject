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
	private static int[] ivas = new int[] { 6, 13, 23 };

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
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();

		System.out.println("Create Product");
		int iva = ScannerUtils.getValidIntFromScanner("Please insert the iva: ", ivas, false);
		double discount = ScannerUtils.getValidDoubleFromScanner("Please insert the discount: ", 100, false);
		double pvp = ScannerUtils.getDoubleFromScanner("Please insert the pvp: ", false);

		Product product = new Product(shelvesList, discount, iva, pvp);
		productRepository1.CreateEntities(product);

		ConsultProducts();
	}

	public static void CreateShelf() {
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();

		long capacity = ScannerUtils.getLongFromScanner("Please insert the capacity: ", false);
		long productId = ScannerUtils.findIdProduct("Please insert the product id: ", false);

		if (productId == (long) -2) {
			ConsultProducts();
		}
		else{

		double price = ScannerUtils.getDoubleFromScanner("Please insert the rent price: ", false);

		Product product = productRepository1.ConsultEntityById(productId);
		
				Shelf shelf = new Shelf(capacity, product, price);
				shelvesList = product.getShelves_list();
				shelvesList.add(shelf);
				product.setShelves_list(shelvesList);
				shelfRepository1.CreateEntities(shelf);
				
		ConsultShelves();}
	}

	public static void EditProduct() {
		
		long productId = ScannerUtils.findIdProduct("Please insert the id of the product to be changed: ", false);
		if (productId == (long) -2) {
			ConsultProducts();
			
		}else{
		Product productToBeChanged = productRepository1.ConsultEntityById(productId);

		int iva = ScannerUtils.getValidIntFromScanner("Please insert the iva:             Actual iva: (" + productToBeChanged.getIva() + ")", ivas, true);
		
		double discount = ScannerUtils.getValidDoubleFromScanner("Please insert the discount:             Actual discount: ("
				+ productToBeChanged.getDiscount() + ")", 100, true);
		double pvp = ScannerUtils.getDoubleFromScanner("Please insert the pvp:             Actual pvp: (" + productToBeChanged.getPvp() + ")", true);

			Product product = productRepository1.ConsultEntityById(productId);
			
			if (iva  != (long) -1) {
				product.setIva(iva);
			}
			if (discount  != (long) -1) {
				product.setDiscount(discount);	
			}
			if (pvp  != (long) -1) {
				product.setPvp(pvp);
			}

			productRepository1.EditEntityById(productId, product);

			ConsultProducts();

		}}
	

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

		do {
			idString = sc.nextLine();
			if (!verificaVariavel(idString, type)) {
				System.out.println("Invalid input!");
				System.out.println(line);
			}
		} while (!verificaVariavel(idString, type));
		return idString;
	}

	public static void EditShelf() {
		
		ArrayList<Shelf> actualShelvesList = new ArrayList<Shelf>();
		long shelfId = ScannerUtils.findIdShelf("Please insert the id of the shelf to be changed: ", false);

		if (shelfId == (long) -2) {
			ConsultShelves();
		}else{
		
		Shelf shelfToBeChanged = shelfRepository1.ConsultEntityById(shelfId);
		long actualCapacity = shelfToBeChanged.getCapacity();
		Product actualProduct = shelfToBeChanged.getProduct();
		long actualIdProduct = actualProduct.getId();
		double actualPrice = shelfToBeChanged.getPrice();
		actualShelvesList = actualProduct.getShelves_list();

		long capacity = ScannerUtils.getLongFromScanner("Please insert the new shelf capacity:            Actual capacity: (" + actualCapacity + ")", true);
		long productId = ScannerUtils.findIdProduct("Please insert new id of the product to be stored:            Actual id: (" + actualIdProduct + ")", true);
		if (productId == (long) -2) {
			ConsultProducts();
		}else{
		double price = ScannerUtils.getDoubleFromScanner("Please insert the new rent price (diary):            Actual rent price: (" + actualPrice + ")", true);
					
		if (capacity  != (long) -1) {
			shelfToBeChanged.setCapacity(capacity);
		}
		if (productId != (long) -1) {
			Product product = productRepository1.ConsultEntityById(productId);
			shelfToBeChanged.setProduct(product);
			ArrayList<Shelf> shelvesList = product.getShelves_list();
			shelvesList.add(shelfToBeChanged);
			product.setShelves_list(shelvesList);
		}
		if (price  != (long) -1) {
			shelfToBeChanged.setPrice(price);
		}
		
		actualShelvesList.remove(shelfToBeChanged);
		actualProduct.setShelves_list(actualShelvesList);

		shelfRepository1.EditEntityById(shelfId, shelfToBeChanged );
	
		ConsultShelves();
		}}
	}

	public static void ConsultProduct() {
		
		long productId = ScannerUtils.findIdProduct("Please insert the id of the product to be changed: ", false);
		if (productId == (long) -2) {
			ConsultProducts();
		}else{

			System.out.println(productRepository1.ConsultEntityById(productId));
			BeginMenu();
		}
	}

	public static void ConsultShelf() {
		
		long shelfId = ScannerUtils.findIdShelf("Please insert the id of the shelf to be changed: ", false);

		if (shelfId == (long) -2) {
			ConsultShelves();
		}else{
			System.out.println(shelfRepository1.ConsultEntityById(shelfId));
			BeginMenu();
		}
	}
	public static void RemoveProduct() {
		
		long productId = ScannerUtils.findIdProduct("Please insert the id of the product to be removed: ", false);
		if (productId == (long) -2) {
			ConsultProducts();
		}else{
			System.out.println("Remove product? Press enter to remove. ");
			sc.nextLine();
			Product product = productRepository1.ConsultEntityById(productId);
			ArrayList<Shelf> shelvesList = product.getShelves_list();
			
			for (Shelf shelf:shelvesList ){
				shelf.setProduct(null);
			}
			
			productRepository1.RemoveEntityById(productId);
			ConsultProducts();
		}
	}

	public static void RemoveShelf() {
		
		long shelfId = ScannerUtils.findIdShelf("Please insert the id of the shelf to be changed: ", false);

		if (shelfId == (long) -2) {
			ConsultShelves();
		}else{
			
			Shelf shelf = shelfRepository1.ConsultEntityById(shelfId);
			Product product = shelf.getProduct();
			ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
			shelvesList = product.getShelves_list();

			System.out.println("Remove shelf? Press enter to remove. ");
			shelvesList.remove(shelf);
			product.setShelves_list(shelvesList);
			sc.nextLine();
			shelfRepository1.RemoveEntityById(shelfId);
			ConsultShelves();
		}
	}

}
