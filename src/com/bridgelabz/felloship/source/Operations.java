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

	public Operations() {
		book = Control.readbook(spath);
	}

	public static void selectaction() throws IOException {

		int choice;
		do {
			System.out.println("****File operations :*****");
			System.out.println("1: New User\n" + "2: Update User\n" + "3: Delete User\n" + "4: Search User\n"
					+ "5: Display sorted Book\n" + "6: Back\n" + "7:Exit\n");

			System.out.print("select choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				// add new person entry
				AddNewPerson();
				break;
			case 2:
				// update person info
				updatefile();
				break;
			case 3:
				// delete person info
				deletePerson();
				break;
			case 4:
				// show person info
				read();

				break;
			case 5:
				// display list ascending order
				SortbyName();

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

		System.out.print("enter user firstName: ");
		newperson.setFirstName(sc.next());

		System.out.print("enter user lastName: ");
		newperson.setFirstName(sc.next());

		System.out.print("enter user address: ");
		sc.nextLine();
		newperson.setFirstName(sc.next());

		System.out.print("enter state , city , zip code : ");
		newperson.setFirstName(sc.next());
		newperson.setFirstName(sc.next());
		newperson.setFirstName(sc.next());

		System.out.print("enter the phone number: ");
		newperson.setFirstName(sc.next());

		book.add(newperson);
		System.out.println("Saved Contact Successfully....");

		Control.writebook(book, spath);

	}

	public static void getPersonDetails(Person person22) {
		System.out.println(" FirstName : " + person22.FirstName + "\n LastName  : " + person22.LastName
				+ "\n Address   : " + person22.Address + "\n State     : " + person22.State + "\n City      : "
				+ person22.City + "\n Zip-code  : " + person22.zipcode + "\n Contact   : " + person22.phone);
	}

	public static void updatefile() {
		System.out.println("enter first name for search");
		String inputstring = sc.next();

		boolean find = false;

		for (Person existingPerson : book) {
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
			Control.writebook(book, spath);
			System.out.println("Save changes..");
			break;
		case 2:
			Utility.saveAs(book);

			break;
		default:
			System.out.println("invalid choice");
			break;
		}
	}

	private static void Selecteditmenu(Person existingPerson) {
		System.out.println(
				"1: Lastname\n" + "2: Address \n" + "3: State\n" + "4: City\n" + "5: Zipcode\n" + "6: Contact\n");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("new lastname");
			existingPerson.setLastName(sc.next());

			break;
		case 2:
			System.out.print("New Address : ");
			existingPerson.setAddress(sc.next());

			break;
		case 3:
			System.out.println("new state");
			existingPerson.setState(sc.next());
			break;
		case 4:
			System.out.println("new city");
			existingPerson.setCity(sc.next());
			break;
		case 5:
			System.out.println("new zipcode");
			existingPerson.setZipcode(sc.next());
			break;
		case 6:
			System.out.println("new phone");
			existingPerson.setPhone(sc.next());
			break;

		default:
			break;
		}

	}

	public static void SortbyName() {

		List<Person> displaylist = book;

		ArrayList<String> sort = new ArrayList<String>();

		for (Person person2 : displaylist) {
			sort.add(person2.FirstName);
		}
		Collections.sort(sort);
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

	public static void displaybook() {
		System.out.println("***********Book**************");

		for (Person person2 : book) {
			System.out.println(person2.FirstName);
		}

	}

	public static void deletePerson() {

		System.out.println("enput person fname");
		String fname = sc.next();

		for (Person person : book) {
			if (fname.equals(person.FirstName)) {
				book.remove(person);
			}

		}
		Control.writebook(book, spath);
	}

	public static void read() {

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
