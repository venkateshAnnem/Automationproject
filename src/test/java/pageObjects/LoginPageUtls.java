package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageUtls extends BasePage {

    public LoginPageUtls(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    // 🔥 BEST PRACTICE: single business method
    public void login(String email, String pwd) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(username));

        username.clear();
        username.sendKeys(email);

        password.clear();
        password.sendKeys(pwd);

        loginBtn.click();
    }
}