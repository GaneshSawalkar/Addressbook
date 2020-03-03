package com.bridgelabz.fellowship.serviceimplement;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.fellowship.control.Control;
import com.bridgelabz.fellowship.main.Addressbook;
import com.bridgelabz.fellowship.model.Person;
import com.bridgelabz.fellowship.service.Fileservice;

public class Fileserviceimplents implements Fileservice {

	public static Scanner scanner = new Scanner(System.in);
	// default file path
	public static String FilePath = "src/com/bridgelabz/fellowship/files/";
	static File file;
	static String phonenumber, zip;

	// create new json file.
	public void createFile() {
		System.out.print("\nEnter new json file :");
		String newfile = scanner.next();
		String mypath = FilePath;
		mypath = mypath + newfile + ".json";
		try {
			file = new File(mypath);
			if (!file.exists()) { // if not exist then create file
				file.createNewFile();
				System.out.println(newfile + ".json" + " Created Sucessfully");
				System.out.println("\n1 read/write book\n" + "2 back\n");
				System.out.print("enter choice : ");
				int ch = Utility.isValidInteger();
				switch (ch) {
				case 1:
					// Initialized file and add " [ ] " in file
					FileWriter writer = new FileWriter(mypath);
					PrintWriter printWriter = new PrintWriter(writer);
					printWriter.printf("[ ]");
					printWriter.close();

					// set file path
					Servicesimplements.spath = mypath;
					Servicesimplements.selectaction(); // open operation menu
					break;
				case 2:
					back(); // get back into file menu
					break;
				default:
					break;
				}
			} else {
				System.out.println("\nFile already exist with that name. Change name please.");
				createFile();
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
	public void openFile() {
		file = new File(FilePath);
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
		System.out.println("enter the File number: ");
		int userdefine = Utility.isValidInteger();
		mypath = FilePath + allfiles.get(userdefine - 1); // file path with user choice file
		System.out.println();
		try {
			Servicesimplements.spath = mypath;
			List<Person> book = Control.readBook(mypath);
		} catch (Exception e) {
			System.out.println("file not found!");
			openFile(); // file not found then again try to open
		}
		System.out.println(allfiles.get(userdefine - 1) + ".json file is opened");
	}

	/**
	 * @param book updated book received
	 */
	// updated file changes save in different files
	public void saveAs(List<Person> book) {
		try {
			System.out.println("enter new json file name");
			String newfile = scanner.next();
			String savepath = FilePath + newfile + ".json";
			// create new a file
			file = new File(savepath);
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("created sucessfully");
			} else {
				System.out.println("already created with that name.\n plz change name.");
			}
			// save changes in new file( savepath => new file name)
			Control.writeBook(book, savepath);
			System.out.println("Create & save successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	// get back from main menu
	public void back() {
		try {
			Addressbook.action();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readBook() {
		Servicesimplements services = new Servicesimplements();
		services.sortbyName();
	}

}
