import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.*;
import java.util.Scanner;

public class Osoba{

	public static List<Osoba> osoby;
	int id_Osoba;
	String titulPred;
	String jmeno;
	String prijmeni;
	String titulZa;
	SimpleDateFormat narozeni;	
	String pohlavi;	
	SimpleDateFormat zmena;
	SimpleDateFormat umrti;
	
	public Osoba() {
		int id_Osoba = -420;
	}

	public Osoba(String line) {
		String[] list = line.split("\\|");
		
		if(list.length == 9){
			id_Osoba = Integer.parseInt(list[0]);
			titulPred= list[1];
			jmeno	 = list[2];
			prijmeni = list[3];
			titulZa  = list[4];
			narozeni = new SimpleDateFormat(list[5]);	
			pohlavi  = list[6];	
			zmena 	 = new SimpleDateFormat(list[7]);
			umrti 	 = new SimpleDateFormat(list[8]);
		}
		else if(list.length == 8){
			id_Osoba = Integer.parseInt(list[0]);
			titulPred= list[1];
			jmeno	 = list[2];
			prijmeni = list[3];
			titulZa  = list[4];
			narozeni = new SimpleDateFormat(list[5]);	
			pohlavi  = list[6];	
			zmena 	 = new SimpleDateFormat(list[7]);	
		}
		else if(list.length == 7){
			id_Osoba = Integer.parseInt(list[0]);
			titulPred= list[1];
			jmeno	 = list[2];
			prijmeni = list[3];
			titulZa  = list[4];
			narozeni = new SimpleDateFormat(list[5]);	
			pohlavi  = list[6];	
		}
		else{
			System.out.println("Error:Osoba.java - line shorter then 7");
		}
	}

	public int getId_Osoba() {
		return id_Osoba;
	}

	public String getTitulPred(){
		return titulPred;
	}

	public String getJmeno(){
		return jmeno;
	}
	public String getPrijmeni(){
		return prijmeni;
	}
	public String getTitulZa(){
		return titulZa;
	}
	public SimpleDateFormat getNarozeni(){
		return narozeni;
	}
	public String getPohlavi(){
		return pohlavi;
	}
	public SimpleDateFormat getZmena(){
		return zmena;
	}
	public SimpleDateFormat getUmrti(){
		return umrti;
	}

	public String getCeleJmeno(){
		return titulPred + jmeno + prijmeni + titulZa;
	}
}

