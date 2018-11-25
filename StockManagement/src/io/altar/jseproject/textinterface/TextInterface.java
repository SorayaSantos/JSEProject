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
		
		String stringDiscount = "";
		String stringIva = "";
		String stringPvp = "";
		double discount=0;
		double iva=0;
		double pvp=0;
		
		while (!verificaVariavel(stringDiscount, "double") || !verificaVariavel(stringIva, "double") || !verificaVariavel(stringPvp, "double")){
			System.out.println("Please insert the discount: ");
			stringDiscount = sc.nextLine();
			System.out.println("Please insert the iva: ");
			stringIva = sc.nextLine();
			System.out.println("Please insert the pvp: ");
			stringPvp = sc.nextLine();
			
			if (!verificaVariavel(stringDiscount, "double") || !verificaVariavel(stringIva, "double") || !verificaVariavel(stringPvp, "double") || Long.parseLong(stringDiscount)<=0 || Long.parseLong(stringDiscount)>=100|| Long.parseLong(stringIva)<=0 || Long.parseLong(stringIva)>=100){
				System.out.println("Inputs of product not valid, please insert valid inputs for product");			
			}
			else {
						
			discount= Long.parseLong(stringDiscount);
			iva = Long.parseLong(stringIva);
			pvp = Double.parseDouble(stringPvp);
			
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();

		Product product = new Product(shelvesList, discount, iva, pvp);
		productRepository1.CreateEntities(product);

		}
		ConsultProducts();}
	}

	public static void CreateShelf() {
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		String stringCapacity = "";
		String stringProductId = "";
		String stringPrice = "";
		long capacity=0;
		long productId=0;
		double price =0;
		
		while (!verificaVariavel(stringCapacity, "long") || !verificaVariavel(stringProductId, "long") || !verificaVariavel(stringPrice, "double")){
		System.out.println("Please insert shelf capacity: ");
		stringCapacity = sc.nextLine();
		System.out.println("Please insert id of the product to be stored: ");
		stringProductId = sc.nextLine();
		if (productRepository1.ConsultEntityById(Long.parseLong(stringProductId)) == null){
			System.out.println("Id of product not found. Create the product first.");
			ConsultProducts();
			break;
		}else{
			System.out.println("Please insert rent price (diary): ");
			stringPrice = sc.nextLine();
			if (!verificaVariavel(stringCapacity, "double") || !verificaVariavel(stringProductId, "double") || !verificaVariavel(stringPrice, "double")){
				System.out.println("Inputs of shelf not valid, please insert valid inputs for shelf");			
			}
			else {continue;}
		}
		}
		
		productId= Long.parseLong(stringProductId);
		capacity = Long.parseLong(stringCapacity);
		price = Double.parseDouble(stringPrice);
		
		Collection<Product> values = productRepository1.ConsultEntities();
		for (Product prod : values) {
			if (prod.getId() == productId) {
				Shelf shelf = new Shelf(capacity, prod, price);
				shelvesList = prod.getShelves_list();
				shelvesList.add(shelf);
				prod.setShelves_list(shelvesList);
				shelfRepository1.CreateEntities(shelf);
				break;
			}
		}
		ConsultShelves();
	}

	public static void EditProduct() {
		long id = 0;
		String idString = "";
		String stringDiscount = "";
		String stringIva = "";
		String stringPvp = "";
		double discount=0;
		double iva=0;
		double pvp=0; 
			
		while (!verificaVariavel(idString, "long")){
			System.out.println("Please insert the id of the product to be changed: ");
			idString = sc.nextLine();
		if (!verificaVariavel(idString, "long")) {
			System.out.println("Invalid input! Please insert a valid input for id.");
			System.out.println("Please insert the id of the product: ");
			idString = sc.nextLine();
			}
		}
		id = Long.parseLong(idString);
		
		Product productToBeChanged = productRepository1.ConsultEntityById(id);
		
		if (productToBeChanged == null){
			System.out.println("Id of product not found. Create the product first.");
			ConsultProducts();
		}else{
		
			while (!verificaVariavel(stringDiscount, "double") || !verificaVariavel(stringIva, "double") || !verificaVariavel(stringPvp, "double")){
				System.out.println("Please insert the discount:             Actual discount: (" + productToBeChanged.getDiscount() + ")");
				stringDiscount = sc.nextLine();
				if (stringDiscount.equals("")) {
					discount=productToBeChanged.getDiscount();
				}
				System.out.println("Please insert the iva:             Actual iva: (" + productToBeChanged.getIva() + ")");
				stringIva = sc.nextLine();
				if (stringDiscount.equals("")) {
					discount=productToBeChanged.getIva();
				}
				System.out.println("Please insert the pvp:             Actual pvp: (" + productToBeChanged.getPvp() + ")");
				stringPvp = sc.nextLine();
				if (stringDiscount.equals("")) {
					discount=productToBeChanged.getPvp();
				}
				
				if (!verificaVariavel(stringDiscount, "double") || !verificaVariavel(stringIva, "double") || !verificaVariavel(stringPvp, "double") || Long.parseLong(stringDiscount)<=0 || Long.parseLong(stringDiscount)>=100|| Long.parseLong(stringIva)<=0 || Long.parseLong(stringIva)>=100){
					System.out.println("Inputs of product not valid, please insert valid inputs for product");			
				}
				else {	
			
					discount= Long.parseLong(stringDiscount);
					iva = Long.parseLong(stringIva);
					pvp = Double.parseDouble(stringPvp);

		Product product = productRepository1.ConsultEntityById(id);
		product.setDiscount(discount);
		product.setIva(iva);
		product.setPvp(pvp);

		productRepository1.EditEntityById(id, product);

		ConsultProducts();}
	}}}
			

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
		String idString = "";
		
		long id=0, capacity=0, idProduct=0;
		double price=0;
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		ArrayList<Shelf> actualShelvesList = new ArrayList<Shelf>();
		Collection<Product> values = productRepository1.ConsultEntities();

		while (!verificaVariavel(idString, "long")){
			System.out.println("Please insert the id of the shelf to be changed: ");
			idString = sc.nextLine();
		if (!verificaVariavel(idString, "long")) {
			System.out.println("Invalid input! Please insert a valid input for id.");
			System.out.println("Please insert the id of the shelf to be chenged: ");
			idString = sc.nextLine();
			}
		}
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
		
		String stringId = "";
		long id = 0;
		while (!verificaVariavel(stringId, "long")){
			System.out.println("Please insert the id of the product: ");
			stringId = sc.nextLine();
		if (!verificaVariavel(stringId, "long")) {
			System.out.println("Invalid input! Please insert a valid input for id.");
			System.out.println("Please insert the id of the product: ");
			stringId = sc.nextLine();
			}
		}
		id=Long.parseLong(stringId);
		if (productRepository1.ConsultEntityById(id) == null){
			System.out.println("Id of product not found. Create the product first.");
			ConsultProducts();
		}else{
		System.out.println(productRepository1.ConsultEntityById(id));
		BeginMenu();}
	}

	public static void ConsultShelf() {
		
		String stringId = "";
		long id = 0;
		while (!verificaVariavel(stringId, "long")){
			System.out.println("Please insert the id of the shelf: ");
			stringId = sc.nextLine();
		if (!verificaVariavel(stringId, "long")) {
			System.out.println("Invalid input! Please insert a valid input for id.");
			System.out.println("Please insert the id of the shelf: ");
			stringId = sc.nextLine();
			}
		}
		id=Long.parseLong(stringId);
		if (shelfRepository1.ConsultEntityById(id) == null){
			System.out.println("Id of shelf not found. Create the shelf first.");
			ConsultShelves();
		}else{
		System.out.println(shelfRepository1.ConsultEntityById(id));
		BeginMenu();}
		
	}

	public static void RemoveProduct() {
		System.out.println("Please insert the id of the product to be removed: ");
		String stringId = sc.nextLine();
		long id = 0;

		while (!verificaVariavel(stringId, "long")){
			System.out.println("Please insert the id of the product to be removed: ");
			stringId = sc.nextLine();
		if (!verificaVariavel(stringId, "long")) {
			System.out.println("Invalid input! Please insert a valid input for id.");
			System.out.println("Please insert the id of the product to be removed: ");
			stringId = sc.nextLine();
			}
		}
		id=Long.parseLong(stringId);
		if (productRepository1.ConsultEntityById(id) == null){
			System.out.println("Id of product not found. Create the product first.");
			ConsultProducts();
		}else{
		System.out.println("Remove product? Press enter to remove. ");
		sc.nextLine();
		productRepository1.RemoveEntityById(id);
		ConsultProducts();}
	}

	public static void RemoveShelf() {
		String stringId = "";
		long id = 0;
		while (!verificaVariavel(stringId, "long")){
			System.out.println("Please insert the id of the shelf to be removed: ");
			stringId = sc.nextLine();
		if (!verificaVariavel(stringId, "long")) {
			System.out.println("Invalid input! Please insert a valid input for id.");
			System.out.println("Please insert the id of the shelf to be removed: ");
			stringId = sc.nextLine();
			}
		}
		id=Long.parseLong(stringId);
		if (shelfRepository1.ConsultEntityById(id) == null){
			System.out.println("Id of shelf not found. Create the shelf first.");
			ConsultShelves();
		}else{

		Shelf shelf = shelfRepository1.ConsultEntityById(id);
		Product product = shelf.getProduct();
		ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		shelvesList = product.getShelves_list();
		shelvesList.remove(shelf);

		System.out.println("Remove shelf? Press enter to remove. ");
		sc.nextLine();
		shelfRepository1.RemoveEntityById(id);
		ConsultShelves();}
	}
}
