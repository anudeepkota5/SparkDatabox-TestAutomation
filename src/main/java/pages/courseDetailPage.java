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
		return this;
	}
	
	public discountPage clickApply(){
		apply.click();
		return new discountPage();
	}
	
	public courseDetailPage entercouponCode(String strCoupon){
		couponCode.sendKeys(strCoupon);
		return this;
	}
	
	public MyCourses clickOnGetEnrolled() {
		getenrolled.click();
		return new MyCourses();
	}
}
