package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class addCourses extends BaseClass{
	
	@FindBy(id="courses_type_select")
	WebElement coursestypeselect;
	
	@FindBy(xpath="//p[text()='updated successfully']")
	WebElement updatedsuccessfully;
	
	@FindBy(id="courses_select")
	WebElement coursesselect;
	
	@FindBy(xpath="//a/span[text()='Basic']")
	WebElement basic;
	
	
	
	public addCourses(){
		PageFactory.initElements(driver, this);
	}

}
