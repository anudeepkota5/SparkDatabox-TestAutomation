package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class aleartPage extends BaseClass{
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement Continue;
	
	public aleartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickcontinue(){
		Continue.click();
	}
}
