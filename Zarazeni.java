import java.util.Arrays;
import java.util.List;

import java.util.*;
import java.text.*;

import java.util.Scanner;

public class Zarazeni{
	int id_Osoba;
	int id_OF;
	boolean funkce;
	SimpleDateFormat datumOd;
	SimpleDateFormat datumDo;
	SimpleDateFormat mandatOd;
	SimpleDateFormat mandatDo;
	
	public Zarazeni() {
		id_Osoba = 0;
		id_OF = 9999;
		funkce = false;
		datumOd = new SimpleDateFormat("1900-01-01");
		datumDo = new SimpleDateFormat("1900-01-01");
		mandatOd = new SimpleDateFormat("1900-01-01");
		mandatDo = new SimpleDateFormat("1900-01-01");
	
	}
	public Zarazeni(String line) {
		String[] list = line.split("\\|");
		if(list.length == 7){
			id_Osoba = Integer.parseInt(list[0]);
			id_OF = Integer.parseInt(list[1]);
			funkce = (Integer.parseInt(list[2]) == 0) ? false : true;
			datumOd = new SimpleDateFormat(list[3]);
			datumDo = new SimpleDateFormat(list[4]);
			mandatOd =new SimpleDateFormat(list[5]);
			mandatDo =new SimpleDateFormat(list[6]);
		}
		else if(list.length == 6){
			id_Osoba = Integer.parseInt(list[0]);
			id_OF = Integer.parseInt(list[1]);
			funkce = (Integer.parseInt(list[2]) == 0) ? false : true;
			datumOd = new SimpleDateFormat(list[3]);
			datumDo = new SimpleDateFormat(list[4]);
			mandatOd =new SimpleDateFormat(list[5]);

		}
		else if(list.length == 5){
			id_Osoba = Integer.parseInt(list[0]);
			id_OF = Integer.parseInt(list[1]);
			funkce = (Integer.parseInt(list[2]) == 0) ? false : true;
			datumOd = new SimpleDateFormat(list[3]);
			datumDo = new SimpleDateFormat(list[4]);
		}
		else if(list.length == 4){
			id_Osoba = Integer.parseInt(list[0]);
			id_OF = Integer.parseInt(list[1]);
			funkce = (Integer.parseInt(list[2]) == 0) ? false : true;
			datumOd = new SimpleDateFormat(list[3]);
		}
		else{
			System.out.println("Error:Zarazeni.java - line shorter then 4");
		}
		
	
	}
	public int getIdOsoba(){
		return id_Osoba;
	}
	public int getIdOF(){
		return id_OF;
	}
	public boolean isFunkce(){
		return funkce;
	}
	public String getMandatOdDo(){
		String date1;
		String date2;
		if(mandatOd != null) {
			date1 = mandatOd.format(new Date());
		}
		else{
			date1 = datumOd.format(new Date());	
		}
		if(mandatDo != null){
			date2 = mandatDo.format(new Date());
			return date1 + " do " + date2;
		}
		else{
			if(datumDo != null){
				date2 = datumDo.format(new Date());	
				return date1 + " do " + date2;
			}
			return date1 + " dosud";
		}
	}
	
}

