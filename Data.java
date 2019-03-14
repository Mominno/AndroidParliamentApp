import java.io.IOException;
import java.nio.charset.Charset;

import java.io.BufferedReader;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;



class Data{
	static String fileURL = "http://www.psp.cz/eknih/cdrom/opendata/poslanci.zip";
    static String saveDir = "./Parlament";
    static String filePoslanci = "/Extracted/poslanec.unl";
    static String fileOsoby = "/Extracted/osoby.unl";
    static String fileOrgany = "/Extracted/organy.unl";
    static String fileFunkce = "/Extracted/funkce.unl";
    static String fileTypFunkce = "/Extracted/typ_funkce.unl";
    static String fileTypOrganu = "/Extracted/typ_organu.unl";
    static String fileZarazeni = "/Extracted/zarazeni.unl";
    static String fileGPS = "/Extracted/pkgps.unl";
    
    static String zipFilePath = saveDir + "/poslanci.zip";
    static String destDirectory = saveDir + "/Extracted";

    static List<Organ> organy;
    static List<Osoba> osoby;
    static List<Poslanec> poslanci;
    static List<Funkce> funkce;
    static List<GPS> gps;
    static List<Typ_Funkce> typy_Funkci;
    static List<Zarazeni> zarazeni;
    static List<Typ_Organu> typy_Organu;

    static int latestVotingTerm = 172; 

    static Charset charset = Charset.forName("windows-1250");

	 public static void getData(){
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir);
            System.out.println("Downloading");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        UnzipUtility unzipper = new UnzipUtility();
        try {
            unzipper.unzip(zipFilePath, destDirectory);
        } catch (Exception ex) {
            // some errors occurred
            ex.printStackTrace();
        }
    }

    public static List<Poslanec> getVotingTermList(int term){
        List<Poslanec> votingTermPoslanci = new ArrayList<Poslanec>();
        for (Poslanec poslanec: poslanci) {
            if(poslanec.getId_votingTerm() == term){
                votingTermPoslanci.add(poslanec);
            }
        }
        return votingTermPoslanci;
    }

    public static List<Poslanec> getLatestVotingTermList(){
        return getVotingTermList(latestVotingTerm);
    }
    

    public static void printToConsole() {
    	Path file = Paths.get(saveDir + filePoslanci);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
    	   String line = null;
    	   while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static List<Poslanec> loadPoslanci() {
        Path file = Paths.get(saveDir + filePoslanci);
        List<Poslanec> poslanci = new ArrayList<Poslanec>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Poslanec poslanec = new Poslanec(line);
                poslanci.add(poslanec);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return poslanci;
    }
    public static List<Osoba> loadOsoby() {
        Path file = Paths.get(saveDir + fileOsoby);
        List<Osoba> osoby = new ArrayList<Osoba>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Osoba osoba = new Osoba(line);
                osoby.add(osoba);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return osoby;
    }
    public static List<Organ> loadOrgany() {
        Path file = Paths.get(saveDir + fileOrgany);
        List<Organ> organy = new ArrayList<Organ>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Organ organ = new Organ(line);
                organy.add(organ);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return organy;   
    }
    public static List<Typ_Organu> loadTypOrganu() {
        Path file = Paths.get(saveDir + fileTypOrganu);

        List<Typ_Organu> typy_Organu = new ArrayList<Typ_Organu>();

        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Typ_Organu typ_Organu = new Typ_Organu(line);
                typy_Organu.add(typ_Organu);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return typy_Organu;

    }
    public static List<Typ_Funkce> loadTypFunkce() {
        Path file = Paths.get(saveDir + fileTypFunkce);
        List<Typ_Funkce> typy_Funkci = new ArrayList<Typ_Funkce>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Typ_Funkce typ_Funkce = new Typ_Funkce(line);
                typy_Funkci.add(typ_Funkce);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return typy_Funkci;
        
    }
    
    public static List<GPS> loadGPS() {
        Path file = Paths.get(saveDir + fileGPS);
        List<GPS> gps = new ArrayList<GPS>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                GPS g = new GPS(line);
                gps.add(g);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return gps;
    }
    public static List<Zarazeni> loadZarazeni() {
        Path file = Paths.get(saveDir + fileZarazeni);
        List<Zarazeni> zarazeni = new ArrayList<Zarazeni>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Zarazeni z = new Zarazeni(line);
                zarazeni.add(z);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return zarazeni;
    }

    public static List<Funkce> loadFunkce() {
        Path file = Paths.get(saveDir + fileFunkce);
        List<Funkce> funkce = new ArrayList<Funkce>();
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                Funkce f = new Funkce(line);
                funkce.add(f);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return funkce;
    }
    public static String getZkratkuOrganu(int idOrganu){
        for(Organ org: organy){
            if(org.getId_Organu() == idOrganu){
                return org.getZkratka();
            }
        }
        return "";
    }
    public static String getNazevOrganu(int idOrganu){
        for(Organ org: organy){
            if(org.getId_Organu() == idOrganu){
                return org.getNazevCS();
            }
        }
        return "";
    }


}

