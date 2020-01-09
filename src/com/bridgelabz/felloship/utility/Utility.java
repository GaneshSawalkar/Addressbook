package com.bridgelabz.felloship.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.bridgelabz.felloship.source.AddressBook;
import com.bridgelabz.felloship.source.Person;
import com.bridgelabz.felloship.source.Control;
import com.bridgelabz.felloship.source.Operations;

public class Utility {

	static Scanner scanner = new Scanner(System.in);
	// default file path
	public static String spath = "/home/admin1/Desktop/addressbook/src/com/bridgelabz/felloship/utility/";
	static File file;

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
				int ch = scanner.nextInt();
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
		int userdefine = scanner.nextInt();
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

}
