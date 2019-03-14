import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.*;
import java.util.Scanner;

public class Typ_Organu{
	int id_Typu;
	int id_NadrazenyOrgan;
	String nazevOrganuCS;
	String nazevOrganuEN;
	int obecny_Typ;
	int priorita;

	public Typ_Organu(String line) {
		String[] list = line.split("\\|");	

		for (int i =0;i<list.length;i++) {
			if(list[i].equals("")){
				list[i] = "-420";
			}
		}

		if(list.length == 6){
			id_Typu = Integer.parseInt(list[0]); 
			id_NadrazenyOrgan = Integer.parseInt(list[1]);
			nazevOrganuCS = list[2];
			nazevOrganuEN = list[3];
			obecny_Typ = Integer.parseInt(list[4]);
			priorita = Integer.parseInt(list[5]);
		}
		else if(list.length == 5){
			id_Typu = Integer.parseInt(list[0]); 
			id_NadrazenyOrgan = Integer.parseInt(list[1]);
			nazevOrganuCS = list[2];
			nazevOrganuEN = list[3];
			obecny_Typ = Integer.parseInt(list[4]);
		}
		else if(list.length == 3){
			id_Typu = Integer.parseInt(list[0]); 
			id_NadrazenyOrgan = Integer.parseInt(list[1]);
			nazevOrganuCS = list[2];
		}
		else{
			System.out.println("Error:Typ_Organu.java - line shorter then 5");
		}
	}
}

