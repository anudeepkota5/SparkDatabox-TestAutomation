package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class EnrollmentPage extends BaseClass{
	
	@FindBy(xpath="//a[text()='Enrol History']")
	WebElement enrollmentHistory;
	
	public EnrollmentPage(){
		PageFactory.initElements(driver, this);
	}
	
	public EnrollmentListPage clickenrollmentHistory() throws Exception{
		enrollmentHistory.click();
		takescreenshot("Click on Enrollment History");
		return new EnrollmentListPage();
	}

}
