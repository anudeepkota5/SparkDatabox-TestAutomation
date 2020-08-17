package adminPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class studentsListPage extends BaseClass{	
	
	@FindBy(xpath="//tbody/tr/td[4]")
	List<WebElement> email;
	
	@FindBy(xpath="//tbody/tr/td[6]//button")
	List<WebElement> action;
	
	@FindBy(xpath="//tbody/tr/td[6]//a[text()='Delete']")
	List<WebElement> delete;
	
	public studentsListPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void deleteUser(String strUser) throws Exception{
		int i = 0;
		for(WebElement user:email){
			if(user.getText().contains(strUser)){
				action.get(i).click();
				takescreenshot("Click on Action Button");
				delete.get(i).click();
				takescreenshot("Click On Delete Button");
				new aleartPage().clickcontinue();
				takescreenshot("Accept the Aleart by Clicking on Continue");
				takescreenshot("Delete User succssfully");
				break;				
			}
			i++;
		}
		
	}
	

}
