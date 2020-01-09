package com.bridgelabz.felloship.source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Control {
	static String filepath;
	public static Gson gson;

	public static ArrayList<Person> readbook(String filepath) {
		ArrayList<Person> list = new ArrayList<Person>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			list = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Person>>() {
			}.getType());
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static void writebook(List<Person> book, String filepath) {
		try {
			FileWriter writer = new FileWriter(filepath);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// System.out.println(gson.toJson(book));
			writer.write(gson.toJson(book));
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
