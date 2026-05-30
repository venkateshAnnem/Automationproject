package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TitleExists{
	
	 WebDriver driver;

	    // Constructor
	    public  TitleExists(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	@FindBy(xpath="//div[@class='app_logo']")
	WebElement appLogo;
	
	public  boolean isHomePageDisplayed() {
		try {
			return(appLogo.isDisplayed());
		}catch(Exception e) {
			System.out.println("Home page not displayed: " + e.getMessage());
			return false;
		}
	}
}
