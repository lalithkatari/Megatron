package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateLeadPage;
import pages.ViewLeadPage;
import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC01_CreateLead extends OpentapsWrappers{
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
		dataSheetName 	= "TC01_CreateLead";
		testCaseName 	= "TC01 - CreateLead (POM)";
		testDescription = "Create Lead in Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void createLeadForSuccess(String username, String password, String loginName, String companyName,String firstName, String lastName) throws InterruptedException {
		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.threadSleep()
		.clickLogin()		
		.verifyLoggedinUserName(loginName)
		.clickCrmSfa()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstname(firstName)
		.enterlastname(lastName)
		.clickCreateLeadButton()
		.verifyFirstname(firstName)
		.verifylastname(lastName);
	}
}