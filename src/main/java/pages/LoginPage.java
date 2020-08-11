package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class LoginPage  extends BaseClass{

	@FindBy(xpath="//input[@id='login-email']")
	WebElement Email;
	
	@FindBy(xpath="(//div//input[@name='password'])")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Log In']")
	WebElement login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage verifylogin(String email,String pass) throws Exception {
		Email.sendKeys(email);
		Password.sendKeys(pass);
		takescreenshot();
		ScrollElementIntoView(login);
		javaScriptClick(login);
		takescreenshot();
		return new HomePage();
	}
}

