package pageTest;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.Dashboard;
import page.objects.Edit;
import page.objects.Home;
import util.Excel;
import util.config;

public class DashboardTest {
	
	
	//pomocna metoda za kraci kod prilikom pravljenja posta
	public static void pomocniPost(WebDriver dr) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Unesite naziv posta:");
		String naziv = sc.nextLine();
		Dashboard.sendKeysNazivPosta(dr, naziv);
		System.out.println("Unesite lokaciju posta:");
		String lokacija=sc.nextLine();
		Dashboard.sendKeysLokacija(dr, lokacija);
		System.out.println("Izaberite jedan od nacina transporta do lokacije: Walk, Car, Motorbike, Bicycle, Bus");
		String nacin = sc.nextLine();
		Dashboard.setWay(dr, nacin);
		System.out.println("Opisite lokaciju:");
		String opis=sc.nextLine();
		Dashboard.sendKeysOpis(dr, opis);
		Dashboard.clickPost(dr);
	}
	
	
	//metoda za pravljenje posta pomocu rucno unetih podataka
	public static void manNapraviPost(WebDriver dr, int i) throws Exception {
		
		while(i>0) {
			Dashboard.clickMakePost(dr);
			pomocniPost(dr);
			i--;						
			
		}	
		
	}
		
	
	//metoda za brisanje postova		
		public static void brisiPost(WebDriver dr, int i) throws Exception {	
			
			Dashboard.clickMenu(dr, i);
			Dashboard.clickDelete(dr, i);
		
		}
		//metoda za unos iz excela gde se i odnosi na broj postova koji se prave 
		public static void autoNapraviPost(WebDriver dr, int i) throws Exception {
			while(i>0) {
				String podatak;

				Excel.setExcelFile(config.Path_TestData + config.File_TestData, "Tekst");
				Dashboard.clickMakePost(dr);
				
				Dashboard.clickNazivPosta(dr);
				podatak = Excel.getCellData(0, 0); //uzima podatak iz reda 6 npr
				Dashboard.sendKeysNazivPosta(dr, podatak);
				
				Dashboard.clickLokacija(dr);
				podatak = Excel.getCellData(0, 1); //uzima podatak iz reda 7 npr
				Dashboard.sendKeysLokacija(dr, podatak);
				
				Dashboard.clickLokacija(dr);
				podatak = Excel.getCellData(0, 2); //uzima podatak iz reda 8 npr
				Dashboard.sendKeysLokacija(dr, podatak);
				
				Dashboard.setWay(dr, "Walk");
				
				Dashboard.clickOpis(dr);
				podatak = Excel.getCellData(0, 3); //uzima podatak iz reda 3 npr
				Dashboard.sendKeysOpis(dr, podatak);
				
				Dashboard.clickPost(dr);
				i--;

			}
	
	}
		}

