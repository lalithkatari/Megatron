package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC04_DeleteLead extends OpentapsWrappers{
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
		dataSheetName 	= "TC04_DeleteLead";
		testCaseName 	= "TC04 -DeleteLead (POM)";
		testDescription = "Delete Lead in Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void DeleteLeadForSuccess(String username, String password, String loginName, String companyName,String firstName, String lastName) throws InterruptedException {
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
		.clickDeleteLead();
	}
}