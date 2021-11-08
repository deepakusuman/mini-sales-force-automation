package com.salesforce.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.salesforce.model.Contact;
import com.salesforce.model.Opportunity;

public interface OpportunityServices {

	public String addOpportunity(Opportunity opportunity);
	
	public String searchOpportunities();

	public ModelAndView searchOpportunityByNameAndAcount(String name, String account);
	
	public ModelAndView getOpportunities();
	
	public ModelAndView deleteOportunity(int oId);
	
	public String manageOpportunity(int oId, Model model);
	
	public ModelAndView updateOpportunity(Opportunity opportunity);
	
	public String viewPrimaryContacts(int cId, int oId, Model model);
	
	public ModelAndView updatePrimaryContact(Opportunity opportunity, Contact contact);
	
}
