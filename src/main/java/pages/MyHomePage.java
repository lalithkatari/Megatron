package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class MyHomePage extends OpentapsWrappers{

	public MyHomePage() {

		if(!verifyTitle("My Home | opentaps CRM")){
			Reporter.reportStep("This is NOT My Home page", "FAIL");
		}

	}
	
	public CreateLeadPage clickCreateLead(){
		clickByLink(prop.getProperty("MyHome.CreateLead.LinkText"));
		return new CreateLeadPage();
		
		
	}
	
	public CreateContactPage clickCreateContact(){
		clickByLink(prop.getProperty("MyHome.CreateContact.linktext"));
		return new CreateContactPage();
		
		
	}
	
	public MyContactsPage clickContactButton(){
		clickByLink(prop.getProperty("MyHome.ContactsTab.linktext"));
		return new MyContactsPage();
		
		
	}
	
	public MyLeadsPage clickLeadButton(){
		clickByLink(prop.getProperty("MyHome.LeadsTab.linktext"));
		return new MyLeadsPage();
		
		
	}
	
	
}
