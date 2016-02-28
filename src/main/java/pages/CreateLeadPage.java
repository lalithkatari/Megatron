package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class CreateLeadPage extends OpentapsWrappers{

	public CreateLeadPage() {

		if(!verifyTitle("Create Lead | opentaps CRM")){
			Reporter.reportStep("This is NOT Create lead page", "FAIL");
		}

	}
		
	public CreateLeadPage enterCompanyName(String companyName)
	{
		enterById(prop.getProperty("CreateLead.CompanyName.Id"), companyName);
		return this;	
	}
	
	public CreateLeadPage enterFirstname(String firstName)
	{
		enterById(prop.getProperty("CreateLead.FirstName.Id"), firstName);
		return this;	
	}
	
	public CreateLeadPage enterlastname(String lastName)
	{
		enterById(prop.getProperty("CreateLead.LastName.Id"), lastName);
		return this;	
	}
	
	public ViewLeadPage clickCreateLeadButton()
	{
		clickByName(prop.getProperty("CreateLead.Submit.Name"));
		return new ViewLeadPage();	
	}
}
