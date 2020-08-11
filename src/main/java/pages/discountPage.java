package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class discountPage extends BaseClass{
	
	@FindBy(xpath="//span[text()='500INR off']")
	WebElement flatINR;	
	
	@FindBy(xpath="//div/span[text()='10% off']")
	WebElement percentageDisc;
	
	@FindBy(xpath="//div[@class='price live-price']/span[text()='Free']")
	WebElement Free;
	
	@FindBy(xpath="//div/span[text()='10$ off']")
	WebElement flatDol;
	
	public discountPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFlatINR() throws Exception{
		takescreenshot();
		return flatINR.isDisplayed();
	}
	
	public boolean verifypercentageDiscount() throws Exception{
		takescreenshot();
		return percentageDisc.isDisplayed();
	}
	
	public boolean verifyFlatFree() throws Exception{
		takescreenshot();
		return Free.isDisplayed();
	}
	
	public boolean verifyFlatDOL() throws Exception{
		takescreenshot();
		return flatDol.isDisplayed();
	}
}
