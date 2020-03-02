package com.bridgelabz.fellowship.serviceimplement;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

	public static Scanner scanner = new Scanner(System.in);
	// default file path
	public static String spath = "/home/admin1/Documents/OOPSPrograms/addressbook/src/com/bridgelabz/felloship/utility/";
	static File file;
	static String phonenumber, zip;

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
