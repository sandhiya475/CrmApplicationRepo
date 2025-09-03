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
import element_Repository.SelectOrgPage;
import generic_Utility.BaseClass;
import generic_Utility.ExcelFileUtility;
import generic_Utility.WebDriverUtility;

@Listeners(generic_Utility.ListenersImplementation.class)
public class ToCreateContactWithOrgTest extends BaseClass {

	@Test(groups = "smoke")
	public void toCreateContactTc_002() throws EncryptedDocumentException, IOException {
		Home_Page hp = new Home_Page(driver);
		hp.getContactsLink().click();
		Contacts_Page cp = new Contacts_Page(driver);
		cp.getCreateContactBt().click();
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.ToReadDataFromExcelFile("contacts", 1, 2);
		Create_Contact_Page ccp = new Create_Contact_Page(driver);
		ccp.getLastnameTextField().sendKeys(LASTNAME);
		WebDriverUtility wutil = new WebDriverUtility();
		String parentid =wutil.toCaptureParentId(driver);
		ccp.getOrganAddBt().click();
		String partialTitle = eutil.ToReadDataFromExcelFile("Contacts", 1, 3);
		wutil.toSwitchWindow(driver, partialTitle);
		SelectOrgPage so = new SelectOrgPage(driver);
		so.getSelectOrgname().click();
		wutil.toSwitchToParentWindow(driver, parentid);
		ccp.getSaveBt().click();
		Contact_Info_Page cif = new Contact_Info_Page(driver);
		String actualLastname = cif.getActualLastname().getText();
		Assert.assertTrue(actualLastname.contains(LASTNAME));
		Reporter.log("Contact Created Successfully",true);
		
	}
	
}
