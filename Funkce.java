import java.util.Arrays;
import java.util.List;

import java.util.*;
import java.text.*;

import java.util.Scanner;

public class Funkce{
	int id_Funkce;
	int id_Organu;
	int id_Typ_Funkce;
	String nazevCS;
	int priorita;
	
	public Funkce() {
		id_Funkce = 0;
		id_Organu = 0;
		id_Typ_Funkce = 0;
		nazevCS = "NOPE";
		priorita = 0;
	
	}
	public Funkce(String line) {
		String[] list = line.split("\\|");
		if(list.length == 5){
			id_Funkce = Integer.parseInt(list[0]);
			id_Organu = Integer.parseInt(list[1]);
			id_Typ_Funkce = Integer.parseInt(list[2]);
			nazevCS = list[3];
			priorita = Integer.parseInt(list[4]);	
		}
		else{
			System.out.println("Error:Funkce.java - line shorter then 5");
		}
	}
	public int getIdFunkce(){
		return id_Funkce;
	}
	public String getNazevCS(){
		return nazevCS;
	}
	public int getIdOrganu(){
		return id_Organu;
	}
}

