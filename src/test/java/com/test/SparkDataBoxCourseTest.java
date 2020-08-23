package com.test;

import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Com.Util.BaseClass;
import adminPages.addCouponPage;
import adminPages.addCouponextPage;
import adminPages.menuPage;
import adminPages.studentAddFormFinish;
import adminPages.studentsListPage;
import adminPages.studentsPage;
import pages.GetEnrolledPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUp;
import pages.courseDetailPage;
import pages.discountPage;

public class SparkDataBoxCourseTest extends BaseClass{
	
	@Test(priority=1,dataProvider="data")
	public void SearchQueryTest(Hashtable<String, String> data) throws Exception {
		logger.log(LogStatus.INFO, data.get("Description"));
		HomePage hp=new HomePage();
		hp.entercourse(data.get("Query")).clickSearch().validatesearchResult(data.get("Query"));
	}
	
	@Test(priority=2,dataProvider="data")
	public void userSignupTest(Hashtable<String, String> data) throws Exception {
		logger.log(LogStatus.INFO, data.get("Description"));
		HomePage hp=new HomePage();
		SignUp Su=hp.clickOnSignUp();
		Su.registration(data.get("fname"), data.get("lname"), data.get("eml"), data.get("pass"));
		verifyemail();
		hp.clickOnLogin().verifylogin(data.get("eml"), data.get("pass"));
		hp.logout();
		LoginPage lpp = new LoginPage();
		lpp .verifylogin(""+prop.get("Adminusername"), ""+prop.get("Adminpasswprd"));
		menuPage menu = new menuPage();
		menu.clickStudents().clickStudentsubmenu().searchuser(data.get("eml")).deleteUser(data.get("eml"));
	}
	
	@Test(priority=3,dataProvider="data")
	 public void verifyLoginTest(Hashtable<String, String> data) throws Exception {
		logger.log(LogStatus.INFO, data.get("Description"));
		HomePage hp=new HomePage();
		hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));		 
		
	}
	
	@Test(priority=4,dataProvider="data")
	public void buyacourse(Hashtable<String, String> data) throws Exception {
		logger.log(LogStatus.INFO, data.get("Description"));
		HomePage hp=new HomePage();
	    hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));			
	    GetEnrolledPage gt=hp.selectLiveAndSelfPacedCourses(data.get("Self-Paced And Live courses"));
		gt.clickOnEnrollNow().clickOnpaypal()
		.clickOnguestCheckout(data);			
	}
	
	@Test(priority=5,dataProvider="data")
	public void getaFreecourse(Hashtable<String, String> data) throws Exception {
		logger.log(LogStatus.INFO, data.get("Description"));
		HomePage hp=new HomePage();
		hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));		
		hp.entercourse(data.get("Course")).clickSearch().selectCourse(data.get("Course")).clickOnGetEnrolled();
		hp.logout();
		LoginPage lpp = new LoginPage();
		lpp .verifylogin(""+prop.get("Adminusername"), ""+prop.get("Adminpasswprd"));
		menuPage menu = new menuPage();
		menu.clickEnrollment().clickenrollmentHistory().unenrollcourse(data.get("username"), data.get("Course"));
	}
	
	@Test(priority=6, dataProvider="data")
	public void MaximumUsage(Hashtable<String, String> data) throws Exception{
		logger.log(LogStatus.INFO, data.get("Description"));
		HomePage hp=new HomePage();
		hp.clickOnLogin().verifylogin(""+prop.get("Adminusername"), ""+prop.get("Adminpasswprd"));
		int usage = Integer.parseInt(data.get("Maximum usage"));
		menuPage menu = new menuPage();
		menu.clickStudents();
		studentsListPage students = new studentsListPage();
		for(int k=0; k<=usage; k++){
			new studentsPage().clickStudentsubmenu();
			students.deleteUser("datasparktest"+k+"@gmail.com");
		}
		
		for(int i = 0; i<=usage; i++){
			new studentsPage().clickStudentsubmenu();
			
			studentsListPage add = new studentsListPage();
			add.clickAddUser().enterBasicInfo("Firstname"+i, "LastName"+i)
			.enterlogindetails("datasparktest"+i+"@gmail.com", data.get("password"))
			.clicknext()
			.clicknext();
			
			studentAddFormFinish finish = new studentAddFormFinish();
			finish.clickSubmit();
			
			int k = 0;
			do{
				if(driver.findElement(By.xpath("/html/body/div[6]/div")).getAttribute("style").contains("display: none;")){
					break;
				}
				k++;
			}while(k < 1000);
		}
		
		addCouponPage coupon = menu.clickCoupons().clickDeleteCoupon(data.get("Coupon Title")).clickAddcoupon();
		coupon.entercoursetitle(data.get("Coupon Title")).entercoursecode(data.get("Coupon Code"))
		.selectDiscountFor(data.get("Discount For")).selectcoupontype(data.get("Discount Type"));
		
		coupon.selectcouponorVoucher(data.get("Coupon Type")).entermaxUsage(data.get("Maximum usage")).clickSaveandContinue();
		
		addCouponextPage coupext = new addCouponextPage();
		coupext.selectCourseType(data.get("CoursesType")).verifySuccessMessage();	
		
		coupext.selectCourse(data.get("Courses"));
		
		boolean display = driver.findElement(By.xpath("//button[contains(text(),'"+data.get("Courses")+"')]")).isDisplayed();
		assertTrue(display);
		
		boolean success2 = driver.findElement(By.xpath("(//p[text()='updated successfully'])[2]")).isDisplayed();
		assertTrue(success2);
		
		driver.findElement(By.xpath("//a/span[text()='Basic']")).click();
		
		Select status = new Select(driver.findElement(By.xpath("//select[@name='coupon_status']")));
		status.selectByVisibleText(data.get("Status"));
		
		driver.findElement(By.xpath("//button[text()='Save and Continue']")).click();		
		
		menu.logout();
		
		for(int j = 0; j<=usage; j++){
			hp.clickOnLogin().verifylogin("datasparktest"+j+"@gmail.com", data.get("password"));
			
			hp.entercourse(data.get("Courses")).clickSearch().selectCourse(data.get("Courses")).
			clickApplyCoupon().entercouponCode(data.get("Coupon Code")).clickApply();			
			
			if(j == usage){
				discountPage discount = new discountPage();
				discount.verifyExpired();
				hp.logout();
				break;
			}else{
				courseDetailPage details = new courseDetailPage();
				details.clickOnGetEnrolled();
			}
			
			hp.logout();
		}
		
		hp.clickOnLogin().verifylogin(""+prop.get("Adminusername"), ""+prop.get("Adminpasswprd"));
		menu.clickStudents().clickStudentsubmenu();
		
		for(int k=0; k<=usage; k++){
			students.deleteUser("datasparktest"+k+"@gmail.com");
		}
		
	}
	
	@Test(priority=7, dataProvider="data")
	public void TestCompleteCoupons(Hashtable<String, String> data) throws Exception{
		logger.log(LogStatus.INFO, data.get("Description"));
		HomePage hp=new HomePage();
		hp.clickOnLogin().verifylogin(""+prop.get("Adminusername"), ""+prop.get("Adminpasswprd"));
		menuPage menu = new menuPage();
		addCouponPage coupon = menu.clickCoupons().clickDeleteCoupon(data.get("Coupon Title")).clickAddcoupon();
		coupon.entercoursetitle(data.get("Coupon Title")).entercoursecode(data.get("Coupon Code"))
		.selectDiscountFor(data.get("Discount For")).selectcoupontype(data.get("Discount Type"));		
		
		if(!data.get("Discount Type").equals("Full Free")){
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
					coupon.enterFlatDiscountInDol(data.get("Flat discount $"));
				}else if(data.get("Discount Type").equals("Percentage Discount")){
					coupon.enterpercentDiscountIN(data.get("Discount INR"));
					coupon.enterpercentDiscountDol(data.get("Discount $"));
				}
				coupon.enterminamountIN(data.get("Minimum Amount in INR"));
				coupon.enterminDolAmount(data.get("Minimum Amount in $"));
			}
		}		
		
		coupon.selectcouponorVoucher(data.get("Coupon Type")).entermaxUsage(data.get("Maximum usage")).clickSaveandContinue();
		
		addCouponextPage coupext = new addCouponextPage();
		coupext.selectCourseType(data.get("CoursesType")).verifySuccessMessage();		
		
		
		if(data.get("CoursesType").equals("Cutom Multiple Courses")){
			coupext.selectCourse(data.get("Courses"));
			
			boolean display = driver.findElement(By.xpath("//button[contains(text(),'"+data.get("Courses")+"')]")).isDisplayed();
			assertTrue(display);
			
			boolean success2 = driver.findElement(By.xpath("(//p[text()='updated successfully'])[2]")).isDisplayed();
			assertTrue(success2);			
		}
		
		
		driver.findElement(By.xpath("//a/span[text()='Basic']")).click();
		
		Select status = new Select(driver.findElement(By.xpath("//select[@name='coupon_status']")));
		status.selectByVisibleText(data.get("Status"));
		
		driver.findElement(By.xpath("//button[text()='Save and Continue']")).click();		
		
		menu.logout();
				
		if(data.get("User").equals("Non - Indian")){
			hp.clickCountry().selectUS();
			Thread.sleep(2000);
		}
		
		hp.clickOnLogin().verifylogin(data.get("username"), data.get("password"));
		
		hp.entercourse(data.get("Courses")).clickSearch().selectCourse(data.get("Courses")).
		clickApplyCoupon().entercouponCode(data.get("Coupon Code")).clickApply().verifyResult(data.get("Result"));		
		
	}

	
}
