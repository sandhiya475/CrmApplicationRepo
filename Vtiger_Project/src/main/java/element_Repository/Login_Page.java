package element_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement usernameTextField;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement paswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitBt;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPaswordTextField() {
		return paswordTextField;
	}

	public WebElement getSubmitBt() {
		return submitBt;
	}
	
	
}
