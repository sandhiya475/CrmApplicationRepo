package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Page {
	
	public Organization_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorganizationLink;

	public WebElement getCreateorganizationLink() {
		return createorganizationLink;
	}

	
}
