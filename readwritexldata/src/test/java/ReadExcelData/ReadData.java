package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadData {
    public static void main(String[] args) throws IOException {
        // File-->workbook-->sheet-->row-->cell
        /* 
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\readwritexldata\\TestData\\TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet =  workbook.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(1).getLastCellNum();
        for(int r =0;r<=rowCount;r++){
            XSSFRow row = sheet.getRow(r);
            for(int c=0;c<colCount;c++){
                XSSFCell cell = row.getCell(c);
                String value = cell.toString();
                System.out.print(value + "  ");
            }
            System.out.println();
        }

        workbook.close();
        file.close();
        
*/

        //create File
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\readwritexldata\\TestData\\TestData.xlsx");

        //get workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //get sheet 
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //get row count
        int rowcount = sheet.getLastRowNum();

        //get column count
        int colcount = sheet.getRow(0).getLastCellNum();

        for(int r = 0; r<=rowcount; r++){
            XSSFRow row = sheet.getRow(r);
            for(int c = 0; c<colcount;c++){
                String cellValue = row.getCell(c).toString();
                // XSSFCell cell = row.getCell(c);
                // String cellValue = cell.toString();
                System.out.print("Cell values:    "+ cellValue);
            }
            System.out.println();
        }

        workbook.close();
        file.close();
    }
}
