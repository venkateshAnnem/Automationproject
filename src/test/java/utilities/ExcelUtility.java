package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    private String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet sheet = wb.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum() + 1;

        wb.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet sheet = wb.getSheet(sheetName);

        XSSFRow row = sheet.getRow(rowNum);

        int cellCount = (row == null) ? 0 : row.getLastCellNum();

        wb.close();
        fi.close();
        return cellCount;
    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {

        FileInputStream fi = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet sheet = wb.getSheet(sheetName);

        String data = "";

        XSSFRow row = sheet.getRow(rowNum);
        if (row != null) {
            XSSFCell cell = row.getCell(colNum);
            if (cell != null) {
                DataFormatter formatter = new DataFormatter();
                data = formatter.formatCellValue(cell);
            }
        }

        wb.close();
        fi.close();

        return data;
    }
}