package com.bridgelabz.felloship.source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class test {

	static Scanner sc = new Scanner(System.in);
	static List<Person> book;
	public static String spath;
	
	public static void selectaction() throws IOException {

		int choice;
		do {
			System.out.println("****File operations :*****");
			System.out.println("1: New User\n" + "2: Update User\n" + "3: Delete User\n" + "4: Search User\n"
					+ "5: Display sorted Book\n" + "6: Back\n"+"7:Exit\n");

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

		Gson gson = new Gson();
		book = new ArrayList<Person>();
		BufferedReader br = new BufferedReader(new FileReader(spath));
		Person[] person = gson.fromJson(br, Person[].class);
		for (Person person2 : person) {
			book.add(person2);
			// getPerson(person2);
			// System.out.println();
		}

		System.out.print("enter user firstName: ");
		String firstName = sc.next();
		System.out.print("enter user lastName: ");
		String lastName = sc.next();
		System.out.print("enter user address: ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("enter state , city , zip code : ");
		String state = sc.next();
		String city = sc.next();
		String zipcode = sc.next();
		System.out.print("enter the phone number: ");
		String phone = sc.next();

		Person newperson = new Person(firstName, lastName, address, state, city, zipcode, phone);
		// isSave(newperson, spath);
		book.add(newperson);
		savebook(book);
	}

	public static void savebook(List<Person> book2) throws IOException {

		FileWriter writer = new FileWriter(
				"/home/admin1/Desktop/JavaProject/AddressBook/src/utilityaddressbook/demo.json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// System.out.println(gson.toJson(book));
		writer.write(gson.toJson(book2));

		writer.close();
	}

	public static void getPersonDetails(Person person22) {
		System.out.println(" FirstName : " + person22.FirstName + "\n LastName  : " + person22.LastName
				+ "\n Address   : " + person22.Address + "\n State     : " + person22.State + "\n City      : "
				+ person22.City + "\n Zip-code  : " + person22.zipcode + "\n Contact   : " + person22.phone);
	}

	public static void updatefile() throws IOException {
		Gson gson = new Gson();
		System.out.println("enter first name for search");
		String inputstring = sc.next();
		BufferedReader br = new BufferedReader(new FileReader(spath));

		boolean find = false;

		Person[] person2 = gson.fromJson(br, Person[].class);

		for (Person person22 : person2) {
			if (person22.FirstName.equals(inputstring)) {
				find = true;
				System.out.print("New Address : ");
				String newaddress = sc.next();
				person22.Address = newaddress;

				getPersonDetails(person22);
			}
		}

		if (!find) {
			System.out.println("contact not found!...");
		}

		// close reader
		br.close();
	}

	public static void SortbyName() throws FileNotFoundException {
		Gson gson = new Gson();
		ArrayList<String> al = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(spath));
		Person[] person = gson.fromJson(bufferedReader, Person[].class);
		for (Person person2 : person) {
			al.add(person2.FirstName);
		}
		Collections.sort(al);
		for (int i = 0; i < al.size(); i++) {
			for (Person person2 : person) {
				if (al.get(i).equals(person2.FirstName)) {
					System.out.println();
					System.out.println("*********************" + (i + 1) + "************************");
					System.out.println();

					getPersonDetails(person2);
				}
			}
		}
	}

	public static void displaybook() throws FileNotFoundException {
		System.out.println("***********Book**************");
		Gson gson = new Gson();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(spath));
		Person[] person = gson.fromJson(bufferedReader, Person[].class);
		for (Person person2 : person) {
			getPersonDetails(person2);
		}

	}

	public static void deletePerson() throws IOException {
		Gson gson = new Gson();
		List<Person> al = new ArrayList<Person>();
		System.out.println("enput person fname");
		String fname = sc.next();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(spath));
		Person[] persons = gson.fromJson(bufferedReader, Person[].class);
		for (Person person : persons) {
			Gson gsonsub = new Gson();
			if (fname.equals(person.FirstName)) {
				continue;
			}
			al.add(person);

			// getPerson(person);
			System.out.println(gsonsub.toJson(person));
		}
		savebook(al);
	}

	public static void read() throws IOException {

		System.out.println("Reading JSON from a file");
		System.out.println("----------------------------");

		System.out.println("enter first name for search");
		String inputstring = sc.next();

		Gson gson = new Gson();

		BufferedReader br = new BufferedReader(new FileReader(spath));

		boolean find = false;

		Person[] person2 = gson.fromJson(br, Person[].class);

		for (Person person22 : person2) {
			if (person22.FirstName.equals(inputstring)) {
				find = true;

				getPersonDetails(person22);
			}
		}

		if (!find) {
			System.out.println("contact not found!...");
		}

		// close reader
		br.close();

	}

}
