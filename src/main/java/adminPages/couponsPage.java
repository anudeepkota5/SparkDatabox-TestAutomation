package adminPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class couponsPage extends BaseClass{
	
	@FindBy(xpath="//a[text()='Add New Coupon']")
	WebElement addcoupon;
	
	@FindBy(xpath="//a[text()='Test']/ancestor::td[1]/following-sibling::td[5]//a")
	WebElement delcoupon;
	
	@FindBy(xpath = "//tr/td")
	List<WebElement> couponexist;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;	
	
	public couponsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public addCouponPage clickAddcoupon() throws Exception{
		addcoupon.click();
		takescreenshot("Click on ADD Coupon");
		return new addCouponPage();
	}
	
	public couponsPage clickDeleteCoupon(String coupon) throws Exception{
		search.sendKeys(coupon);
		if(couponexist.size() != 1){
			delcoupon.click();
			takescreenshot("Delete the coupon with name "+coupon);
			new aleartPage().clickcontinue();
		}		
		takescreenshot("Search for coupon with name "+coupon);
		return this;
	}

}
