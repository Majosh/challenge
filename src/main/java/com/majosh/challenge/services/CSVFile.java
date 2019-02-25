package com.majosh.challenge.services;

import java.io.File;

public class CSVFile {

	protected XtableService service;
	
	protected File file;

	public XtableService getService() {
		return service;
	}

	public void setService(XtableService service) {
		this.service = service;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
}
