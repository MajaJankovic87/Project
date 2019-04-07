package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class Excel {

	// promenljive za objekte excela
	private static HSSFSheet sheet;
	private static HSSFWorkbook workbook;
	private static HSSFCell cell;
	private static HSSFRow row;
	private static DataFormatter format;

	// metoda za ucitavanje excel fajla
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			workbook = new HSSFWorkbook(ExcelFile);
			sheet = workbook.getSheet(sheetName);
			format = new DataFormatter();
		}

		catch (Exception ex) {
			throw (ex);
		}
	}

	// metoda za uzimanje podataka iz celija
	public static String getCellData(int RowNo, int ColNo) throws Exception {
		try {
			cell = sheet.getRow(RowNo).getCell(ColNo);
			String cellData = format.formatCellValue(cell);
			return cellData;

		}

		catch (Exception ex) {
			return "";
		}
	}
	//upis podataka u excel
	public static void setCellData(String result, int RowNo, int ColNo) throws Exception {
		try {
			row = sheet.getRow(RowNo);
			cell = row.getCell(ColNo, MissingCellPolicy.RETURN_BLANK_AS_NULL);
			if(cell == null) {
				cell = row.createCell(ColNo);
				cell.setCellValue(result);
			}
			else {
				cell.setCellValue(result);
			}
			
			FileOutputStream fileOut = new FileOutputStream(config.Path_TestData + config.File_TestData);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
		}
		catch (Exception e) {
			throw (e);
		}
	}

	// vraca referencu na Worksheet
	public static HSSFSheet getWorkSheet() {
		return sheet;
	}

}
