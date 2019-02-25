package com.majosh.challenge.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.majosh.challenge.TechnicalTest;
import com.majosh.challenge.Xtable;
import com.opencsv.CSVReader;

public class Process {

	protected XtableService service;
	private CSVReader reader;
	private int success,
			total,
			failed;
	
	private List<String[]> badData;
	
	public Process() {
		this.service = new XtableService();
		this.badData = new ArrayList();
		reader = null;
		reader = null;
	}
	
	public void readCsv(File file) throws FileNotFoundException, URISyntaxException {
		reader = null;
		reader = new CSVReader(
				new FileReader(file));	
	}
	
	public void saveXtable() throws IOException {
		success = 0;
		total = 0;
		failed = 0;
		
		String [] line;
		this.service.configureSessionFactory();
		this.service.startTransaction();
		
		while((line = reader.readNext()) != null && line.length > 1) {
			total++;
			if(line.length < 10 || line.length> 10) {
				this.badData.add(line);
				failed++;
			}else {
				Xtable row = new Xtable(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8], line[9]);
				row.cleanComma();
				if(row.isAllFieldsValid()) {
					this.service.saveRecord(row);
					success++;
				}else {
					this.badData.add(line);
					failed++;
				}
			}
		}
		this.service.commitTransaction();
		
	}
	
	public void logBadRecord() throws IOException, URISyntaxException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date d = new Date(System.currentTimeMillis());
		
		File f = new File(TechnicalTest.class.getResource("baddata").toURI());
		if(f.exists() && f.isDirectory()) { 
			System.out.println("baddata folder was found");
			FileWriter fw = new FileWriter("bad-data-"+sdf.format(d)+".csv");
			PrintWriter out = new PrintWriter(fw);

			out.print("A");
			out.print(",");
			out.print("B");
			out.print(",");
			out.print("C");
			out.print(",");
			out.print("D");
			out.print(",");
			out.print("E");
			out.print(",");
			out.print("F");
			out.print(",");
			out.print("G");
			out.print(",");
			out.print("H");
			out.print(",");
			out.print("I");
			out.print(",");
			out.println("J");
			
			for(String[] data : this.badData) {
				int ctr = 0;
				for(String datum: data) {
					
					if(ctr>1) {
						out.print(",");
					}
					
					if(ctr == data.length - 1) {
						out.println(datum);
					}else {
						out.print(datum);
					}
					
					ctr++;
				}
			}
			
			  
		   //Flush the output to the file
		   out.flush();
		       
		   //Close the Print Writer
		   out.close();
		       
		   //Close the File Writer
		   fw.close();       
		   System.out.println("Closing");
		}
		System.out.println("End of badRecord");
		
	}
	
	public void logResult() throws IOException, URISyntaxException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date d = new Date(System.currentTimeMillis());
		
		File file = new File("log-file-"+sdf.format(d)+".txt");
		file.createNewFile();
		
		FileWriter fw = new FileWriter("log-file-"+sdf.format(d)+".txt");
		PrintWriter out = new PrintWriter(fw);
		
		out.println("Total number of records received: " + this.total);
		out.println("Total number of records successful: " + this.success);
		out.println("Total number of records failed: " + this.failed);
		
		  
	    //Flush the output to the file
	    out.flush();
	       
	    //Close the Print Writer
	    out.close();
	       
	    //Close the File Writer
	    fw.close();
	    
	    
	}
}
