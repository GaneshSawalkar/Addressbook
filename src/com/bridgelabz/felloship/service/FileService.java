package com.bridgelabz.felloship.service;

import java.util.List;

import com.bridgelabz.felloship.model.Person;

public interface FileService {
	void CreateFile();

	void OpenFile();

	void Back();

	void SaveAs(List<Person> l);

	void readbook();
}
