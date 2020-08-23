package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class studentAddFormBasicInfo extends BaseClass{
	
	@FindBy(id="first_name")
	WebElement Fname;
	
	@FindBy(id="last_name")
	WebElement Lname;
	
	@FindBy(xpath="//li[@class='next list-inline-item']/a")
	WebElement next;
	
	
	public studentAddFormBasicInfo(){
		PageFactory.initElements(driver, this);
	}
	
	public studentAddFormlogin enterBasicInfo(String strFname, String strLname) throws Exception{
		Fname.sendKeys(strFname);
		takescreenshot("Enter First Name as "+strFname);
		Lname.sendKeys(strLname);
		takescreenshot("Enter Last Name as "+strLname);
		next.click();
		takescreenshot("Click on Next");
		return new studentAddFormlogin();
	}

}
