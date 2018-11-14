package io.altar.jseproject.textinterface;
import java.util.Scanner;

public class TextInterface {
	
	public static void main(String[] args) {
	BeginMenu();
}
	public static void BeginMenu(){
		System.out.println("Please select one of the follow options: ");
		System.out.println("");
		System.out.println("1) List produts");
		System.out.println("2) List shelves");
		System.out.println("3) Quit");
		
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();

		if (line.length()>1){
			System.out.println("Invalid input");
			BeginMenu();
		}
		char choice = line.charAt(0);
		
		switch (choice) {
		
        case '1': ListProducts();
        		break;
        
        case '2': ListShelves();
        		break;
        
        case '3': break;
       
        default: System.out.println("Invalid input.");
        	BeginMenu();
    }
		sc.close();
	}
	public static void ListProducts(){
		
		System.out.println("Please select one of the follow options: ");
		System.out.println("");
		System.out.println("1) Create a new product");
		System.out.println("2) Edit a existing product");
		System.out.println("3) Consult product details");
		System.out.println("4) Remove a product");
		System.out.println("5) Return to the initial menu");
		
		Scanner product_sc = new Scanner(System.in);
		char choice_list_product = product_sc.nextLine().charAt(0);

		switch (choice_list_product) {
		
		
        case '1': //CreateProduct();
        		break;
        
        case '2': //EditProduct();
    			break;

        case '3': //ConsultProduct();
        		break;
        case '4': //RemoveProduct();
    			break;
        case '5': BeginMenu();
    			break;
       
        default: System.out.println("Invalid input.");
        	ListProducts();
    }
		product_sc .close();
	}
	public static void ListShelves(){
		System.out.println("Please select one of the follow options: ");
		System.out.println("");
		System.out.println("1) Create a new shelf");
		System.out.println("2) Edit a existing shelf");
		System.out.println("3) Consult shelf details");
		System.out.println("4) Remove a shelf");
		System.out.println("5) Return to the initial menu");

	Scanner shelf_sc = new Scanner(System.in);
	char choice_list_shelf = shelf_sc.nextLine().charAt(0);

	switch (choice_list_shelf) {
	
	
    case '1': //CreateShelf();
    		break;
    
    case '2': //EditShelf();
			break;

    case '3': //ConsultShelf();
    		break;
    case '4': //RemoveShelf();
			break;
    case '5': BeginMenu();
			break;
   
    default: System.out.println("Invalid input.");
    	ListShelves();
}
	shelf_sc .close();
	}
}
