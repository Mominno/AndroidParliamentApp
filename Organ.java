import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.*;
import java.util.Scanner;

public class Organ{

	int id_Organu;
	int id_NadrazenyOrgan;
	int id_typOrganu;
	String zkratkaOrganu;
	String nazevOrganuCS;
	String nazevOrganuEN;
	SimpleDateFormat ustanoveni_Organu;
	SimpleDateFormat ukonceni_Organu;
	int priorita;
	int placeholder;

	public Organ(String line) {

		String[] list = line.split("\\|");	

		if(list[1].equals("")){
				id_NadrazenyOrgan = -1;
		}
		else{
			id_NadrazenyOrgan = Integer.parseInt(list[1]);
		}
		

		if(list.length == 10){
			id_Organu = Integer.parseInt(list[0]); 
			id_typOrganu = Integer.parseInt(list[2]);
			zkratkaOrganu = list[3];
			nazevOrganuCS = list[4];
			nazevOrganuEN = list[5];
			ustanoveni_Organu = new SimpleDateFormat(list[6]);
			ukonceni_Organu =   new SimpleDateFormat(list[7]);
			placeholder = Integer.parseInt(list[9]);

			if(list[8].equals("")){
				priorita = -1;
			}
			else{
				priorita = Integer.parseInt(list[8]);
			}

		}
		else if(list.length == 9){
			id_Organu = Integer.parseInt(list[0]); 
			//id_NadrazenyOrgan = Integer.parseInt(list[1]);
			id_typOrganu = Integer.parseInt(list[2]);
			zkratkaOrganu = list[3];
			nazevOrganuCS = list[4];
			nazevOrganuEN = list[5];
			ustanoveni_Organu = new SimpleDateFormat(list[6]);
			ukonceni_Organu =   new SimpleDateFormat(list[7]);
			if(list[8].equals("")){
				priorita = -1;
			}
			else{
				priorita = Integer.parseInt(list[8]);
			}
		}
		else if(list.length == 8){
			id_Organu = Integer.parseInt(list[0]); 
			//id_NadrazenyOrgan = Integer.parseInt(list[1]);
			id_typOrganu = Integer.parseInt(list[2]);
			zkratkaOrganu = list[3];
			nazevOrganuCS = list[4];
			nazevOrganuEN = list[5];
			ustanoveni_Organu = new SimpleDateFormat(list[6]);
			ukonceni_Organu =   new SimpleDateFormat(list[7]);

		}
		else if(list.length == 7){
			id_Organu = Integer.parseInt(list[0]); 
			//id_NadrazenyOrgan = Integer.parseInt(list[1]);
			id_typOrganu = Integer.parseInt(list[2]);
			zkratkaOrganu = list[3];
			nazevOrganuCS = list[4];
			nazevOrganuEN = list[5];
			ustanoveni_Organu = new SimpleDateFormat(list[6]);
		}
		else{
			System.out.println("Error:Organ.java - line shorter then 7");
		}
	}
	public String getZkratka(){
		return zkratkaOrganu;
	}
	public String getNazevCS(){
		return nazevOrganuCS;
	}
	public int getId_Organu(){
		return id_Organu;
	}
}

