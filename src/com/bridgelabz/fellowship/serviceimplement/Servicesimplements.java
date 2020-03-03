package com.bridgelabz.fellowship.serviceimplement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bridgelabz.fellowship.control.Control;
import com.bridgelabz.fellowship.main.Addressbook;
import com.bridgelabz.fellowship.model.Person;
import com.bridgelabz.fellowship.service.Fileservice;
import com.bridgelabz.fellowship.service.Services;

public class Servicesimplements implements Services {
	static List<Person> book;
	public static String spath;

	public static void selectaction() throws IOException {
		int choice;
		do {
			book = Control.readBook(spath);
			System.out.println("****File operations :*****");
			System.out.println("1: New User\n" + "2: Update User\n" + "3: Delete User\n" + "4: Search User\n"
					+ "5: Display sorted Book by name\n" + "6: Display sorted Book by zip\n" + "7: Back\n"
					+ "8: Exit\n");
			System.out.print("select choice :");
			choice = Utility.isValidInteger();
			Services e = Instance.getServiceInstance();
			switch (choice) {
			case 1:
				e.addPerson(); // add new person entry
				break;
			case 2:
				e.updatePersonInfo(); // update person info
				break;
			case 3:
				e.deletePerson(); // delete person info
				break;
			case 4:
				e.searchPerson(); // show person info
				break;
			case 5:
				e.sortbyName(); // display list ascending order
				break;
			case 6:
				e.sortbyZip(); // display list ascending order
				break;
			case 7: // get user info
				Addressbook.action();
				return;
			case 8:
				return;
			default:
				System.out.println("wrong choice...\n Please select 1-8 options only");
				break;
			}
		} while (choice != 8);
	}

	public void addPerson() {
		Person newperson = new Person();
		// System.out.println(Operations.spath);
		System.out.print("enter user firstName: ");
		newperson.setFirstName(Utility.isString());
		System.out.print("enter user lastName: ");
		newperson.setLastName(Utility.isString());
		System.out.print("enter user address: ");
		Utility.scanner.nextLine();
		newperson.setAddress(Utility.isString());
		System.out.print("enter state : ");
		newperson.setCity(Utility.isString());
		System.out.print("enter city : ");
		newperson.setState(Utility.isString());
		System.out.print("enter zip code : ");
		newperson.setZipcode(Utility.isValidzip());
		System.out.print("enter the phone number: ");
		newperson.setPhone(Utility.isValidphone());
		book.add(newperson);
		System.out.println("Saved Contact Successfully....");
		Control.writeBook(book, spath);
	}

	// update person information
	public void updatePersonInfo() {
		System.out.println("enter first name for search");
		String inputstring = Utility.isString();
		boolean find = false;
		for (Person existingPerson : book) { // if name found then update
			if (existingPerson.FirstName.equals(inputstring)) {
				find = true;
				System.out.println(existingPerson.toString());
				System.out.println();
				selectEditMenu(existingPerson);
				break;
			}
		}
		if (!find) {
			System.out.println("contact not found!...");
		}
		System.out.println("1: Save\n2: Save As\n");
		int ch = Utility.isValidInteger();
		switch (ch) {
		case 1:
			Control.writeBook(book, spath); // save in open file
			System.out.println("Save changes..");
			break;
		case 2:
			Fileservice file = Instance.getFileInstance();
			file.saveAs(book); // save in new file
			break;
		default:
			System.out.println("invalid choice");
			break;
		}
	}

	// select updating information field
	private static void selectEditMenu(Person existingPerson) {
		System.out.println(
				"1: Lastname\n" + "2: Address \n" + "3: State\n" + "4: City\n" + "5: Zipcode\n" + "6: Contact\n");
		int choice = Utility.isValidInteger();
		switch (choice) {
		case 1:
			System.out.println("new lastname");
			existingPerson.setLastName(Utility.isString()); // set lastname
			break;
		case 2:
			System.out.print("New Address : ");
			existingPerson.setAddress(Utility.isString()); // set new address
			break;
		case 3:
			System.out.println("new state");
			existingPerson.setState(Utility.isString()); // set new state
			break;
		case 4:
			System.out.println("new city");
			existingPerson.setCity(Utility.isString()); // set new city
			break;
		case 5:
			System.out.println("new zipcode");
			existingPerson.setZipcode(Utility.isStringInt(Utility.scanner.next())); // set new code
			break;
		case 6:
			System.out.println("new phone");
			existingPerson.setPhone(Utility.isStringInt(Utility.scanner.next())); // set new contact number
			break;
		default:
			break;
		}
	}

	// display all names in sorted form
	public void sortbyName() {
		book = Control.readBook(spath);
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
					System.out.println(person2.toString());

				}
			}
		}
	}

	// display sorted contacts by zip-codes
	public void sortbyZip() {
		book = Control.readBook(spath);
		List<Person> displaylist = book;
		ArrayList<String> sort = new ArrayList<String>();
		for (Person person2 : displaylist) {
			sort.add(person2.getZipcode());
		}
		Collections.sort(sort); // sort by name
		for (int i = 0; i < displaylist.size(); i++) {
			for (Person person2 : displaylist) {
				if (sort.get(i).equals(person2.getZipcode())) {
					System.out.println();
					System.out.println("*********************" + (i + 1) + "************************");
					System.out.println();
					System.out.println(person2.toString());

				}
			}
		}
	}

	// show all books of persons
	public void displayPerson() {
		System.out.println("***********Book**************");
		for (Person person2 : book) {
			System.out.println(person2.FirstName);
		}
	}

	// delete person record from file
	public void deletePerson() {
		System.out.println("enput person fname");
		String fname = Utility.isString();
		for (Person person : book) {
			if (fname.equals(person.FirstName)) {
				book.remove(person); // remove record
			}
		}
		Control.writeBook(book, spath);
	}

	// search person details
	public void searchPerson() {
		System.out.println("Reading JSON from a file");
		System.out.println("----------------------------");
		System.out.println("enter first name for search");
		String inputstring = Utility.isString();
		boolean find = false;
		for (Person person22 : book) {
			if (person22.FirstName.equals(inputstring)) {
				find = true;
				System.out.println(person22.toString());
			}
		}
		if (!find) {
			System.out.println("contact not found!...");
		}
	}



}
