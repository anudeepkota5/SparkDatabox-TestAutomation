package pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Util.BaseClass;

public class PayPalGuestCheckOut extends BaseClass{

	
	@FindBy(xpath="//button[text()='Accept Cookies']")
	WebElement acceptcookies;
	
	@FindBy(id="countrySelector")
	WebElement country;
	
	@FindBy(xpath="//input[@id='cc']")
	WebElement cardno;
	
	@FindBy(xpath="//input[@id='expiry_value']")
	WebElement expdate;
	
	@FindBy(xpath="//input[@id='cvv']")
	WebElement cvv;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='billingLine1']")
	WebElement add1;
	
	@FindBy(xpath="//input[@id='billingCity']")
	WebElement city;
	
	@FindBy(id="billingState")
	WebElement state;
	
	@FindBy(xpath="//input[@id='billingPostalCode']")
	WebElement postalcode;
	@FindBy(xpath="//input[@id='telephone']")
	WebElement telephne;
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//label[@class='noBottom ng-binding ng-scope']")
	WebElement paypalcheckbox;
	@FindBy(xpath="//input[@id='dobText']")
	WebElement dateofbirth;
	@FindBy(xpath="//select[@id='occupation']")
	WebElement occupation;
	
	@FindBy(xpath="//span[@class='bgImg']")
	WebElement bgimg;
	
	@FindBy(xpath="//label[@id='marketingOptinText']")
	WebElement agreeterms;
	
	@FindBy(xpath="(//label[@class='noBottom ng-binding'])[2]")
	WebElement nothanks;
	@FindBy(xpath="(//label[@class='noBottom ng-binding ng-scope'])[2]")
	WebElement nothanksterm;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement paynow;
	
	public PayPalGuestCheckOut() {
		PageFactory.initElements(driver, this);
	}
	
	//String cno,String edate,String cv,String fnam,String lnam,String add,String cit,String stat,String pcode,String tele,String emai
	public void clickOnguestCheckout(Hashtable<String, String> data) throws Exception {
		acceptcookies.click();
		Select sel=new Select(country);
		sel.selectByValue("US");
		takescreenshot("Enter Country as US");
		int k = 0;
		do{
			if(driver.findElement(By.id("main")).getAttribute("aria-busy").equals("false")){
				break;
			}
			k++;
		}while(k < 1000);
		JsSendKeys(cardno, data.get("cardno"));
		takescreenshot("Enter Card No as "+data.get("cardno"));
		JsSendKeys(expdate, data.get("expDate"));
		takescreenshot("Enter ExpDate as "+data.get("expDate"));
		cvv.sendKeys(data.get("cvv"));
		takescreenshot("Enter CVV as "+data.get("cvv"));
		fname.sendKeys(data.get("fname"));
		takescreenshot("Enter First Name as "+data.get("fname"));
		lname.sendKeys(data.get("lname"));
		takescreenshot("Enter Last Name as "+data.get("lname"));
		add1.sendKeys(data.get("address"));
		takescreenshot("Enter address as "+data.get("address"));
		city.sendKeys(data.get("city"));
		takescreenshot("Enter city as "+data.get("city"));
//		Select sel1=new Select(state);
//		sel1.selectByVisibleText(data.get("state"));
		state.sendKeys(data.get("state"));
		takescreenshot("Enter state as "+data.get("state"));
		postalcode.sendKeys(data.get("pincode"));
		takescreenshot("Enter Pincode as "+data.get("pincode"));
		telephne.sendKeys(data.get("telephn"));
		takescreenshot("Enter Telephone as "+data.get("telephn"));
		email.sendKeys(data.get("email"));
		takescreenshot("Enter Email ID as "+data.get("email"));
		ScrollElementIntoView(paynow);
		paynow.click();
		takescreenshot("Click on Paynow");
		//return new PayPalGuestCheckOut();
	}
}
