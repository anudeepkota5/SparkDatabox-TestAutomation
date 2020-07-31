package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Util.BaseClass;

public class coursesPage extends BaseClass{	
	@FindBy(xpath="//div[@class='category-course-list']//a[@class='course-title']")
	List<WebElement> searchList;
	
	public coursesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validatesearchResult(String strtext){
		for(WebElement e:searchList){
			System.out.println(e.getText());
			assertTrue(e.getText().toLowerCase().contains(strtext.toLowerCase()));
		}
	}
	
	public courseDetailPage selectCourse(String strtext){
		for(WebElement e:searchList){
			System.out.println(e.getText());
			if(e.getText().toLowerCase().contains(strtext.toLowerCase())){
				e.click();
			}
		}
		
		return new courseDetailPage();
	}
}
