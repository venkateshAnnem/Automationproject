package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import utilities.ExcelUtility;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws Exception {

    	String path = System.getProperty("user.dir") + 
                "\\testData\\Acct.xlsx";
    	
        ExcelUtility xl = new ExcelUtility(path);

        String sheet = "Sheet1";

        int rowCount = xl.getRowCount(sheet);
        int colCount = xl.getCellCount(sheet, 0);

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) { // skip header row
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = xl.getCellData(sheet, i, j);
            }
        }

        return data;
    }
}