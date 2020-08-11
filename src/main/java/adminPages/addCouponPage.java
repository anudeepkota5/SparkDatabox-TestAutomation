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
	
	public addCouponPage entercoursetitle(String strcoursetitle) throws Exception{
		coursetitle.sendKeys(strcoursetitle);
		takescreenshot();
		return this;
	}
	
	public addCouponPage entercoursecode(String strcoursecode) throws Exception{
		coursecode.sendKeys(strcoursecode);
		takescreenshot();
		return this;
	}
	
	public addCouponPage selectDiscountFor(String strRegion) throws Exception{
		Select discountfor = new Select(discountforselect);
		discountfor.selectByVisibleText(strRegion);
		takescreenshot();
		return this;
	}
	
	public addCouponPage selectcoupontype(String strcoupontype) throws Exception{
		Select discountType = new Select(coupontypeselect);
		discountType.selectByVisibleText(strcoupontype);
		takescreenshot();
		return this;
	}
	
	public addCouponPage enterFlatDiscountIN(String stramountIN) throws Exception{
		amountIN.sendKeys(stramountIN);
		takescreenshot();
		return this;
	}
	
	public addCouponPage enterpercentDiscountIN(String strpercentin) throws Exception{
		percentIN.sendKeys(strpercentin);
		takescreenshot();
		return this;
	}
	
	public addCouponPage enterminamountIN(String strminamount) throws Exception{
		minamount.sendKeys(strminamount);
		takescreenshot();
		return this;
	}


	public void enterFlatDiscountInDol(String string) throws Exception {
		amountdol.sendKeys(string);
		takescreenshot();
	}

	public void enterpercentDiscountDol(String string) throws Exception {
		percentdol.sendKeys(string);
		takescreenshot();
	}

	public void enterminDolAmount(String string) throws Exception {
		minamountdol.sendKeys(string);
		takescreenshot();
	}

	public addCouponPage selectcouponorVoucher(String strCouponTye) throws Exception {
		Select voucherType = new Select(vouchertypeselect);
		voucherType.selectByVisibleText(strCouponTye);
		takescreenshot();
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
