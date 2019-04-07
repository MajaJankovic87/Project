package excelTest;

import util.Excel;
import util.config;

public class GlavniExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sheetName1="Registracija";
		String sheetName2="Tekst";
		String data = "Maja";

		//uzimamo podatke iz celije iz sheeta Registracija
		try {
			Excel.setExcelFile(config.Path_TestData + config.File_TestData, sheetName1);
			System.out.println(Excel.getCellData(1, 0));
			Excel.setCellData(data, 2, 2);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//uzimamo podatke iz sheeta Tekst
		try {
			Excel.setExcelFile(config.Path_TestData + config.File_TestData, sheetName2);
			System.out.println(Excel.getCellData(1, 0));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
