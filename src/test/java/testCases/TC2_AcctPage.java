package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaeClassPage.java.BaseClass1;
import pageObjects.LoginPageUtls;
import pageObjects.Logout;
import pageObjects.TitleExists;
import utilities.DataProviders;

public class TC2_AcctPage extends BaseClass1 {
	
	  @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups={"Regression"})
	    public void verifyLogin(String email, String pwd, String exp) {

	        LoginPageUtls loginPage = new LoginPageUtls(driver);
	        loginPage.login(email, pwd);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        wait.until(ExpectedConditions.titleContains("Swag Labs"));

	        boolean isLoggedIn = isLoginSuccessful();

	        validateLoginResult(exp, isLoggedIn);

	        if (isLoggedIn) {
	            Logout logout = new Logout(driver);
	            logout.openMenu();
	            logout.clickLogout();
	        }
	    }

	    // 🔹 Single responsibility: validation only
	    private void validateLoginResult(String exp, boolean actual) {

	        if (exp.equalsIgnoreCase("Valid")) {
	            Assert.assertTrue(actual, "Expected valid login but failed");
	        } else {
	            Assert.assertFalse(actual, "Expected invalid login but passed");
	        }
	    }

	    // 🔹 Centralized check
	    private boolean isLoginSuccessful() {
	        return driver.getTitle().contains("Swag Labs");
	    }
}

	

