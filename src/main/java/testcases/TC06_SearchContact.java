package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC06_SearchContact extends OpentapsWrappers{
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
		dataSheetName 	= "TC06_SearchContact";
		testCaseName 	= "TC06 -SearchContact (POM)";
		testDescription = "CreateContact in Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void CreateContactForSuccess(String username, String password, String loginName, String companyName,String firstName, String lastName) throws InterruptedException {
		new LoginPage()
		.enterUserName(username)
		.enterPassword(password)
		.threadSleep()
		.clickLogin()		
		.verifyLoggedinUserName(loginName)
		.clickCrmSfa()
		.
		.enterCompanyName(companyName)
		.enterFirstname(firstName)
		.enterlastname(lastName)
		.clickCreateLeadButton()
		.verifyFirstname(firstName)
		.verifylastname(lastName);
	}
}

