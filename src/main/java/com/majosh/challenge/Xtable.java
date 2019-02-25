package com.majosh.challenge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tableX")
public class Xtable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String columnA,
	               columnB,
	               columnC,
	               columnD,
	               columnE,
	               columnF,
	               columnG,
	               columnH,
	               columnI,
	               columnJ;


	public Xtable(String columnA, String columnB, String columnC, String columnD, String columnE, String columnF,
			String columnG, String columnH, String columnI, String columnJ) {
		super();
		this.columnA = columnA;
		this.columnB = columnB;
		this.columnC = columnC;
		this.columnD = columnD;
		this.columnE = columnE;
		this.columnF = columnF;
		this.columnG = columnG;
		this.columnH = columnH;
		this.columnI = columnI;
		this.columnJ = columnJ;
	}


	public Xtable() {
		super();
		
	}


	public String getColumnA() {
		return columnA;
	}


	public void setColumnA(String columnA) {
		this.columnA = columnA;
	}


	public String getColumnB() {
		return columnB;
	}


	public void setColumnB(String columnB) {
		this.columnB = columnB;
	}


	public String getColumnC() {
		return columnC;
	}


	public void setColumnC(String columnC) {
		this.columnC = columnC;
	}


	public String getColumnD() {
		return columnD;
	}


	public void setColumnD(String columnD) {
		this.columnD = columnD;
	}


	public String getColumnE() {
		return columnE;
	}


	public void setColumnE(String columnE) {
		this.columnE = columnE;
	}


	public String getColumnF() {
		return columnF;
	}


	public void setColumnF(String columnF) {
		this.columnF = columnF;
	}


	public String getColumnG() {
		return columnG;
	}


	public void setColumnG(String columnG) {
		this.columnG = columnG;
	}


	public String getColumnH() {
		return columnH;
	}


	public void setColumnH(String columnH) {
		this.columnH = columnH;
	}


	public String getColumnI() {
		return columnI;
	}


	public void setColumnI(String columnI) {
		this.columnI = columnI;
	}


	public String getColumnJ() {
		return columnJ;
	}


	public void setColumnJ(String columnJ) {
		this.columnJ = columnJ;
	}


	@Override
	public String toString() {
		return "Xtable [columnA=" + columnA + ", columnB=" + columnB + ", columnC=" + columnC + ", columnD=" + columnD
				+ ", columnE=" + columnE + ", columnF=" + columnF + ", columnG=" + columnG + ", columnH=" + columnH
				+ ", columnI=" + columnI + ", columnJ=" + columnJ + "]";
	}
	
	public void cleanComma() {
		this.columnA = this.columnA.contains(",") ? "\"" + this.columnA +"\"" : this.columnA;
		this.columnB = this.columnB.contains(",") ? "\"" + this.columnB +"\"" : this.columnB;
		this.columnC = this.columnC.contains(",") ? "\"" + this.columnC +"\"" : this.columnC;
		this.columnD = this.columnD.contains(",") ? "\"" + this.columnD +"\"" : this.columnD;
		this.columnE = this.columnE.contains(",") ? "\"" + this.columnE +"\"" : this.columnE;
		this.columnF = this.columnF.contains(",") ? "\"" + this.columnF +"\"" : this.columnF;
		this.columnG = this.columnG.contains(",") ? "\"" + this.columnG +"\"" : this.columnG;
		this.columnH = this.columnH.contains(",") ? "\"" + this.columnH +"\"" : this.columnH;
		this.columnI = this.columnI.contains(",") ? "\"" + this.columnI +"\"" : this.columnI;
		this.columnJ = this.columnJ.contains(",") ? "\"" + this.columnJ +"\"" : this.columnJ;
	}
	
}
