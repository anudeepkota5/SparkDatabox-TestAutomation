package adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.Util.BaseClass;

public class addCouponPage extends BaseClass{
	
	@FindBy(id="course_title")
	WebElement coursetitle;
	
	@FindBy(id="course_code")
	WebElement coursecode;
	
	@FindBy(id="discount_for_select")
	WebElement discountforselect;
	
	@FindBy(id="coupon_type_select")
	WebElement coupontypeselect;
	
	@FindBy(xpath="//input[@name='amount_in']")
	WebElement amountIN;
	
	@FindBy(xpath="//input[@name='percent_in']")
	WebElement percentIN;
	
	@FindBy(xpath="//input[@name='min_amount']")
	WebElement minamount;
	
	@FindBy(xpath="//input[@name='amount_dol']")
	WebElement amountdol;	
	
	@FindBy(xpath="//input[@name='percent_dol']")
	WebElement percentdol;
	
	@FindBy(xpath="//input[@name='min_amount_dol']")
	WebElement minamountdol;
	
	@FindBy(id="voucher_type_select")
	WebElement vouchertypeselect;
	
	@FindBy(xpath="//input[@name='max_usage']")
	WebElement maxUsage;
	
	@FindBy(xpath="//button[text()='Save and Continue']")
	WebElement saveandContinue;	
	
	public addCouponPage(){
		PageFactory.initElements(driver, this);
	}
	
	public addCouponPage entercoursetitle(String strcoursetitle){
		coursetitle.sendKeys(strcoursetitle);
		return this;
	}
	
	public addCouponPage entercoursecode(String strcoursecode){
		coursecode.sendKeys(strcoursecode);
		return this;
	}
	
	public addCouponPage selectDiscountFor(String strRegion){
		Select discountfor = new Select(discountforselect);
		discountfor.selectByVisibleText(strRegion);
		return this;
	}
	
	public addCouponPage selectcoupontype(String strcoupontype){
		Select discountType = new Select(coupontypeselect);
		discountType.selectByVisibleText(strcoupontype);
		return this;
	}
	
	public addCouponPage enterFlatDiscountIN(String stramountIN){
		amountIN.sendKeys(stramountIN);
		return this;
	}
	
	public addCouponPage enterpercentDiscountIN(String strpercentin){
		percentIN.sendKeys(strpercentin);
		return this;
	}
	
	public addCouponPage enterminamountIN(String strminamount){
		minamount.sendKeys(strminamount);
		return this;
	}


	public void enterFlatDiscountInDol(String string) {
		amountdol.sendKeys(string);
	}

	public void enterpercentDiscountDol(String string) {
		percentdol.sendKeys(string);
	}

	public void enterminDolAmount(String string) {
		minamountdol.sendKeys(string);
	}

	public addCouponPage selectcouponorVoucher(String strCouponTye) {
		Select voucherType = new Select(vouchertypeselect);
		voucherType.selectByVisibleText(strCouponTye);
		return this;
	}

	public addCouponPage entermaxUsage(String strmaxUsage) {
		maxUsage.sendKeys(strmaxUsage);
		return this;
	}
	
	public void clickSaveandContinue(){
		saveandContinue.click();		
	}
	
}
