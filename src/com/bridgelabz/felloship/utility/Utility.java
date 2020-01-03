package com.bridgelabz.felloship.utility;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.felloship.source.AddressBook;
import com.bridgelabz.felloship.source.Person;
import com.bridgelabz.felloship.source.test;

public class Utility {
	static Scanner scanner = new Scanner(System.in);
	static String spath = "/home/admin1/Desktop/JavaProject/com.bridgelbz.felloship.addressbook/src/com/bridgelabz/felloship/utility/";
	static File file;
	static List<Person> book;

	public static void createfile() {
		System.out.print("\nEnter new json file :");
		String newfile = scanner.next();
		String mypath = spath;
		mypath = mypath + newfile + ".json";

		try {
			file = new File(mypath);
			if (!file.exists()) {
				file.createNewFile();

				System.out.println("\n Created Sucessfully");

				System.out.println("\n1 read/write book\n" + "2 back\n");
				System.out.print("enter choice : ");
				int ch = scanner.nextInt();
				switch (ch) {
				case 1:
					readwritebook(spath);
					break;
				case 2:
					back();
					break;

				default:
					break;
				}

			} else {
				System.out.println("\nFile already exist with that name. Change name please.");
				createfile();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void openfile() {

		try {
			file = new File(spath);
			// String[] str = file.list();
			File[] files = file.listFiles(new FilenameFilter() {

				// only open json files
				public boolean accept(File dir, String name) {
					if (name.toLowerCase().endsWith(".json")) {
						return true;
					} else {
						return false;
					}
				}
			});
			for (File f : files) {
				System.out.println(f.getName());
			}

			System.out.println("which file you wnt to open?");
			String openfile = scanner.next();
			spath = "/home/admin1/Desktop/JavaProject/AddressBook/src/utilityaddressbook/" + openfile + ".json";
			System.out.print("opening");
			for (int i = 1; i <= 5; i++) {
				// Thread.sleep(1000);
				System.out.print(".");
			}
			System.out.println();

			System.out.println(openfile + ".json file is opened");
			test.spath = spath;
			test.selectaction();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void saveBook() throws IOException {

	}
	
	public static void saveas() throws IOException {
		try {
			spath = "/home/admin1/Desktop/JavaProject/AddressBook/src/utilityaddressbook";
			System.out.println("enter new json file name");
			String newfile = scanner.next();
			spath = "/home/admin1/Desktop/JavaProject/AddressBook/src/utilityaddressbook/" + newfile + ".json";

			file = new File(spath);
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("created sucessfully");
				System.out.println("Create & save successfully....");
			} else {
				System.out.println("already created with that name.\n plz change name.");
				// test.savebook(spath, book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void back() throws IOException {
		AddressBook.action();
	}

	public static void readwritebook(String spath) throws IOException {
		test.selectaction();
	}

}
