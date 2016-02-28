package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class FindContactsPage extends OpentapsWrappers{

	
	public FindContactsPage() {

		if (!verifyTitle("Find Contacts | opentaps CRM")) {
			Reporter.reportStep("", "FAIL");
		}
	}

	
	public FindContactsPage enterFirstName(String firstName) {

		enterByXpath(prop.getProperty("FindContacts.firstname.xpath"),firstName );
		return this;

	}

	public FindContactsPage enterLastName(String lastName) {

		enterByXpath(prop.getProperty("FindContacts.lastname.xpath"),lastName );
		return this;

	}
    	
	public FindContactsPage clickFindContactsButton() {

		clickByXpath(prop.getProperty("//button[contains(text(),''Find Contacts)]"));
		return this;

	}


	public ViewContactPage clickContactfromContactList() {

		clickByPartialLinkText(prop.getProperty("FindContacts.ContactList.linktext"));
		return new ViewContactPage();

	}

	
	
	
}
