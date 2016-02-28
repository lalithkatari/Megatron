package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class ViewLeadPage extends OpentapsWrappers{

	public ViewLeadPage() {

		if(!verifyTitle("View Lead | opentaps CRM")){
			Reporter.reportStep("This is NOT View lead page", "FAIL");
		}

	}


	public ViewLeadPage verifyFirstname(String firstName)
	{
		verifyTextById(prop.getProperty("ViewLead.FirstName.Id"), firstName);
		return this;	
	}

	public ViewLeadPage verifylastname(String lastName)
	{
		verifyTextById(prop.getProperty("ViewLead.LastName.Id"), lastName);
		return this;	
	}

	public ViewLeadPage verifyCompanyname(String companyName)
	{
		verifyTextById(prop.getProperty("ViewLead.CompanyName.id"), companyName);
		return this;	
	}	
	
	public EditLeadPage clickEditLead() {
		clickByLink(prop.getProperty("ViewLead.EditLeadLink.LinkText"));
		return new EditLeadPage();
	}
	
	public MyLeadsPage clickDeleteLead() {
		clickByLink(prop.getProperty("ViewLead.EditLeadLink.LinkText"));
		return new MyLeadsPage();
	}

}
