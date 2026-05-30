package testCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaeClassPage.java.BaseClass;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.AccountRegistrationpage;
public class TC_AcctPage extends BaseClass{
@Test(groups= {"sanity","Regression","Master"})
public void passingdetails() throws FileNotFoundException {
	
	
	logger.info("**********  TC_AcctPage     ************");
	try {
	AccountRegistrationpage hp1=new AccountRegistrationpage(driver);
	hp1.setName("Sudha");
	hp1.seteml("ambu@gmail.com");
	hp1.setphnnum("897654321");
	hp1.setadrs("GNT");
	hp1.setgndr();
	hp1.setday();
	hp1.selectCountryByVisibleText("India");
	hp1.setclr();
	hp1.setanimal();
	hp1.setdatepkr("06/06/1997");
	hp1.settxtdate("06/06/1996");
	hp1.setupload("E:\\fileupload");

    logger.info("Form filled successfully");
		
}

	catch(Exception e) {
	    logger.error("Test failed: " + e.getMessage());
	    e.printStackTrace();   // 👈 VERY IMPORTANT
	    Assert.fail("Test failed due to exception: " + e.getMessage());
	}
	logger.info("execution is completed");
}

}
