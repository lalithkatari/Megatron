package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class ContactsMainPage extends OpentapsWrappers {

	public ContactsMainPage() {

		if (!verifyTitle("Create Lead | opentaps CRM")) {
			Reporter.reportStep("This is NOT My Home page", "FAIL");
		}
	}

	
    public FindContactsPage clickFindContacts(String firstName) {

		clickByLink(prop.getProperty("ContactsMainPage.FindContacts.linktext"));
		return new FindContactsPage();

	}

	
	
	
}
