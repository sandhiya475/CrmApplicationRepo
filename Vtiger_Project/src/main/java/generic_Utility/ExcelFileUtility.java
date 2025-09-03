package generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class used to load and fetch value from excel file
 */

public class ExcelFileUtility {
	/**
	 * this class is used to fetch value from excel file when we give sheetname,row,cell
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String ToReadDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
	}
}
