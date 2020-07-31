package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class ajaxsearchboxPage extends BaseClass{
	@FindBy(xpath="//ul[@class='ajax-search-box']//a")
	List<WebElement> searchList;
	
	public ajaxsearchboxPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateAjaxSearch(String strtext){
		for(WebElement e:searchList){
			assertTrue(e.getText().contains(strtext));
		}
	}
}
