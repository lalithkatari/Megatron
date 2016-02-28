package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class FindLeadsPage extends OpentapsWrappers{
	
	public FindLeadsPage(){
		
		if(!verifyTitle("Find Leads | opentaps CRM")){
			Reporter.reportStep("This is NOT Find Leads page", "FAIL");
		}
		
	}
	
	public FindLeadsPage clickLeads(){
		clickByLink(prop.getProperty("MyLeads.FindLeads.link"));
		return this;
	}
	public FindLeadsPage enterFirstName(String firstName){
		enterByXpath(prop.getProperty("FindLeads.FirstName.xpath"), firstName);
		return this;
}

	public FindLeadsPage enterLastName(String lastName){
		enterByXpath(prop.getProperty("FindLeads.LastName.xpath"), lastName);
		return this;
}

	public FindLeadsPage clickFindLeads(){
		clickByXpath(prop.getProperty("FindLeads.FindLeadButton.xpath"));
		return this;
	}
	public ViewLeadPage clickLeadName(){
		clickByXpath(prop.getProperty("FindLeads.LeadListId.Xpath"));
		return new ViewLeadPage();
	}
}



