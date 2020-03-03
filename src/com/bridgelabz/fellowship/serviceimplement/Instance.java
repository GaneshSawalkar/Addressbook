package com.bridgelabz.fellowship.serviceimplement;

public class Instance {
	private static Servicesimplements service;
	private static Fileserviceimplents file;

	public Instance() {
	}

	public static Servicesimplements getServiceInstance() {
		if (service == null) {
			service = new Servicesimplements();
		}
		return service;
	}

	public static Fileserviceimplents getFileInstance() {
		if (file == null) {
			file = new Fileserviceimplents();
		}
		return file;
	}
}
