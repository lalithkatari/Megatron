package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC07_EditContact extends OpentapsWrappers{
	
	@BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
		dataSheetName 	= "TC07_EditContact";
		testCaseName 	= "TC07 -EditContact (POM)";
		testDescription = "CreateContact in Opentaps using POM framework";
	}
	
	
	@Test(dataProvider="fetchData")
	public void EditContactForSuccess(String username, String password, String loginName, String companyName,String firstName, String lastName) throws InterruptedException {
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
