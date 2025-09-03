package generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * 
	 */

	/**
	 * This method is used to max browser when we pass driver
	 * 
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to min browser when we pass driver
	 * 
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait until the element is loaded when we pass driver
	 * 
	 * @param driver
	 */
	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is used to wait until the element be made clickable when we give
	 * driver and element
	 * 
	 * @param driver
	 * @param element
	 */

	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This methpd is used to wait until the element is visible provided driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */
	public void visibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to handle dropdown by using Index provided element and
	 * index
	 * 
	 * @param element
	 * @param index
	 */
	public void toHandleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to handle dropdown by using Value provided element and
	 * value
	 * 
	 * @param element
	 * @param value
	 */
	public void toHandleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle dropdown using visibletext provided element and
	 * visibletext
	 * 
	 * @param text
	 * @param element
	 */

	public void toHandleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * This method is used to switch to frame using index provided driver and index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to frame using id or name provided driver and
	 * name or id
	 * 
	 * @param driver
	 * @param name_id
	 */
	public void toHandleFrame(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}

	/**
	 * This method is used to switch frame using webElement provided driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */
	public void tohandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch back from frame to default window provided
	 * driver
	 * 
	 * @param driver
	 */
	public void toSwitchBack(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to mouseOver element provided driver and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseOver(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		;
	}

	/**
	 * This method is used to right click the WebElement provided driver and element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * This method is used to perform double click action provided driver and
	 * element
	 * 
	 * @param driver
	 * @param element
	 */

	public void toDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * This method is used to perform drag and drop webElement provided driver
	 * ,source element and target element
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void toDragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used to accept alert popup
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopupByAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to dismiss alert popup
	 * 
	 * @param driver
	 */
	public void toHandleAlertPopupDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will return Alert message and also accept the alert
	 * 
	 * @param driver
	 * @return
	 */
	public String toCaptureAlertMessageAndAccept(WebDriver driver) {
		Alert alertPopup = driver.switchTo().alert();
		String alertMessage = alertPopup.getText();
		alertPopup.accept();
		return alertMessage;
	}

	/**
	 * This method is used to take screenshot of entire webPage
	 * 
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public String toTakeScreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src = new File(".\\errorShots\\" + screenshotname + ".png");
		FileHandler.copy(temp, src); // take fileHandler from selenium
		return src.getAbsolutePath(); //for ExtentReport
	}

	/**
	 * This Method is used to capture Parent window session id
	 * @param driver
	 * @return
	 */
	public String toCaptureParentId(WebDriver driver) {
		return driver.getWindowHandle();
	}

	/**
	 * This method is used to move driver from child to parent window provided
	 * driver and parentid
	 * 
	 * @param driver
	 */
	public void toSwitchToParentWindow(WebDriver driver, String parentId) {
		driver.switchTo().window(parentId);
	}

	/**
	 * This method is used to switchTo particular child window based on Title given
	 * and driver
	 * 
	 * @param driver
	 * @param partialTitle
	 */

	public void toSwitchWindow(WebDriver driver, String partialTitle) {
		Set<String> allIds = driver.getWindowHandles();

		for (String id : allIds) {
			String title = driver.switchTo().window(id).getTitle();
			if (title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	

}
