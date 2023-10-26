package tester;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import core.Cloth;
import utility.FashionCompanyUtilityOperation;

public class FashionEComerceCompany implements FashionCompanyUtilityOperation {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				PrintWriter pw = new PrintWriter(new FileWriter("FashionCompanyData.txt"))){
			Map<Integer,Cloth>fashionMaps= new HashMap<>();
			FashionCompanyUtilityOperation.populatedStocks(fashionMaps);
			boolean exit=false;
			while(!exit) {
				System.out.println("Application Menu : \n"
						+ "1)Add new CLoth\n"
						+ "2)Updated stock of a cloth\n"
						+ "3)Set discount for all clothes of given category and Brand\n"
						+ "4)Remove clothes which are out of stock for last 2months\n"
						+ "5)list out clothes which are out of stock today\n"
						+ "0)Exit");
				try {
				switch(sc.nextInt()) {
				case 1:FashionCompanyUtilityOperation.addCloth(fashionMaps, sc);
					break;
				case 2:FashionCompanyUtilityOperation.updateStock(fashionMaps, sc);
					break;
				case 3:FashionCompanyUtilityOperation.setDiscount(fashionMaps, sc);
					break;
				case 4:FashionCompanyUtilityOperation.removeCLoth(fashionMaps);
					break;
				case 5:FashionCompanyUtilityOperation.displayOutOfStockToday(fashionMaps);
					break;
				case 0:System.out.println("Thank you!!!");
				exit=true;
					break;
				}
			}
			
			catch(Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
		}
			fashionMaps.values().forEach(p->pw.println(p));
			
			System.out.println("successfully write updated dta of fashion company into file FashionCompanyData.txt");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
