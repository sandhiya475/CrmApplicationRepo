package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Contact_Page {
	
	public Create_Contact_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameTextField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement organAddBt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBt;

	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getSaveBt() {
		return saveBt;
	}

	public WebElement getOrganAddBt() {
		return organAddBt;
	}
	
	

}
