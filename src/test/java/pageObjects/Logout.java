package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaeClassPage.java.BaseClass1;



public class Logout extends BasePage {
	
	 public Logout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	 @FindBy(id="react-burger-menu-btn")
	    WebElement menuBtn;

	    @FindBy(id="logout_sidebar_link")
	    WebElement logoutLink;
	    public void openMenu() {
	        menuBtn.click();
	    }

	    public void clickLogout() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
	    }
}
