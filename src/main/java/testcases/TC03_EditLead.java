package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC03_EditLead extends OpentapsWrappers{
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "chrome";
		dataSheetName 	= "TC03_EditLead";
		testCaseName 	= "TC03 -EditLead (POM)";
		testDescription = "Edit Lead in Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void EditLeadForSuccess(String username, String password, String loginName, String companyName,String firstName, String lastName) throws InterruptedException {
		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.threadSleep()
		.clickLogin()		
		.verifyLoggedinUserName(loginName)
		.clickCrmSfa()
		.clickLeadButton()
		.clickFindLeads()
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.clickFindLeads()
		.clickLeadName()
	    .clickEditLead()
	    .changeCompanyName(companyName)
	    .clickUpdate()
        .verifyCompanyname(companyName);
	}
}