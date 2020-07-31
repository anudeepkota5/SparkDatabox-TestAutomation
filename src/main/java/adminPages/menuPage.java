package adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class menuPage extends BaseClass{
	
	@FindBy(xpath="//a/span[contains(text(),'Enrolment')]")
	WebElement enrollment;
	
	@FindBy(xpath="//a/span[text()='Coupons']")
	WebElement coupons;
	
	@FindBy(id = "topbar-userdrop")
	WebElement userdrop;
	
	@FindBy(xpath = "//a/span[text()='Logout']")
	WebElement logout;
	
	
	public menuPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickEnrollment(){
		enrollment.click();
	}
	
	public couponsPage clickCoupons(){
		coupons.click();
		return new couponsPage();
	}
	
	public void logout(){
		int k = 0;
		do{
			if(driver.findElement(By.xpath("/html/body/div[6]/div")).getAttribute("style").contains("display: none;")){
				break;
			}
			k++;
		}while(k < 1000);
		userdrop.click();
		logout.click();
	}

}