package com.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		Map<String, String> mobileEmulation = new HashMap<>();

		mobileEmulation.put("deviceName", "iPad");
		
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.google.co.in/");
		
//		driver.get("https://accounts.zoho.in/signin?servicename=VirtualOffice&signupurl=https://www.zoho.in/mail/zohomail-pricing.html&serviceurl=https://mail.zoho.in");
//		driver.findElement(By.id("login_id")).sendKeys("sparkdatabox@zohomail.in");
//		JavascriptExecutor js=((JavascriptExecutor)driver);
//		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button/span[text()='Next']")));
//		driver.findElement(By.id("password")).sendKeys("test@1234t");
//		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button/span[text()='Sign in']")));
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[@title='noreply@zohoaccounts.in']")));
//		driver.findElement(By.xpath("//div/span[@title='noreply@zohoaccounts.in']")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Contact us']")));
//		driver.findElement(By.xpath("//a[text()='Contact us']")).click();
		
	}

}
