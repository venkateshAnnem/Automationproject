package BaeClassPage.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static  WebDriver driver;
	
	public Logger logger;

	@BeforeClass(groups= {"sanity","Regression","Master"})
	@Parameters({"os","browser"})
	
	public void setup(String os,String br) throws IOException
	{
		FileReader file=new FileReader(".src//test//resources//config.properties");
		Properties p;
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass()); //for logger 
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else {
				System.out.println("No browser connected");
				return;
			}
			
			switch(br.toLowerCase()){
				case "chrome" :capabilities.setBrowserName("chrome");
				break;
				case "edge" :capabilities.setBrowserName("MicrosoftEdge");
				break;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();
		break;
		case "edge":driver=new EdgeDriver();
		break;
		default : System.out.println("Invalid browser name..");
		return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}
	}
	

	@AfterClass(groups= {"sanity","Regression","Master"})

	public void tearDown() {
	    if(driver != null) {
	        driver.quit();
	    }
	}
	public String Alphanumeric() {
		String generatedString=RandomStringUtils.randomAlphanumeric(6);
		return generatedString;
	}

	public String number() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String mixed() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		String generatedString=RandomStringUtils.randomAlphanumeric(6);
		return (generatedNumber+"@"+generatedString);
	}

	public static String captureScreen(String tname) throws IOException {

	    String timeStamp =
	            new SimpleDateFormat("yyyyMMddhhmmss")
	            .format(new Date());

	    TakesScreenshot ts = (TakesScreenshot) driver;

	    File sourceFile =
	            ts.getScreenshotAs(OutputType.FILE);

	    String targetFilePath =
	            System.getProperty("user.dir")
	            + "\\screenshots\\"
	            + tname + "_" + timeStamp + ".png";

	    File targetFile = new File(targetFilePath);

	    FileUtils.copyFile(sourceFile, targetFile);

	    return targetFilePath;
	}
}
