package com.bridgelabz.fellowship.serviceimplement;

public class Instance {
	private static ServicesImplements service;
	private static FileServiceImplents file;

	public Instance() {
	}

	public static ServicesImplements getServiceInstance() {
		if (service == null) {
			service = new ServicesImplements();
		}
		return service;
	}

	public static FileServiceImplents getFileInstance() {
		if (file == null) {
			file = new FileServiceImplents();
		}
		return file;
	}
}
