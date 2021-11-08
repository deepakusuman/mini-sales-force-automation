package com.salesforce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salesforce.model.Contact;
import com.salesforce.model.Opportunity;
import com.salesforce.service.OpportunityServices;

@Controller
public class OpportunityController {
	@Autowired
	private OpportunityServices opportunityServices;

	@GetMapping("/createOpportunity")
	public String createOpportunity(Model model) {

		model.addAttribute("opportunity", new Opportunity());
		return "addOpportunity";
	}

	@PostMapping("/addOpportunity")
	public String addOpportunity(@ModelAttribute("opportunity") Opportunity opportunity) {

		return opportunityServices.addOpportunity(opportunity);
	}

	@RequestMapping("/searchOpportunity")
	public String searchOpportunities(Model model) {
		model.addAttribute("opportunity", new Opportunity());
		return opportunityServices.searchOpportunities();
	}

	@PostMapping("/searchOportunityByNameAndAcount")
	public ModelAndView searchOportunityByNameAndAcount(@ModelAttribute("opportunity") Opportunity opportunity) {

		return opportunityServices.searchOpportunityByNameAndAcount(opportunity.getName(), opportunity.getAccount());
	}

	@RequestMapping("/Opportunities")
	public ModelAndView getOpportunities() {

		return opportunityServices.getOpportunities();
	}

	@RequestMapping("/deleteOportunity/{oId}/")
	public ModelAndView deleteOportunity(@PathVariable int oId) {

		return opportunityServices.deleteOportunity(oId);
	}

	@RequestMapping("/manageOpportunity/{oId}/")
	public String manageOpportunity(@PathVariable int oId, Model model) {

		return opportunityServices.manageOpportunity(oId, model);
	}

	@PostMapping("/updateOpportunity")
	public ModelAndView updateOpportunity(@ModelAttribute("opportunity") Opportunity opportunity) {

		return opportunityServices.updateOpportunity(opportunity);
	}

	@RequestMapping("/viewPrimaryContacts/{cId}/{oId}/")
	public String viewPrimaryContacts(@PathVariable int cId, @PathVariable int oId, Model model) {

		return opportunityServices.viewPrimaryContacts(cId, oId, model);
	}

	@PostMapping("/updatePrimaryContact")
	public ModelAndView updatePrimaryContact(@ModelAttribute("opportunity") Opportunity opportunity,
			@ModelAttribute("contact") Contact contact) {

		System.out.println(opportunity.getoId());
		System.out.println(contact.getcId());
		return opportunityServices.updatePrimaryContact(opportunity, contact);
	}
	
}
