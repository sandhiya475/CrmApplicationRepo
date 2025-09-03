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

@Listeners(generic_Utility.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "regression")
	public void createOrganizationTc_001() throws EncryptedDocumentException, IOException {
		Home_Page hp = new Home_Page(driver);
		hp.getOrganizationLink().click();
		Organization_Page op = new Organization_Page(driver);
		op.getCreateorganizationLink().click();
		ExcelFileUtility eutil = new ExcelFileUtility();
		JavaUtility jutil = new JavaUtility();
		String orgname = eutil.ToReadDataFromExcelFile("Organization", 1, 2);
		Create_Organization_Page cp = new Create_Organization_Page(driver);
		cp.getOrganizatioName().sendKeys(orgname+jutil.toCallRandom());
		cp.getOrgsaveBt().click();
		Organization_Info_Page oip = new Organization_Info_Page(driver);
		String actualorgname = oip.getActualOrgname().getText();
		Assert.assertTrue(actualorgname.contains(orgname));
		Reporter.log("Organization created successfully",true);
	}
}
