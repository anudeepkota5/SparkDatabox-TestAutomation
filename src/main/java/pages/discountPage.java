package pages;

import static org.testng.Assert.assertTrue;

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
	
	@FindBy(xpath = "//p[text()='sorry this coupon is not applicable in your region! please use some other coupon.']")
	WebElement invalid;
	
	@FindBy(xpath = "//p[text()='Invalid or expire coupon! please enter a valid coupon code.']")
	WebElement Expired;
	
	public discountPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyResult(String result) throws Exception{
		
		if(result.equals("500")){
			assertTrue(flatINR.isDisplayed());
		}else if(result.equals("10%")){
			assertTrue(percentageDisc.isDisplayed());
		}else if(result.equals("FLAT")){
			assertTrue(Free.isDisplayed());
		}else if(result.equals("10$")){
			assertTrue(flatDol.isDisplayed());
		}else if(result.equals("INVALID")){
			assertTrue(invalid.isDisplayed());
		}
		takescreenshot("Verify the Coupon Output");
		
	}
	
	public void verifyExpired() throws Exception{
		assertTrue(Expired.isDisplayed());
		takescreenshot("Verify the Coupon Output");
	}
	
}
