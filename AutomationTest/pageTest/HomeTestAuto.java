package pageTest;

import org.openqa.selenium.WebDriver;

import page.objects.Dashboard;
import page.objects.Home;
import util.Excel;
import util.config;

public class HomeTestAuto {
	
	//metoda za registraciju jednog, proizvoljnog korisnika iz tabele
	public static void autoRegistracija(WebDriver dr, int i) throws Exception {
		try {
			String podatak;

			Excel.setExcelFile(config.Path_TestData + config.File_TestData, "Registracija");
			
				Home.clickFirstName(dr);
				podatak = Excel.getCellData(i, 0);
				Home.sendKeysFirstName(dr, podatak);

				Home.clickLastName(dr);
				podatak = Excel.getCellData(i, 1);
				Home.sendKeysLastName(dr, podatak);

				Home.clickUser(dr);
				podatak = Excel.getCellData(i, 2);
				Home.sendKeysUser(dr, podatak);

				Home.clickEmail(dr);
				podatak = Excel.getCellData(i, 3);
				Home.sendKeysEmail(dr, podatak);

				Home.clickPass(dr);
				podatak = Excel.getCellData(i, 4);
				Home.sendKeysPass(dr, podatak);

				Home.clickRegister(dr);
			
		} catch (Exception ex) {
			throw (ex);
		}

	}

	// metoda koja registruje sve korisnike iz tabele
	public static void autoRegCeleTabele(WebDriver dr) throws Exception {
		Excel.setExcelFile(config.Path_TestData + config.File_TestData, "Registracija");
		for (int i = 1; i < Excel.getWorkSheet().getLastRowNum() + 1; i++) {
			autoRegistracija(dr, i);
			Home.navigateTo(dr);
		}
	}
	
	//metod za logovanje random korisnika iz tabele
	public static void autoLogin(WebDriver dr, int i) throws Exception {
		String podatak;
		Excel.setExcelFile(config.Path_TestData + config.File_TestData, "Registracija");
		
		if(i>0) {
			
		Home.clickUserName(dr);
		podatak = Excel.getCellData(i, 2);
		Home.sendKeysUserName(dr, podatak);
		
		Home.clickPassword(dr);
		podatak = Excel.getCellData(i, 4);
		Home.sendKeysPassword(dr, podatak);
		
		Home.clickLogin(dr);
		}
	}
	
	//metod za logovanje svih korisnika iz tabele
	public static void autoLogCeleTabele(WebDriver dr) throws Exception {
		Excel.setExcelFile(config.Path_TestData + config.File_TestData, "Registracija");
		for(int i=1; i<Excel.getWorkSheet().getLastRowNum() + 1; i++) {
			autoLogin(dr, i);
			Dashboard.clickLogout(dr);
			Home.navigateTo(dr);
		}
	}

}
