package com.salesforce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.salesforce.dao.OpportunityRepo;
import com.salesforce.model.Contact;
import com.salesforce.model.Opportunity;

@Service
public class OpportunityServicesImpl implements OpportunityServices {

	@Autowired
	OpportunityRepo opportunityRepo;

	@Override
	public String addOpportunity(Opportunity opportunity) {
		
		opportunityRepo.save(opportunity);
		
		return "confirmOpportunity";
		
	}
	
	@Override
	public String searchOpportunities() {
		return "searchOpportunity";
	}

	@Override
	public ModelAndView searchOpportunityByNameAndAcount(String name, String account) {
		
		List<Opportunity> opportunities = opportunityRepo.findAllByNameAndAccount(name, account);
		System.out.println(opportunities);
		ModelAndView mv = new ModelAndView("/resultOpportunity");
		mv.addObject("opportunities", opportunities);

		return mv;
	}
	
	@Override
	public ModelAndView getOpportunities() {

		ModelAndView mv = new ModelAndView("showOpportunity");
		List<Opportunity> opportunities = opportunityRepo.findAll();
		mv.addObject("opportunities", opportunities);
		return mv;
	}
	
	@Override
	public ModelAndView deleteOportunity(int oId) {

		opportunityRepo.deleteById(oId);
		RedirectView redirectView = new RedirectView("/Opportunities");
		ModelAndView mv = new ModelAndView(redirectView);
		List<Opportunity> opportunities = opportunityRepo.findAll();
		mv.addObject("opportunities", opportunities);

		return mv;
	}
	
	@Override
	public String manageOpportunity(int oId, Model model) {
		
		model.addAttribute("opportunity", opportunityRepo.findById(oId).orElse(new Opportunity()));
		return "manageOpportunity";
	}
	
	@Override
	public ModelAndView updateOpportunity(Opportunity opportunity) {
		
		opportunityRepo.save(opportunity);
		RedirectView redirectView = new RedirectView("/Opportunities");
		ModelAndView mv = new ModelAndView(redirectView);
		List<Opportunity> opportunities = opportunityRepo.findAll();
		mv.addObject("opportunities", opportunities);
		return mv;
		
	}
	
	@Override
	public String viewPrimaryContacts(int cId, int oId, Model model) {
		
		Opportunity opportunity = opportunityRepo.findById(oId).orElse(new Opportunity());
		
		List<Contact> contacts = opportunity.getAssociatedContacts();
		
		Contact primaryContact = contacts.stream().filter(contact -> (contact.getcId()== cId)).findFirst().get();

		model.addAttribute("primaryContact", primaryContact);
		model.addAttribute("contacts", contacts);
		model.addAttribute("oId", oId);
		model.addAttribute("contact", new Contact());
		model.addAttribute("opportunity", new Opportunity());
		return "showPrimaryContact";
	}
	
	@Override
	public ModelAndView updatePrimaryContact(Opportunity opportunity, Contact contact) {
		
//		opportunityRepo.save(opportunity);
		RedirectView redirectView = new RedirectView("/Opportunities");
		ModelAndView mv = new ModelAndView(redirectView);
		List<Opportunity> opportunities = opportunityRepo.findAll();
		return mv.addObject("opportunities", opportunities);
		
	}
	
}
