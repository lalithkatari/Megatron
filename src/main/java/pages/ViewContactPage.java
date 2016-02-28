package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class ViewContactPage extends OpentapsWrappers{

	public ViewContactPage() {

		if (!verifyTitle("View Contact | opentaps CRM")) {
			Reporter.reportStep("This is not view contact page", "FAIL");
		}
	}

	
	public ViewContactPage verifyFirstName(String firstName) {

		verifyTextById(prop.getProperty("ViewContacts.VerifyFirstName.id"),firstName);
		return this;

	}

	public ViewContactPage verifyLastName(String lastName) {

		verifyTextById(prop.getProperty("ViewContacts.VerifyLastName.id"),lastName);
		return this;

	}
	
	
}
