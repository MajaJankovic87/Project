package glavni;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.Dashboard;
import page.objects.Edit;
import page.objects.Home;
import pageTest.DashboardTest;
import pageTest.HomeTestAuto;
import pageTest.HomeTestMan;

public class GlavniProgram {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		WebDriver dr=new ChromeDriver();
		dr.manage().window().maximize();
		
		
		try {
			//prvo testira sve za manualni unos podataka
			Home.openPage(dr);	
			HomeTestMan.manRegistracija(dr);
			HomeTestMan.manLogin(dr);	
			DashboardTest.manNapraviPost(dr, 2);
			Edit.editujPost(dr, 1);
			DashboardTest.brisiPost(dr, 1);
			
			Dashboard.clickLogout(dr);
			
			Home.navigateTo(dr);
						
			//onda testira za sve podatke iz tabele
			HomeTestAuto.autoRegCeleTabele(dr);
			HomeTestAuto.autoLogCeleTabele(dr);
			
			//testiranje random clana iz tabele za edit i brisanje posta
			HomeTestAuto.autoRegistracija(dr, 4);
			HomeTestAuto.autoLogin(dr, 4);
			DashboardTest.autoNapraviPost(dr, 1);					
			Edit.editAutoPost(dr, 0);
			DashboardTest.brisiPost(dr, 0);		
			Dashboard.clickLogout(dr);
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	

}
