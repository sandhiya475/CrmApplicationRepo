package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Organization_Page {
	
	public Create_Organization_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizatioName;

	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(name="accounttype")
	private WebElement TypeDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement orgsaveBt;

	public WebElement getOrganizatioName() {
		return organizatioName;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getTypeDropdown() {
		return TypeDropdown;
	}

	public WebElement getOrgsaveBt() {
		return orgsaveBt;
	}
	
	
}
