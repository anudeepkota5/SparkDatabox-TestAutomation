package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import Com.Util.BaseClass;

public class CoursePreview extends BaseClass{
	
	//static Logger log=Logger.getLogger(CoursePreview.class);
	
@FindBy(xpath="(//button[@class='plyr__control plyr__control--overlaid'])[2]")
WebElement coursePreview;


public CoursePreview() {
	PageFactory.initElements(driver, this);
}

public void clickOncoursePreview() {
	//log.info("clicking on coursePreview");
	coursePreview.click();
}}