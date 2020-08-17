package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class courseDetailPage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Apply Coupon')]")
	WebElement applyCoupon;
	
	@FindBy(xpath="//input[@name='coupon_code']")
	WebElement couponCode;
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement apply;
	
	@FindBy(xpath="(//a[text()='Get Enrolled'])[position()=1]")
	WebElement getenrolled;
	
	public courseDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public courseDetailPage clickApplyCoupon(){
		applyCoupon.click();
		takeScreenShot("Click on Apply Coupon");
		return this;
	}
	
	public discountPage clickApply() throws Exception{
		apply.click();
		takescreenshot("Click on Apply");
		return new discountPage();
	}
	
	public courseDetailPage entercouponCode(String strCoupon) throws Exception{
		couponCode.sendKeys(strCoupon);
		takescreenshot("Enter Coupon Code as "+strCoupon);
		return this;
	}
	
	public MyCourses clickOnGetEnrolled() throws Exception {
		getenrolled.click();
		takescreenshot("Click on Get Enrolled");
		return new MyCourses();
	}
}
