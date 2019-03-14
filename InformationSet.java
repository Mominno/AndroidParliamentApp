import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.text.*;
import java.util.Scanner;

public class InformationSet{

	int id_poslanec;
	int id_osoba;
	String id_kraj;
	int id_kandidatka;
	String zkratkaOrganu;
	int id_obdobi;
	String web;
	String ulice;	
	String obec;	
	String psc;
	String email;
	String telefon; 
	String fax;
	String psp_telefon;
	String facebook;
	String foto;
	String titulPred;
	String jmeno;
	String prijmeni;
	String titulZa;
	SimpleDateFormat narozeni;	
	String pohlavi;
	SimpleDateFormat umrti;

	float gpsSirka;
	float gpsDelka;

	//Funkce funkce[];
	
	List<Integer> funkce = new ArrayList<Integer>();
	List<Integer> clenstvi = new ArrayList<Integer>();
	List<String> nazevFunkci = new ArrayList<String>();
	List<String> nazevClenstvi = new ArrayList<String>();
	List<Zarazeni> zarazeniFunkci = new ArrayList<Zarazeni>();
	List<Zarazeni> zarazeniClenstvi = new ArrayList<Zarazeni>();

	public InformationSet(Poslanec poslanec) {
		id_poslanec = poslanec.getIdPoslanec();
		id_osoba = poslanec.getIdOsoba();
		id_kraj = poslanec.getIdKraj();

		id_kandidatka = poslanec.getIdKandidatka();

		for (Organ org: Data.organy ) {
			if(id_kandidatka == org.getId_Organu()){
				zkratkaOrganu = org.getZkratka();
				break;
			}
		}

		for(Zarazeni zar: Data.zarazeni){
			if(zar.getIdOsoba() == id_osoba){
				if(zar.isFunkce()){
					zarazeniFunkci.add(zar);
					funkce.add(zar.getIdOF());	
				}
				else{
					zarazeniClenstvi.add(zar);
					clenstvi.add(zar.getIdOF());
				}
				
			}
		}
		// nacita funkce
		int j = 0;
		for(int i: funkce){
			Zarazeni zar = zarazeniFunkci.get(j);
			j++;
			String datum = zar.getMandatOdDo();
			for(Funkce fun: Data.funkce){
				if(i == fun.getIdFunkce() ){
					int f = fun.getIdOrganu();
					nazevFunkci.add(fun.getNazevCS() + " " + Data.getNazevOrganu(f) + "(" + Data.getZkratkuOrganu(fun.getIdOrganu()) + ")" + datum	 );
				}
			}
		}
		//nacita clenstvi
		j = 0;
		for (int i: clenstvi ) {
			Zarazeni zar = zarazeniClenstvi.get(j);
			j++;
			String datum = zar.getMandatOdDo();
			for(Organ org: Data.organy){
				if(i == org.getId_Organu() ){
					nazevClenstvi.add("Clen " + org.getNazevCS() + "(" + org.getZkratka() + ")" + datum);
				}
			}
		}
		


		id_obdobi = poslanec.getIdObdobi();
		web = poslanec.getWeb();
		ulice = poslanec.getUlice();	
		obec = poslanec.getObec();	
		psc = poslanec.getPsc();
		email = poslanec.getEmail();
		telefon = poslanec.getTelefon(); 
		fax = poslanec.getFax();
		psp_telefon = poslanec.getPspTelefon();
		facebook = poslanec.getFacebook();
		foto = poslanec.getFoto();

		Osoba osoba = new Osoba();

		for(Osoba o: Data.osoby){
			if(o.getId_Osoba() == id_osoba){
				osoba = o;
				break;
			}
		}
		titulPred = osoba.getTitulPred();
		jmeno = osoba.getJmeno();
		prijmeni = osoba.getPrijmeni();
		titulZa = osoba.getTitulZa();
		narozeni = osoba.getNarozeni();	
		pohlavi = osoba.getPohlavi();
		umrti = osoba.getUmrti(); 
	}
	
	public InformationSet(int idOsoby, List<Poslanec> poslanci, List<Osoba> osoby) {
		
	}

	public void print() {
		System.out.println("Jmeno: " + titulPred + jmeno + " " + prijmeni + titulZa  );
		System.out.println("Email: " + email);
		System.out.println("Telefon: " + telefon);
		System.out.println("Telefon - kancelar" + psp_telefon);
		System.out.println("Zvolen za " + zkratkaOrganu);
		System.out.println("Adresa:" + ulice);
		System.out.println("Obec:" + obec);
		System.out.println("Psc" + psc);

		//System.out.println("GPS kancelare(s,d):" + gpsSirka + "," + gpsDelka);
		System.out.println("===================");
	}

	public String seznamFunkci(){
		String seznam = "";
		for(String s:nazevFunkci){
			seznam += s + "\n ";
		}
		return seznam;
	}

	public String seznamClenstvi(){
		String seznam = "";
		for(String s:nazevClenstvi){
			seznam += s + "\n ";
		}
		return seznam;
	}

	public String writeInfo(){
		String seznam = seznamFunkci();
		String seznam2 = seznamClenstvi();
		return "Jmeno: " + titulPred + " " + jmeno + " " + prijmeni + " " + titulZa + "\n" + "Email: " + email + "\n" + "Telefon: " + telefon + "\n" + "Telefon - kancelar" + psp_telefon + "\n" + "Zvolen za " + zkratkaOrganu + "\n" +	"Adresa:" + ulice + "\n" + "Obec: " +  obec + "\n" + "Psc: " + psc + "\n" 	+ "Funkce: " + seznam + "\n" + seznam2 + "\n" +"====================== \n";
	}
}
