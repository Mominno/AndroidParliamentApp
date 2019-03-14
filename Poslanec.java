import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Poslanec{
	
	int id_poslanec;
	int id_osoba;
	String id_kraj;
	int id_kandidatka;
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
	String foto ;

	public Poslanec(String line) {
		String[] list = line.split("\\|");

		if(list.length == 15){
			id_poslanec = Integer.parseInt(list[0]);
			id_osoba =  Integer.parseInt(list[1]);
			id_kraj = list[2];
			id_kandidatka = Integer.parseInt(list[3]);
			id_obdobi =  Integer.parseInt(list[4]);
			web = list[5];
			ulice = list[6];	
			obec = list[7];	
			psc = list[8];
			email = list[9];
			telefon = list[10]; 
			fax = list[11];
			psp_telefon = list[12];
			facebook = list[13];
			foto = list[14];
		}
		else{
			id_poslanec = Integer.parseInt(list[0]);
			id_osoba =  Integer.parseInt(list[1]);
			id_kraj = list[2];
			id_kandidatka = Integer.parseInt(list[3]);
			id_obdobi =  Integer.parseInt(list[4]);
			web = list[5];
			ulice = list[6];	
			obec = list[7];	
			psc = list[8];
			email = list[9];
			telefon = list[10]; 
			fax = list[11];
			psp_telefon = list[12];
			facebook = list[13];
			foto = "0";
		}
	}
	public int getIdPoslanec(){
		return id_poslanec;
	}
	public int getIdOsoba() {
		return id_osoba;
	}
	public String getIdKraj() {
		return id_kraj;
	}
	public int getIdKandidatka(){
		return id_kandidatka;
	}
	public int getIdObdobi(){
		return id_obdobi;
	}
	public String getWeb(){
		return web;
	}
	public String getUlice(){
		return ulice;
	}
	public String getObec(){
		return obec;
	}
	public String getPsc(){
		return psc;
	}
	public String getEmail(){
		return email;
	}
	public String getTelefon(){
		return telefon;
	}
	public String getFax(){
		return fax;
	}
	public String getPspTelefon(){
		return psp_telefon;
	}
	public String getFacebook(){
		return facebook;
	}
	public String getFoto(){
		return foto;
	}
	public int getId_votingTerm() {
		return id_obdobi;
	}


}

