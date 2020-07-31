package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Util.BaseClass;

public class MyCourses extends BaseClass {
	@FindBy(xpath="//h5[@class='title']")
	List<WebElement> addedcourse;

	public MyCourses() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateAddedCourse(String validatecours) {
		
		for(int i=0;i<addedcourse.size();i++) {
			addedcourse.get(i).getText().equals(validatecours);
		    Boolean bool=addedcourse.get(i).isDisplayed();
		     Assert.assertTrue(bool);
	
	}
	}}

