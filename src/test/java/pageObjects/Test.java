package pageObjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
ChromeDriver driver =new ChromeDriver();
		
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
driver.manage().window().maximize();
WebElement element = wait.until(
	    ExpectedConditions.elementToBeClickable(
	        By.xpath("//a[contains(text(),'OrangeHRM')]")
	    )
	);
element.click();



Set<String>ws=driver.getWindowHandles();
List<String>ws1=new ArrayList(ws);
String parent=ws1.get(0);
String Child=ws1.get(1);


driver.switchTo().window(parent);
String title=driver.getTitle();
System.out.println(title);

driver.switchTo().window(Child);
String title1=driver.getTitle();
System.out.println(title1);
/*
 OrangeHRM
OrangeHRM: All in One HR Software for Businesses | OrangeHRM
 */

for(String ws2:ws) {
	 driver.switchTo().window(ws2);
	if(driver.getTitle().equals("OrangeHRM: All in One HR Software for Businesses | OrangeHRM"))
	{
		driver.close();
	}
	
}



System.out.println(driver.getCurrentUrl());

driver.quit();



    
    
	     
	
	}
}

