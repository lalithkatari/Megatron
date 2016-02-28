package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class EditLeadPage extends OpentapsWrappers{

	public EditLeadPage() {

		if(!verifyTitle("opentaps CRM")){
			Reporter.reportStep("This is NOT Edit Lead page", "FAIL");
		}

	}


	public EditLeadPage changeCompanyName(String companyName)
	{
		enterById(prop.getProperty("EditLead.Companyname.id"), companyName);
		return this;	
	}

	public EditLeadPage changeCurrency(String currency)
	{
		selectById(prop.getProperty("EditLead.currency.id"), currency);
		return this;	
	}
	
	public ViewLeadPage clickUpdate()
	{
		clickByName(prop.getProperty("EditLead.UpdateButton.Name"));
		return new ViewLeadPage();	
	}


}


