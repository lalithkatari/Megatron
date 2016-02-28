package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class MyContactsPage extends OpentapsWrappers{


	public MyContactsPage() {

		if(!verifyTitle("My Contacts | opentaps CRM")){
			Reporter.reportStep("This is NOT My Contacts page", "FAIL");
		}

	}
	
	public FindContactsPage clickFindContacts(){
		clickByLink(prop.getProperty("MyContacts.Findcontacts.linktext"));
		return new FindContactsPage();
	}
}
