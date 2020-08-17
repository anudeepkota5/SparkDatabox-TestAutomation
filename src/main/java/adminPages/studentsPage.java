package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class studentsPage extends BaseClass{
	
	@FindBy(xpath="(//a/span[contains(text(),'Students')])[2]")
	WebElement students;
	
	public studentsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public studentsMainPage clickStudentsubmenu(){
		students.click();
		return new studentsMainPage();
	}

}
