package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class studentsMainPage extends BaseClass{	
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	public studentsMainPage(){
		PageFactory.initElements(driver, this);
	}
	
	public studentsListPage searchuser(String strUser){
		search.sendKeys(strUser);
		takeScreenShot("Enter "+strUser+" in search");
		return new studentsListPage();
	}
	
}
