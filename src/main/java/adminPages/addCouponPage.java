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
		takescreenshot("Enter "+strcoursetitle+" in Course Title");
		return this;
	}
	
	public addCouponPage entercoursecode(String strcoursecode) throws Exception{
		coursecode.sendKeys(strcoursecode);
		takescreenshot("Enter "+strcoursecode+" in Course Code");
		return this;
	}
	
	public addCouponPage selectDiscountFor(String strRegion) throws Exception{
		Select discountfor = new Select(discountforselect);
		discountfor.selectByVisibleText(strRegion);
		takescreenshot("Select "+strRegion+" in Discount For");
		return this;
	}
	
	public addCouponPage selectcoupontype(String strcoupontype) throws Exception{
		Select discountType = new Select(coupontypeselect);
		discountType.selectByVisibleText(strcoupontype);
		takescreenshot("Select "+strcoupontype+" in Coupon Type");
		return this;
	}
	
	public addCouponPage enterFlatDiscountIN(String stramountIN) throws Exception{
		amountIN.sendKeys(stramountIN);
		takescreenshot("Enter "+stramountIN+" in Amount IN");
		return this;
	}
	
	public addCouponPage enterpercentDiscountIN(String strpercentin) throws Exception{
		percentIN.sendKeys(strpercentin);
		takescreenshot("Enter "+strpercentin+" in Percentage IN");
		return this;
	}
	
	public addCouponPage enterminamountIN(String strminamount) throws Exception{
		minamount.sendKeys(strminamount);
		takescreenshot("Enter Minimum Amount as "+strminamount);
		return this;
	}


	public void enterFlatDiscountInDol(String string) throws Exception {
		amountdol.sendKeys(string);
		takescreenshot("Enter $ Amount" + string );
	}

	public void enterpercentDiscountDol(String string) throws Exception {
		percentdol.sendKeys(string);
		takescreenshot("Enter % in $ "+string);
	}

	public void enterminDolAmount(String string) throws Exception {
		minamountdol.sendKeys(string);
		takescreenshot("Enter Minimum Amount in $ "+string);
	}

	public addCouponPage selectcouponorVoucher(String strCouponTye) throws Exception {
		Select voucherType = new Select(vouchertypeselect);
		voucherType.selectByVisibleText(strCouponTye);
		takescreenshot("Select Voucher Type as "+strCouponTye);
		return this;
	}

	public addCouponPage entermaxUsage(String strmaxUsage) throws Exception {
		maxUsage.sendKeys(strmaxUsage);
		takescreenshot("Enter Maximum Usage as "+strmaxUsage);
		return this;
	}
	
	public void clickSaveandContinue() throws Exception{
		saveandContinue.click();	
		takescreenshot("Click on SAVE and CONTINUE button");
	}
	
}
