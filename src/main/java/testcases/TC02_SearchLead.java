package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC02_SearchLead extends OpentapsWrappers{
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "chrome";
		dataSheetName 	= "TC02_SearchLead";
		testCaseName 	= "TC02 -SearchLead (POM)";
		testDescription = "Search Lead in Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void SearchLeadForSuccess(String username, String password, String loginName,String firstName, String lastName) throws InterruptedException {
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
		.verifyFirstname(firstName)
		.verifylastname(lastName);

	}
}