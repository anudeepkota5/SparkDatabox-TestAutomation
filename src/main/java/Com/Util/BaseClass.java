package Com.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;

public class BaseClass {
    private static BaseClass base;
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest logger;
	Logger log=Logger.getLogger(BaseClass.class);
	HomePage hp;
	
	public static BaseClass GetInstance() {
		if(base==null)
			base=new BaseClass();
		return base;
	}
	
	@BeforeSuite
	public void createReports(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("Host Name", "Windows");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}
	
	@BeforeMethod
	public void setUp(Method M) throws Exception {
		logger = extent.startTest(M.getName());
		BaseClass bas=BaseClass.GetInstance();
		bas.openBrowser();				
	}
	
	@DataProvider(name = "data")
	public Iterator<Object[]> getData(Method M) throws Exception {
		List<Hashtable<String,String>> dataList = DataDriven.readFile(M.getName());	
		List<Object[]> testArray = new ArrayList<Object[]>();
		Iterator<Hashtable<String,String>> dataiterator = dataList.iterator();
		while (dataiterator.hasNext()){			
			Object[] data = {dataiterator.next()};
			testArray.add(data);
		}
		return testArray.iterator();
	}
	
	@AfterMethod
	public void TearDown(ITestResult result, Method M) {
		if(driver!=null) 
		driver.quit();
		
		if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(LogStatus.PASS, M.getName());
			extent.endTest(logger);
		}else if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, M.getName());
			extent.endTest(logger);
		}else{
			logger.log(LogStatus.SKIP, M.getName());
			extent.endTest(logger);
		}
		
	}
	
	@AfterSuite
	public void teardown(){
		extent.close();
	}
	
	public WebDriver openBrowser() throws Exception {
		try{
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config.Properties");
			prop.load(fis);
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		if(prop.get("browser").equals("Chrome")) {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Nexus 5");
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
			driver=new ChromeDriver(chromeoptions);
		}else if(prop.get("browser").equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(prop.get("browser").equals("IE")){			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\IEDriverServer.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();	
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);			
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.IGNORE);
			capabilities.setCapability("ignorezoomsettings", true);
			capabilities.setCapability("nativeEvents", true);
			driver = new InternetExplorerDriver(capabilities);
		}
	
		driver.manage().window().maximize();
		log.debug("Opening url");
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public void verifyemail(){
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://accounts.zoho.in/signin?servicename=VirtualOffice&signupurl=https://www.zoho.in/mail/zohomail-pricing.html&serviceurl=https://mail.zoho.in");
				driver.findElement(By.id("login_id")).sendKeys("sparkdatabox@zohomail.in");
				JavascriptExecutor js=((JavascriptExecutor)driver);
				js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button/span[text()='Next']")));
				driver.findElement(By.id("password")).sendKeys("test@1234t");
				js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button/span[text()='Sign in']")));
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span[@title='noreply@zohoaccounts.in']")));
				driver.findElement(By.xpath("//div/span[@title='noreply@zohoaccounts.in']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Contact us']")));
				driver.findElement(By.xpath("//a[text()='Contact us']")).click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public static void takeScreenShot(String testmethod) {
		try {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(System.getProperty("user.dir")+"\\target\\shreenshots\\"+testmethod+".png"));
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		}
	
	public static void javaScriptClick(WebElement element) {
		
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()"
				, element);
		
	}
	public void ScrollElementIntoView(WebElement element)
    {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
	
	public void ScrolldownbyWindow()
    {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
    }
	
	public void JsSendKeys(WebElement e, String strText){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+strText+"';", e);
	}
	
	public void takescreenshot() throws Exception{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		logger.log(LogStatus.INFO, logger.addScreenCapture(destination));		
	}
}
