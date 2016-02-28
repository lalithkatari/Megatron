package pages;

import org.testng.annotations.Test;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class CreateContactPage extends OpentapsWrappers{

	public CreateContactPage() {

		if(!verifyTitle("Create Contact | opentaps CRM")){
			Reporter.reportStep("This is NOT Contact lead page", "FAIL");
		}

	}
	
public CreateContactPage enterFirstname(String firstName)
{
	enterById(prop.getProperty("CreateContact.FirstName.Id"), firstName);
	return this;	
}

public CreateContactPage enterlastname(String lastName)
{
	enterById(prop.getProperty("CreateContact.LastName.Id"), lastName);
	return this;	
}

public ViewContactPage clickContactButton()
{
	clickByName(prop.getProperty("CreateContact.CreateContactButton.name"));
	return new ViewContactPage();	
}
}


	