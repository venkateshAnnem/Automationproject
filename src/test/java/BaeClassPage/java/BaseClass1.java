package BaeClassPage.java;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass1 {
public WebDriver driver;
	
	public Logger logger;

	@BeforeClass(groups= {"Regression"})
	
	public void setup() throws FileNotFoundException
	{
		logger=LogManager.getLogger(this.getClass()); //for logger 
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}

}
