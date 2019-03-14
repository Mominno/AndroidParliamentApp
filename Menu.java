import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;

import java.nio.charset.StandardCharsets;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Menu {
	
	public static void main(String[] args){
		
		System.out.println("Aktualizovat data?(y/n)");	
		Scanner scanner = new Scanner(System.in);
		String response = scanner.nextLine();
		
		if(response.equals("y") ){
			System.out.println("Getting data");
			Data.getData();
		}

		Path file = Paths.get(Data.saveDir + "results.txt");

		response = scanner.nextLine();

		 Data.poslanci = Data.loadPoslanci();
		 Data.osoby = Data.loadOsoby();
		 Data.organy = Data.loadOrgany();
		 Data.typy_Organu = Data.loadTypOrganu();
		 Data.typy_Funkci = Data.loadTypFunkce();
		 Data.gps = Data.loadGPS();
		 Data.zarazeni = Data.loadZarazeni();
		 Data.funkce = Data.loadFunkce();

		System.out.println("Print Info?(y/n)");	
		response = scanner.nextLine();
		if(response.equals("y")){
			try{
				List<Poslanec>currentPoslanci = Data.getLatestVotingTermList();
				List<InformationSet> information = new ArrayList<InformationSet>();
				BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8);
				//BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"), Data.charset);
				for (Poslanec poslanec: currentPoslanci) {
					information.add(new InformationSet(poslanec));
      			}
      			for(InformationSet set: information){
      				String str = set.writeInfo();	
      				writer.write(str);
      			}
      			writer.close();
      			System.out.println("WTF");
			}
			catch(IOException ex){
      			System.out.println("ddd");
      		}
		}
	}
}