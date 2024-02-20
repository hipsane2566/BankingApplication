package WriteExcelData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // FIle-->workbook-->sheet-->row-->cell
        //create file
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\readwritexldata\\TestData\\WiteExcel.xlsx");
        
        //create workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //create sheet
        XSSFSheet sheet = workbook.createSheet();

        //create row
        XSSFRow row = sheet.createRow(0);

        //create cell
        XSSFCell cell = row.createCell(0); 
        // row.createCell(0).setCellValue("Programming");
        cell.setCellValue("Programming");

        workbook.write(file);
        workbook.close();
        file.close();

    }
}
