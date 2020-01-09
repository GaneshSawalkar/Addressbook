package com.bridgelabz.felloship.source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.felloship.utility.Utility;

public class Operations {
	static Scanner sc = new Scanner(System.in);
	static List<Person> book;
	public static String spath;

	public static void selectaction() throws IOException {
		int choice;
		do {
			book = Control.readbook(spath);
			System.out.println("****File operations :*****");
			System.out.println("1: New User\n" + "2: Update User\n" + "3: Delete User\n" + "4: Search User\n"
					+ "5: Display sorted Book\n" + "6: Back\n" + "7:Exit\n");
			System.out.print("select choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AddNewPerson(); // add new person entry
				break;
			case 2:
				updatePersoninfo(); // update person info
				break;
			case 3:
				deletePerson(); // delete person info
				break;
			case 4:
				search(); // show person info
				break;
			case 5:
				SortbyName(); // display list ascending order
				break;
			case 6: // get user info
				AddressBook.action();
				return;
			case 7:
				return;
			default:
				break;
			}
		} while (choice != 7);
	}

	public static void AddNewPerson() throws IOException {
		Person newperson = new Person();
		// System.out.println(Operations.spath);
		System.out.print("enter user firstName: ");
		newperson.setFirstName(sc.next());
		System.out.print("enter user lastName: ");
		newperson.setLastName(sc.next());
		System.out.print("enter user address: ");
		sc.nextLine();
		newperson.setAddress(sc.next());
		System.out.print("enter state , city , zip code : ");
		newperson.setCity(sc.next());
		newperson.setState(sc.next());
		newperson.setZipcode(sc.next());
		System.out.print("enter the phone number: ");
		newperson.setPhone(sc.next());
		book.add(newperson);
		System.out.println("Saved Contact Successfully....");
		Control.writebook(book, spath);
	}

	// show person details
	public static void getPersonDetails(Person person22) {
		System.out.println(" FirstName : " + person22.FirstName + "\n LastName  : " + person22.LastName
				+ "\n Address   : " + person22.Address + "\n State     : " + person22.State + "\n City      : "
				+ person22.City + "\n Zip-code  : " + person22.zipcode + "\n Contact   : " + person22.phone);
	}

	// update person information
	public static void updatePersoninfo() {
		System.out.println("enter first name for search");
		String inputstring = sc.next();
		boolean find = false;
		for (Person existingPerson : book) { // if name found then update
			if (existingPerson.FirstName.equals(inputstring)) {
				find = true;
				getPersonDetails(existingPerson);
				System.out.println();
				Selecteditmenu(existingPerson);
				break;
			}
		}
		if (!find) {
			System.out.println("contact not found!...");
		}
		System.out.println("1: Save\n2: Save As\n");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			Control.writebook(book, spath); // save in open file
			System.out.println("Save changes..");
			break;
		case 2:
			Utility.saveAs(book); // save in new file
			break;
		default:
			System.out.println("invalid choice");
			break;
		}
	}

	// select updating information field
	private static void Selecteditmenu(Person existingPerson) {
		System.out.println(
				"1: Lastname\n" + "2: Address \n" + "3: State\n" + "4: City\n" + "5: Zipcode\n" + "6: Contact\n");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("new lastname");
			existingPerson.setLastName(sc.next()); // set lastname
			break;
		case 2:
			System.out.print("New Address : ");
			existingPerson.setAddress(sc.next()); // set new address
			break;
		case 3:
			System.out.println("new state");
			existingPerson.setState(sc.next()); // set new state
			break;
		case 4:
			System.out.println("new city");
			existingPerson.setCity(sc.next()); // set new city
			break;
		case 5:
			System.out.println("new zipcode");
			existingPerson.setZipcode(sc.next()); // set new code
			break;
		case 6:
			System.out.println("new phone");
			existingPerson.setPhone(sc.next()); // set new contact number
			break;
		default:
			break;
		}
	}

	// display all names in sorted form
	public static void SortbyName() {
		book = Control.readbook(spath);
		List<Person> displaylist = book;
		ArrayList<String> sort = new ArrayList<String>();
		for (Person person2 : displaylist) {
			sort.add(person2.FirstName);
		}
		Collections.sort(sort); // sort by name
		for (int i = 0; i < displaylist.size(); i++) {
			for (Person person2 : displaylist) {
				if (sort.get(i).equals(person2.FirstName)) {
					System.out.println();
					System.out.println("*********************" + (i + 1) + "************************");
					System.out.println();
					getPersonDetails(person2);
				}
			}
		}
	}

	// show all books of persons
	public static void displaybook() {
		System.out.println("***********Book**************");
		for (Person person2 : book) {
			System.out.println(person2.FirstName);
		}
	}

	// delete person record from file
	public static void deletePerson() {
		System.out.println("enput person fname");
		String fname = sc.next();
		for (Person person : book) {
			if (fname.equals(person.FirstName)) {
				book.remove(person); // remove record
			}
		}
		Control.writebook(book, spath);
	}

	// search person details
	public static void search() {
		System.out.println("Reading JSON from a file");
		System.out.println("----------------------------");
		System.out.println("enter first name for search");
		String inputstring = sc.next();
		boolean find = false;
		for (Person person22 : book) {
			if (person22.FirstName.equals(inputstring)) {
				find = true;
				getPersonDetails(person22);
			}
		}
		if (!find) {
			System.out.println("contact not found!...");
		}
	}
}
