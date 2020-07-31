package com.test;

import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Com.Util.BaseClass;
import adminPages.addCouponPage;
import adminPages.addCouponextPage;
import adminPages.menuPage;
import pages.GetEnrolledPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyCourses;
import pages.SignUp;
import pages.discountPage;

public class SparkDataBoxCourseTest extends BaseClass{
	
	@Test(enabled = true, priority=1,dataProvider="data")
	public void SearchQueryTest(Hashtable<String, String> data) {
		HomePage hp=new HomePage();
		hp.entercourse(data.get("Query")).clickSearch().validatesearchResult(data.get("Query"));
	}
	
	@Test(priority=2,dataProvider="data")
	public void userSignupTest(Hashtable<String, String> data) {
		HomePage hp=new HomePage();
		SignUp Su=hp.clickOnSignUp();
		Su.registration(data.get("fname"), data.get("lname"), data.get("eml"), data.get("pass"));
		verifyemail();
		hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));
	}
	
	@Test(priority=3,dataProvider="data")
	 public void verifyLoginTest(Hashtable<String, String> data) {
		HomePage hp=new HomePage();
		hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));		      
	}
       
	@Test(priority=4,dataProvider="data")		
	public void coupon(Hashtable<String, String> data){
		HomePage hp=new HomePage();
		LoginPage lpp=hp.clickOnLogin();
		hp=lpp.verifylogin(data.get("username"), data.get("password"));
		hp.entercourse(data.get("Query")).clickSearch().selectCourse(data.get("Query")).
			clickApplyCoupon().entercouponCode(data.get("Coupon")).clickApply();
		MyCourses mc = new MyCourses();
		mc.validateAddedCourse(data.get("validatecourse"));
	}
	
		@Test(priority=6,dataProvider="data")
		public void buyacourse(Hashtable<String, String> data) throws Exception {
			HomePage hp=new HomePage();
		    hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));			
		    GetEnrolledPage gt=hp.selectLiveAndSelfPacedCourses(data.get("Self-Paced And Live courses"));
			gt.clickOnEnrollNow().clickOnpaypal()
			.clickOnguestCheckout(data);			
		}
	
	@Test(priority=5,dataProvider="data")
	public void getaFreecourse(Hashtable<String, String> data) {
		HomePage hp=new HomePage();
		hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));		
		hp.entercourse(data.get("Course")).clickSearch().selectCourse(data.get("Course")).clickOnGetEnrolled();
		hp.logout();
		LoginPage lpp = new LoginPage();
		lpp .verifylogin(""+prop.get("Adminusername"), ""+prop.get("Adminpasswprd"));
		driver.findElement(By.xpath("//a/span[contains(text(),'Enrolment')]")).click();
		driver.findElement(By.xpath("//a[text()='Enrol History']")).click();		
		driver.findElement(By.xpath("//tr/td/b[contains(text(),'testNG 1234e')]/../following-sibling::td[3]/button")).click();
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	@Test(priority=6, dataProvider="data")
	public void TestCompleteCoupons(Hashtable<String, String> data) throws Exception{
		HomePage hp=new HomePage();
		hp.clickOnLogin().verifylogin(""+prop.get("Adminusername"), ""+prop.get("Adminpasswprd"));
		menuPage menu = new menuPage();
		addCouponPage coupon = menu.clickCoupons().clickDeleteCoupon().clickAddcoupon();
		coupon.entercoursetitle(data.get("Coupon Title")).entercoursecode(data.get("Coupon Code"))
		.selectDiscountFor(data.get("Discount For")).selectcoupontype(data.get("Discount Type"));		
		
		if(!data.get("Discount Type").equals("Full Free")){
			//INDIA
			if(data.get("Discount For").equals("Only in India")){
				if(data.get("Discount Type").equals("Flat Fixed Discount")){
					coupon.enterFlatDiscountIN(data.get("Flat discount INR"));
				}else if(data.get("Discount Type").equals("Percentage Discount")){
					coupon.enterpercentDiscountIN(data.get("Discount INR"));
				}
					coupon.enterminamountIN(data.get("Minimum Amount in INR"));
			}
			
			//Other than INDIA
			if(data.get("Discount For").equals("Other Countries (except india)")){
				if(data.get("Discount Type").equals("Flat Fixed Discount")){
					coupon.enterFlatDiscountInDol(data.get("Flat discount $"));
				}else if(data.get("Discount Type").equals("Percentage Discount")){
					coupon.enterpercentDiscountDol(data.get("Discount $"));
				}
				coupon.enterminDolAmount(data.get("Minimum Amount in $"));
			}
			
			if(data.get("Discount For").equals("Both India and other Countries")){
				if(data.get("Discount Type").equals("Flat Fixed Discount")){
					coupon.enterFlatDiscountIN(data.get("Flat discount INR"));
					coupon.enterFlatDiscountInDol(data.get("Flat discount INR"));
				}else if(data.get("Discount Type").equals("Percentage Discount")){
					coupon.enterpercentDiscountIN(data.get("Discount INR"));
					coupon.enterpercentDiscountDol(data.get("Discount $"));
				}
				coupon.enterminamountIN(data.get("Minimum Amount in INR"));
				coupon.enterFlatDiscountInDol(data.get("Minimum Amount in $"));
			}
		}		
		
		coupon.selectcouponorVoucher(data.get("Coupon Type")).entermaxUsage(data.get("Maximum usage")).clickSaveandContinue();
		
		addCouponextPage coupext = new addCouponextPage();
		coupext.selectCourseType(data.get("CoursesType")).verifySuccessMessage().selectCourse(data.get("Courses"));
		
		boolean display = driver.findElement(By.xpath("//button[contains(text(),'"+data.get("Courses")+"')]")).isDisplayed();
		assertTrue(display);
		
		boolean success2 = driver.findElement(By.xpath("(//p[text()='updated successfully'])[2]")).isDisplayed();
		assertTrue(success2);
		
		driver.findElement(By.xpath("//a/span[text()='Basic']")).click();
		
		Select status = new Select(driver.findElement(By.xpath("//select[@name='coupon_status']")));
		status.selectByVisibleText(data.get("Status"));
		
		driver.findElement(By.xpath("//button[text()='Save and Continue']")).click();		
		
		menu.logout();
				
		if(!data.get("Discount For").equals("Only in India")){
			hp.clickCountry().selectUS();
			Thread.sleep(2000);
		}
		
		hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));
		
		discountPage dis = hp.entercourse(data.get("Courses")).clickSearch().selectCourse(data.get("Courses")).
		clickApplyCoupon().entercouponCode(data.get("Coupon Code")).clickApply();		
		
		if(data.get("Discount For").equals("Only in India")){
			if(data.get("Discount Type").equals("Flat Fixed Discount")){
				assertTrue(dis.verifyFlatINR());				
			}else if(data.get("Discount Type").equals("Percentage Discount")){
				assertTrue(dis.verifypercentageDiscount());		
			}else{
				assertTrue(dis.verifyFlatFree());	
			}
		}else{
			if(data.get("Discount Type").equals("Flat Fixed Discount")){
				assertTrue(dis.verifyFlatDOL());				
			}else if(data.get("Discount Type").equals("Percentage Discount")){
				assertTrue(dis.verifypercentageDiscount());		
			}else{
				assertTrue(dis.verifyFlatFree());
			}
		}
		
		
	}

	
}
