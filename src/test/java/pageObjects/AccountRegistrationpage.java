package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationpage extends BasePage {
	
	public AccountRegistrationpage(WebDriver driver) {
		super(driver);
	}
	
	

@FindBy(xpath="//input[@id='name']")
WebElement Elename;
@FindBy(xpath="//input[@id='email']")
WebElement Elemail;
@FindBy(xpath="//input[@id='phone']")
WebElement Elephonenum;
@FindBy(xpath="//textarea[@id='textarea']")
WebElement Eladress;
@FindBy(xpath="//input[@id='female']")
WebElement Elegndr;
@FindBy(xpath="//input[@id='monday']")
WebElement Eleday;
@FindBy(xpath = "//select[@id='country']")
WebElement Elecountry;
@FindBy(xpath="//option[@value='blue']")
WebElement Elecolor;
@FindBy(xpath="//option[@value='cheetah']")
WebElement Eleanimal;
@FindBy(xpath="//input[@id='datepicker']")
WebElement Eledtpicker;
@FindBy(xpath="//input[@id='txtDate']")
WebElement Eletxtdate;
@FindBy(xpath="//input[@id='singleFileInput']")
WebElement Eleupload;

	
	public void setName(String fName){
		Elename.sendKeys(fName);	
}
	public void seteml(String eml){
		Elemail.sendKeys(eml);	
}
	public void setphnnum(String phnnum){
		Elephonenum.sendKeys(phnnum);	
}	
	public void setadrs(String adrs){
		Eladress.sendKeys(adrs);
}
	public void setgndr(){
		Elegndr.click();
}
	public void setday(){
		Eleday.click();
}
	  public void selectCountryByVisibleText(String country) {
	        Select sel = new Select(Elecountry);
	        sel.selectByVisibleText(country);
	    }
	  
	  public void setclr(){
		  Elecolor.click();
	} 
	  
	  public void setanimal(){
		  Eleanimal.click();
	} 
	  public void setdatepkr(String date){
		  Eledtpicker.sendKeys(date);
	}  
	  
	  public void settxtdate(String txtdate){
		  Eletxtdate.sendKeys(txtdate);
	}  
	  
	  public void setupload(String upload){
		  Eleupload.sendKeys(upload);
	}  
	  
	  
	  
	
	
	
	
	
	/* public String getConfirmationMessage() {
		 try {
	        return msgConfirmation.getText();
	    }catch (Exception e) {
	    	return(e.getMessage());
	    }
}*/
	
	/*public void setGndr(){
	wait.until(ExpectedConditions.elementToBeClickable(txtGender)).click();
}*/
}
	
