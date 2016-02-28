package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class EditContactPage extends OpentapsWrappers{

	public EditContactPage() {

		if(!verifyTitle("Edit Lead")){
			Reporter.reportStep("This is NOT Edit Lead page", "FAIL");
		}

	}


	public EditContactPage enterDepartment(String department)
	{
		enterById(prop.getProperty("EditContacts.Department.id"), department);
		return this;	
	}

	public EditContactPage selectCurrency(String currency)
	{
		selectById(prop.getProperty("EditContacts.Currency.id"), currency);
		return this;	
	}
	
	public EditContactPage enterFirstName(String firstName)
	{
		enterById(prop.getProperty("EditContacts.FirstName.id"), firstName);
		return this;	
	}	
	
	public EditContactPage enterLastName(String lastName)
	{
		enterById(prop.getProperty("EditContacts.LastName.id"), lastName);
		return this;	
	}
	
	public ViewContactPage clickUpdate()
	{
		clickByXpath(prop.getProperty("EditContacts.UpdateButton.xpath"));
		return new ViewContactPage();	
	}

}


