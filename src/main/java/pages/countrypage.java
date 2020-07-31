package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class countrypage extends BaseClass{
	
	@FindBy(xpath="//li[text()='United States']")
	WebElement us;	
	
	public countrypage(){
		PageFactory.initElements(driver, this);
	}
	
	public void selectUS(){
		us.click();
	}
	
	
}
