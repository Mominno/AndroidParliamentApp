import java.util.Arrays;
import java.util.List;

import java.util.*;
import java.text.*;

import java.util.Scanner;

public class Typ_Funkce{

	int id_Typ_Funkce;
	int id_Typu_Organu;
	String nazev_FunkceCS;
	String nazev_FunkceEN;
	int priorita;
	int typ_funkce;
	
	public Typ_Funkce() {
		id_Typ_Funkce = 0;
		id_Typu_Organu = 0;
		nazev_FunkceCS = "WTF";
		nazev_FunkceEN = "WTF";
		priorita = 0;
		typ_funkce = 0;
	
	}
	public Typ_Funkce(String line) {
		String[] list = line.split("\\|");
		if(list.length == 6){
			id_Typ_Funkce = Integer.parseInt(list[0]);
			id_Typu_Organu = Integer.parseInt(list[1]);
			nazev_FunkceCS = list[2];
			nazev_FunkceEN = list[3];
			priorita = Integer.parseInt(list[4]);
			typ_funkce = Integer.parseInt(list[5]);
		}
		else if(list.length == 5){
			id_Typ_Funkce = Integer.parseInt(list[0]);
			id_Typu_Organu = Integer.parseInt(list[1]);
			nazev_FunkceCS = list[2];
			nazev_FunkceEN = list[3];
			priorita = Integer.parseInt(list[4]);
		}
		else{
			System.out.println("Error:Funkce.java - line shorter then 5");
		}
		
	
	}
}

