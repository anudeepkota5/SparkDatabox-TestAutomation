package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class studentAddFormlogin extends BaseClass{
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//li[@class='next list-inline-item']/a")
	WebElement next;
	
	
	public studentAddFormlogin(){
		PageFactory.initElements(driver, this);
	}
	
	public studentAddFormlogin enterlogindetails(String stremail, String strPassword) throws Exception{
		email.sendKeys(stremail);
		takescreenshot("Enter Email as "+stremail);
		password.sendKeys(strPassword);
		takescreenshot("Enter Password as "+strPassword);
		next.click();
		takescreenshot("Click onn Next");
		return this;
	}
	
	public studentAddFormlogin clicknext() throws Exception{
		next.click();
		takescreenshot("Click onn Next");
		return this;
	}

}
