package adminPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class couponsPage extends BaseClass{
	
	@FindBy(xpath="//a[text()='Add New Coupon']")
	WebElement addcoupon;
	
	@FindBy(xpath="//a[text()='Test']/ancestor::td[1]/following-sibling::td[5]//a")
	WebElement delcoupon;
	
	public couponsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public addCouponPage clickAddcoupon() throws Exception{
		addcoupon.click();
		takescreenshot();
		return new addCouponPage();
	}
	
	public couponsPage clickDeleteCoupon() throws Exception{
		delcoupon.click();
		takescreenshot();
		new aleartPage().clickcontinue();
		takescreenshot();
		return this;
	}

}
