package adminPages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Util.BaseClass;

public class addCouponextPage extends BaseClass{
	
	@FindBy(id="courses_type_select")
	WebElement courseType;	
	
	@FindBy(id="courses_select")
	WebElement coursesselect;	
	
	public addCouponextPage(){
		PageFactory.initElements(driver, this);
	}
	
	public addCouponextPage selectCourseType(String strcourseType){
		Select courseType = new Select(driver.findElement(By.id("courses_type_select")));
		courseType.selectByVisibleText(strcourseType);
		return this;
	}
	
	public addCouponextPage verifySuccessMessage(){
		boolean success = driver.findElement(By.xpath("//p[text()='updated successfully']")).isDisplayed();
		assertTrue(success);
		return this;
	}
	
	public addCouponextPage selectCourse(String strCourse){
		Select courseSelect = new Select(coursesselect);
		courseSelect.selectByVisibleText(strCourse);
		return this;
	}

}
