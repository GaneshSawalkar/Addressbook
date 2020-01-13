package com.bridgelabz.felloship.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.felloship.model.Person;
import com.bridgelabz.felloship.control.Control;
import com.bridgelabz.felloship.main.AddressBook;
import com.bridgelabz.felloship.main.Operations;

public class Utility {

	public static Scanner scanner = new Scanner(System.in);
	// default file path
	public static String spath = "/home/admin1/Desktop/Addressbook/src/com/bridgelabz/felloship/files/";
	static File file;
	static String phonenumber, zip;

	// create new json file.
	public static void createfile() {
		System.out.print("\nEnter new json file :");
		String newfile = scanner.next();
		String mypath = spath;
		mypath = mypath + newfile + ".json";
		try {
			file = new File(mypath);
			if (!file.exists()) { // if not exist then create file
				file.createNewFile();
				System.out.println(newfile + ".json" + " Created Sucessfully");
				System.out.println("\n1 read/write book\n" + "2 back\n");
				System.out.print("enter choice : ");
				int ch = Utility.isvalidInteger();
				switch (ch) {
				case 1:

					// Initialized file and add " [ ] " in file
					FileWriter writer = new FileWriter(mypath);
					PrintWriter printWriter = new PrintWriter(writer);
					printWriter.printf("[ ]");
					printWriter.close();

					// set file path
					Operations.spath = mypath;
					Operations.selectaction(); // open operation menu
					break;
				case 2:
					back(); // get back into file menu
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

	/**
	 * @throws IOException throw file not found exception
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	// open existing file using filename
	public static void openfile() {
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
		@SuppressWarnings("rawtypes")
		List allfiles = new ArrayList();
		int i = 0;
		for (File f : files) {
			System.out.println((i + 1) + "-> " + f.getName());
			allfiles.add(f.getName()); // save all files name in list and display
			i++;
		}
		String mypath = "";
		System.out.println("which file you wnt to open?");
		System.out.println("enter the number: ");
		int userdefine = Utility.isvalidInteger();
		mypath = spath + allfiles.get(userdefine - 1); // file path with user choice file
		System.out.println();
		try {
			Operations.spath = mypath;
			List<Person> book = Control.readbook(mypath);
		} catch (Exception e) {
			System.out.println("file not found!");
			openfile(); // file not found then again try to open
		}
		System.out.println(allfiles.get(userdefine - 1) + ".json file is opened");
	}

	// get back from main menu
	public static void back() throws IOException {
		AddressBook.action();
	}

	/**
	 * @param book updated book received
	 */
	// updated file changes save in different files
	public static void saveAs(List<Person> book) {
		try {
			System.out.println("enter new json file name");
			String newfile = scanner.next();
			String savepath = spath + newfile + ".json";
			// create new a file
			file = new File(savepath);
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("created sucessfully");
			} else {
				System.out.println("already created with that name.\n plz change name.");
			}
			// save changes in new file( savepath => new file name)
			Control.writebook(book, savepath);
			System.out.println("Create & save successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int isvalidInteger() {
		int i = 0;
		boolean ok = true;
		while (ok) {
			try {

				i = scanner.nextInt();
				ok = false;
			} catch (InputMismatchException e) {
				System.out.println("Not integer value.");
				System.out.print("select again: ");
				scanner.next();
			}
		}

		return i;
	}

	public static String isStringInt(String integer) {
		try {
			int check = Integer.parseInt(integer);
		} catch (NumberFormatException e) {
			System.out.println("invalid format enter again:");
			integer = isStringInt(scanner.next());
		}
		return integer;
	}

	public static String isString() {
		String input;
		boolean flag = false;
		do {
			input = scanner.next();
			if (input.matches("^[a-zA-Z]*$")) {
				flag = true;
			} else {
				System.out.print("Wrong input..! type again :");
			}
		} while (!flag);
		return input;
	}

	public static String isvalidphone() {
		phonenumber = scanner.next();
		Pattern pattern = Pattern.compile("[7-9][0-9]{9}");
		Matcher matcher = pattern.matcher(phonenumber);
		if (matcher.find()) {
			return phonenumber;
		} else {
			System.out.println("number must be 10 digit & start with 7-9");
			isvalidphone();
		}
		return phonenumber;

	}

	public static String isvalidzip() {
		zip = isStringInt(scanner.next());
		Pattern pattern = Pattern.compile("^[0-9]{6}$");
		Matcher matcher = pattern.matcher(zip);
		if (matcher.find()) {
			return zip;
		} else {
			System.out.println("zip code must be 6 digit");
			isvalidzip();
		}
		return zip;

	}
}
