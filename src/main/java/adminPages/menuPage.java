package adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class menuPage extends BaseClass{
	
	@FindBy(xpath="//a/span[contains(text(),'Enrolment')]")
	WebElement enrollment;
	
	@FindBy(xpath="//a/span[contains(text(),'Students')]")
	WebElement students;
	
	@FindBy(xpath="//a/span[text()='Coupons']")
	WebElement coupons;
	
	@FindBy(id = "topbar-userdrop")
	WebElement userdrop;
	
	@FindBy(xpath = "//a/span[text()='Logout']")
	WebElement logout;
	
	
	public menuPage(){
		PageFactory.initElements(driver, this);
	}
	
	public EnrollmentPage clickEnrollment() throws Exception{
		takescreenshot("Click on Enrollment");
		enrollment.click();
		return new EnrollmentPage();
	}
	
	public couponsPage clickCoupons() throws Exception{
		coupons.click();
		takescreenshot("Click on Coupons");
		return new couponsPage();
	}
	
	public studentsPage clickStudents() throws Exception{
		students.click();
		takescreenshot("Click on Students");
		return new studentsPage();
	}
	
	public void logout() throws Exception{
		int k = 0;
		do{
			if(driver.findElement(By.xpath("/html/body/div[6]/div")).getAttribute("style").contains("display: none;")){
				break;
			}
			k++;
		}while(k < 1000);
		userdrop.click();
		takescreenshot("Click on User dropdown");
		logout.click();
		takescreenshot("Click on Logout");
	}

}
