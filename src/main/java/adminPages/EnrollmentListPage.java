package adminPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class EnrollmentListPage extends BaseClass{

	@FindBy(xpath="//td[2]/small")
	List<WebElement> emails;	
	
	@FindBy(xpath="//td[3]/strong/a")
	List<WebElement> courses;
	
	@FindBy(xpath="//td[5]/button")
	List<WebElement> delete;
	
	public EnrollmentListPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void unenrollcourse(String stremail, String strCourse) throws Exception{		
		for(int i = 0; i<emails.size(); i++){
			if(emails.get(i).getText().contains(stremail) && courses.get(i).getText().contains(strCourse)){
				takescreenshot("UnEnroll a course");
				delete.get(i).click();
				new aleartPage().clickcontinue();
				takescreenshot("Click on Continue");
			}
		}
		
	}
}
