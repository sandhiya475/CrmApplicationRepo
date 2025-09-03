package organizationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import element_Repository.Create_Organization_Page;
import element_Repository.Home_Page;
import element_Repository.Organization_Info_Page;
import element_Repository.Organization_Page;
import generic_Utility.BaseClass;
import generic_Utility.ExcelFileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;

@Listeners(generic_Utility.ListenersImplementation.class)
class CreateOrganizationWithIndustryTest extends BaseClass {

	@Test(groups = "regression")
	public void createOrgWithIndustryTc_002() throws EncryptedDocumentException, IOException {
		Home_Page hp = new Home_Page(driver);
		hp.getOrganizationLink().click();
		Organization_Page op = new Organization_Page(driver);
		op.getCreateorganizationLink().click();
		ExcelFileUtility eutil = new ExcelFileUtility();
		String orgname = eutil.ToReadDataFromExcelFile("Organization", 1, 2);
		Create_Organization_Page cp = new Create_Organization_Page(driver);
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		int randomvalue = jutil.toCallRandom();
		cp.getOrganizatioName().sendKeys(orgname+randomvalue);
		String industry = eutil.ToReadDataFromExcelFile("Organization",1,3);
		wutil.toHandleDropdown(cp.getIndustryDropdown(),industry);
		cp.getOrgsaveBt().click();
		Organization_Info_Page oip = new Organization_Info_Page(driver);
		String actualorgname = oip.getActualOrgname().getText();
		Assert.assertTrue(actualorgname.contains(orgname));
		Reporter.log("Organization created Successfully",true);
	}
}