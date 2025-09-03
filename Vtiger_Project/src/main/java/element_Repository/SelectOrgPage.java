package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOrgPage {
	public SelectOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText ="Avatar430")
	private WebElement selectOrgname;

	public WebElement getSelectOrgname() {
		return selectOrgname;
	}
	
	
}
