package com.bridgelabz.fellowship.service;

import java.util.List;

import com.bridgelabz.fellowship.model.Person;

public interface FileService {
	void CreateFile();

	void OpenFile();

	void Back();

	void SaveAs(List<Person> l);

	void readbook();

}
