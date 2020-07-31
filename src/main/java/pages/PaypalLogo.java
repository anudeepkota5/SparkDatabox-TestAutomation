package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class PaypalLogo extends BaseClass{	
	
@FindBy(xpath="//div/span[text()='Paypal']")
WebElement paypal;

public PaypalLogo() {
	PageFactory.initElements(driver, this);
}

public PayPalGuestCheckOut clickOnpaypal() throws Exception {
	ScrolldownbyWindow();
	paypal.click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='zoid-component-frame zoid-visible']")));
	ScrollElementIntoView(driver.findElement(By.xpath("//div[@class='paypal-button-label-container']/img[2]")));
	driver.findElement(By.xpath("//div[@class='paypal-button-label-container']/img[2]")).click();
	String parent_handle= driver.getWindowHandle();
	Set<String> handles = driver.getWindowHandles();
	for(String handle:handles){
		if(!parent_handle.equals(handle))
	    {
	        driver.switchTo().window(handle);
	    }
	}
	int k = 0;
	do{
		if(driver.findElement(By.id("preloaderSpinner")).getAttribute("style").equals("display: none;")){
			break;
		}
		k++;
	}while(k < 1000);
	Thread.sleep(2000);
	return new PayPalGuestCheckOut();
}




}
