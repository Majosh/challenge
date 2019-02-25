package com.majosh.challenge;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import com.majosh.challenge.services.Process;

public class TechnicalTest {
	
	public static void main(String[] args) {
		 Process process = new Process();
		 
		 try {
			process.readCsv(new File(TechnicalTest.class.getResource("csvfiles/sampleCSVData.csv").toURI()));
			process.saveXtable();
			process.logBadRecord();
			process.logResult();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
