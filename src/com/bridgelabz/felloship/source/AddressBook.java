package com.bridgelabz.felloship.source;

import java.io.IOException;
import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) throws IOException {
		System.out.println("*****************MyAddressBook***************");
		action();

	}

	@SuppressWarnings("resource")
	public static void action() throws IOException {
		System.out.println("File");
		System.out.println("Menu :1 -> Create New Book\n" + "      2 -> Open existing book \n" + "      3 -> Save \n"
				+ "      4 -> Save as\n" + "      5 -> Quit");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nYour Choice is -> ");
		int choice = scanner.nextInt();
		switch (choice) {

		case 1:
			com.bridgelabz.felloship.utility.Utility.createfile();
			break;

		case 2:
			com.bridgelabz.felloship.utility.Utility.openfile();
			break;

		case 3:
			com.bridgelabz.felloship.utility.Utility.saveBook();
			break;

		case 4:
			com.bridgelabz.felloship.utility.Utility.saveas();
			break;

		case 5:
			System.out.println();
			System.out.println("Thank you...." + "Have a Nice Day...!");
			return;

		default:
			System.out.println();
			System.out.println("invalid choice..." + "select again \n");
			action();
			break;
		}
	}

}
