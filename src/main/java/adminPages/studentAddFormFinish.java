package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class studentAddFormFinish extends BaseClass{
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;	
	
	public studentAddFormFinish(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickSubmit() throws Exception{		
		submit.click();
		takescreenshot("Click on Submit");
	}
	
	

}
