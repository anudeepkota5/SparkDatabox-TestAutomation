package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class paymentDebitOrCredit extends BaseClass{	
	
@FindBy(xpath="//a[text()='Pay with Debit or Credit Card']")
WebElement debitOrcredit;

public paymentDebitOrCredit() {
	PageFactory.initElements(driver, this);
}

public PayPalGuestCheckOut clickOndebitOrcredit() {
	debitOrcredit.click();
	return new PayPalGuestCheckOut();
}

}
