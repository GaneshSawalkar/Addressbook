package com.bridgelabz.fellowship.main;

import java.io.IOException;

import com.bridgelabz.fellowship.service.*;
import com.bridgelabz.fellowship.serviceimplement.*;

public class AddressBook {

	public static void main(String[] args) throws IOException {
		System.out.println("*****************MyAddressBook***************");
		action();
	}

	public static void action() throws IOException {
		System.out.println("File");
		System.out.println("Menu :1 -> Create New Book\n" + "      2 -> Edit existing book \n"
				+ "      3 -> Read Book \n" + "      4 -> Quit");
		System.out.print("\nYour Choice is -> ");
		FileService file = Instance.getFileInstance();
		int choice = Utility.isvalidInteger();
		switch (choice) {
		case 1:
			file.CreateFile();
			break;
		case 2:
			file.OpenFile();
			ServicesImplements.selectaction();
			break;
		case 3:
			// read any file
			file.OpenFile();
			file.readbook();
			System.out.println("**********************");
			action();
			break;
		case 4:
			// exit
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
