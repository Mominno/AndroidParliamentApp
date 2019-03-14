import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.*;
import java.util.Scanner;

public class GPS{
	int id_poslanec;
	String adresa;
	float delka;
	float sirka;

	public GPS(String line) {
		String[] list = line.split("\\|");
		if(list.length == 4){
			id_poslanec = Integer.parseInt(list[0]);
			adresa = list[1];
			delka = Float.parseFloat(list[2]);
			sirka = Float.parseFloat(list[3]);
		}
		else{
			System.out.println("Error:Organ.java - line shorter then 7");
		}
	}
}

