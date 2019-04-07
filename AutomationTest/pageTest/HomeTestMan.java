package pageTest;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.Home;

public class HomeTestMan {
	
	public static String username, sifra; 
	
	
	//metoda za manualno testiranje registracije
	public static void manRegistracija(WebDriver dr) throws Exception{
		try {
			Scanner sc=new Scanner(System.in);		
			System.out.println("Unesite ime:");
			String ime=sc.nextLine();
			Home.sendKeysFirstName(dr, ime);
			System.out.println("Unesite prezime:");
			String prezime=sc.nextLine();
			Home.sendKeysLastName(dr, prezime);
			System.out.println("Unesite korisnicko ime:");
			username= sc.nextLine();
			Home.sendKeysUser(dr, username);
			System.out.println("Unesite Vas email:");
			String email=sc.nextLine();
			Home.sendKeysEmail(dr, email);
			System.out.println("Unesite sifru:");
			sifra=sc.nextLine();
			Home.sendKeysPass(dr, sifra);
			Home.clickRegister(dr);
			System.out.println("Uspesno ste se registrovali");
		}
		catch (Exception ex) {
		throw (ex);
		}		
	}
	//metoda za proveru registracije i logina pomocu rucnog unosa podataka, za vec registrovanog korisnika
	public static void manLogin(WebDriver dr) throws Exception {
		try {
			//manRegistracija(dr);
			username="emu";
			sifra="123";
			Home.sendKeysUserName(dr, username);
			Home.sendKeysPassword(dr, sifra);
			Home.clickLogin(dr);
		}
		catch (Exception ex) {
			throw (ex);
		}
	}
	
	

}
