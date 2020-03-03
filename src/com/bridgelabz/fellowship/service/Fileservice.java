package com.bridgelabz.fellowship.service;

import java.util.List;

import com.bridgelabz.fellowship.model.Person;

public interface Fileservice {
	void createFile();

	void openFile();

	void back();

	void saveAs(List<Person> l);

	void readBook();

}
