package page.objects;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.Excel;
import util.config;

public class Edit {
	
	
	
	public static final String EDIT_NAZIV = "//input[@id='title']";
	public static final String EDIT_LOKACIJA = "//input[@id='location']";
	public static final String EDIT_WAY = "//select[@id='transport']";
	public static final String EDIT_OPIS = "//textarea[@id='description']";
	public static final String EDIT_POST_BUTTON = "//div[@class='popupEdit']//input[@value='Post']";
	
	
	public static WebElement getEditNaziv(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(EDIT_NAZIV));
		return wel;
	}

	public static void clickEditNaziv(WebDriver dr) {
		getEditNaziv(dr).click();
	}
	
	public static void sendKeysEditNaziv(WebDriver dr, String str) {
		getEditNaziv(dr).clear();
		getEditNaziv(dr).sendKeys(str);
	}
	
	public static WebElement getEditLokacija(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(EDIT_LOKACIJA));
		return wel;
	}

	public static void clickEditLokacija(WebDriver dr) {
		getEditLokacija(dr).click();
	}

	public static void sendKeysEditLokacija(WebDriver dr, String str) {
		getEditLokacija(dr).clear();
		getEditLokacija(dr).sendKeys(str);
	}
	
	public static void setEditWay(WebDriver dr, String str) {
		Select Way = new Select(dr.findElement(By.xpath(EDIT_WAY)));
		Way.selectByVisibleText(str);
	}
	
	public static WebElement getEditOpis(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(EDIT_OPIS));
		return wel;
	}

	public static void clickEditOpis(WebDriver dr) {
		getEditOpis(dr).click();
	}

	public static void sendKeysEditOpis(WebDriver dr, String str) {
		getEditOpis(dr).clear();
		getEditOpis(dr).sendKeys(str);
	}
	
	public static WebElement getEditPost(WebDriver dr) {

		WebElement wel = dr.findElement(By.xpath(EDIT_POST_BUTTON));
		return wel;
	}

	public static void clickEditPost(WebDriver dr) {
		getEditPost(dr).click();
	}
	
	//manualni nacin
	public static void pomocniPostEdit(WebDriver dr) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Unesite naziv posta:");
		String naziv = sc.nextLine();
		Edit.sendKeysEditNaziv(dr, naziv);
		System.out.println("Unesite lokaciju posta:");
		String lokacija=sc.nextLine();
		Edit.sendKeysEditLokacija(dr, lokacija);
		System.out.println("Izaberite jedan od nacina transporta do lokacije: Walk, Car, Motorbike, Bicycle, Bus");
		String nacin = sc.nextLine();
		Edit.setEditWay(dr, nacin);
		System.out.println("Opisite lokaciju:");
		String opis=sc.nextLine();
		Edit.sendKeysEditOpis(dr, opis);
		Edit.clickEditPost(dr);
	}
	
	public static void editujPost(WebDriver dr, int i) throws Exception {
		
		Dashboard.clickMenu(dr, i);
		Dashboard.clickEdit(dr, i);
		pomocniPostEdit(dr);
	
}
	
	//automatski nacin
	public static void pomocniAutoEdit(WebDriver dr) throws Exception {
		
		
			String podatak;

			Excel.setExcelFile(config.Path_TestData + config.File_TestData, "Tekst");
			
			
			clickEditNaziv(dr);
			podatak = Excel.getCellData(0, 0);
			sendKeysEditNaziv(dr, podatak);
			
			clickEditLokacija(dr);
			podatak = Excel.getCellData(0, 2);
			sendKeysEditLokacija(dr, podatak);
			
			clickEditOpis(dr);
			podatak = Excel.getCellData(0, 5);
			sendKeysEditOpis(dr, podatak);
			
			clickEditPost(dr);
		
	}
	
	//metoda za eidtovanje posta preko sheeta Tekst iz excel tabele, i je broj posta koji se edituje
	public static void editAutoPost(WebDriver dr, int i) throws Exception {
		Dashboard.clickMenu(dr, i);
		Dashboard.clickEdit(dr, i);
		pomocniAutoEdit(dr);
	}
	


}
