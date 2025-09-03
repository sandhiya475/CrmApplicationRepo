package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import element_Repository.Contact_Info_Page;
import element_Repository.Contacts_Page;
import element_Repository.Create_Contact_Page;
import element_Repository.Home_Page;
import generic_Utility.BaseClass;
import generic_Utility.ExcelFileUtility;


@Listeners(generic_Utility.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass{

	@Test(groups = "smoke")
	public void toCreateContact_001() throws EncryptedDocumentException, IOException {
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.ToReadDataFromExcelFile("Contacts",1, 2);
		Home_Page hp = new  Home_Page(driver);
		hp.getContactsLink().click();
		Contacts_Page cp = new Contacts_Page(driver);
		cp.getCreateContactBt().click();
		Create_Contact_Page ccp = new Create_Contact_Page(driver);
		ccp.getLastnameTextField().sendKeys(LASTNAME);
		ccp.getSaveBt().click();
		//To fail 
		//Assert.fail();
		Contact_Info_Page cif = new Contact_Info_Page(driver);
		String lastname= cif.getActualLastname().getText();
		Assert.assertTrue(lastname.contains(LASTNAME));
		Reporter.log("Contacts created Successfully ",true);
		
	
	}
}
