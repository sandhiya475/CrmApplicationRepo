package generic_Utility;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import element_Repository.Home_Page;
import element_Repository.Login_Page;

public class BaseClass {
	
	PropertyFileUtility putil = new PropertyFileUtility();
	ExcelFileUtility eutil = new ExcelFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver ;// Only for Listeners
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforeSuiteConfig() {
		System.out.println("------DataBase Connected Successfully---");
	}
//	@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"smoke","regression"})
	public void beforeClassConfig(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();	
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver; // Only for listeners
		wutil.toMaximize(driver);
		wutil.waitForElement(driver);
		driver.get(URL);
	
		}
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforeMethodConfig() throws IOException {
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		Login_Page lp = new Login_Page(driver);
	
		lp.getUsernameTextField().sendKeys(USERNAME);
		lp.getPaswordTextField().sendKeys(PASSWORD);
		lp.getSubmitBt().click();
	}
	@AfterMethod(groups = {"smoke","regression"})
	public void afterMethodConfig() {
		Home_Page hp = new Home_Page(driver);
		wutil.toMouseOver(driver, hp.getMyProfileBt());
		hp.getSignOutBt().click();
	}
	@AfterClass(groups = {"smoke","regression"})
	public void afterClassConfig() {
		driver.quit();
	}
	@AfterSuite(groups = {"smoke","regression"})
	public void afterSuiteConfig() {
		System.out.println("---DataBase Connection Disconnected---");
	}
}