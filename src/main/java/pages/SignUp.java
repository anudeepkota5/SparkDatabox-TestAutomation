package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import Com.Util.BaseClass;

public class SignUp extends BaseClass{
	//static Logger log=Logger.getLogger(SignUp.class);

	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='registration-email']")
	WebElement email;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signup;
	
	@FindBy(xpath="//input[@id='registration-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='registration-passwordc']")
	WebElement confirmpassword;
	
	public SignUp() {
		PageFactory.initElements(driver, this);
	}
	
	public void registration(String fname,String lname,String eml,String pass) {
		//log.info("Entering details in registration form");
		firstname.sendKeys(fname);
		takeScreenShot("Enter First Name as "+fname);
		lastname.sendKeys(lname);
		takeScreenShot("Enter Last Name as "+lname);
		email.sendKeys(eml);
		takeScreenShot("Enter eMail as "+eml);
		password.sendKeys(pass);
		takeScreenShot("Enter Password as "+pass);
		confirmpassword.sendKeys(pass);
		takeScreenShot("Enter Confirmed Password as "+pass);
		signup.click();
		takeScreenShot("Click on SignUp");
}
}
