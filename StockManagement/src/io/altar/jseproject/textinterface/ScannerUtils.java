package io.altar.jseproject.textinterface;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc = new Scanner(System.in);

	public static int getIntFromScanner(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Integer"));
		return Integer.parseInt(input);
	}

	public static double getValidDoubleFromScanner(String msg, int max, boolean canBeNull) {
		double result;
		do {
			result = getDoubleFromScanner(msg, canBeNull);
			if (result > max)
				System.out.println("Number must be under " + max);
		} while (result > max);
		return result;
	}

	public static int getValidIntFromScanner(String msg, int[] ivas, boolean canBeNull) {
		int result;
		boolean validInt = false;
		do {
			result = getIntFromScanner(msg, canBeNull);
			if (canBeNull && result == -1) {
				return -1;
			} else {
				for (int i : ivas) {
					if (result == i) {
						validInt = true;
					}
				}
				if (!validInt) {
					String validString = "";
					for (int i : ivas) {
						validString += " " + i;
					}
					System.out.println("Invalid number. It must be: " + validString);
				}
			}
		} while (!validInt);
		return result;
	}

	public static double getDoubleFromScanner(String msg, boolean canBeNull) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if (canBeNull && input.equals("")) {
				return -1;
			}
		} while (!isType(input, "Double"));
		return Double.parseDouble(input);
	}
	public static Long getLongFromScanner(String msg, boolean canBeNull, boolean findId) {
		String input;
		do {
			System.out.println(msg);
			input = sc.nextLine();
			if (canBeNull && input.equals("")) {
				return (long) -1;
			}

		} while (!isType(input, "Long"));
		
		if (findId && TextInterface.productRepository1.ConsultEntityById(Long.parseLong(input)) == null){
			System.out.println("Id of product not found. Create the product first.");
			return (long) -2;}
		else {
			return Long.parseLong(input);
		}
	}

	public static boolean isType(String input, String type) {
		Scanner lineSc = new Scanner(input);
		boolean result = false;
		switch (type) {
		case "Integer":
			if (lineSc.hasNextInt()) {
				result = true;
			} else {
				System.out.println("Invalid input! Please insert a integer number.");
			}
			break;
		case "Double":
			if (lineSc.hasNextDouble()) {
				result = true;
			} else {
				System.out.println("Invalid input! Please insert a double number.");
			}
			break;
		case "Long":
			if (lineSc.hasNextLong()) {
				result = true;
			} else {
				System.out.println("Invalid input! Please insert a long number.");
			}
			break;
		default:
			result = true;
		}
		lineSc.close();
		return result;
	}
}
