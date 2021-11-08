package com.salesforce.controller;

import java.util.List;

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
import com.salesforce.service.ContactServices;

@Controller
public class ContactController {
	
	@Autowired
	private  ContactServices contactServices;
	
	@GetMapping("/createContact")
	public String createOpportunity(Model model) {
		
		model.addAttribute("contact", new Contact());
		return "addContact";
	}
	
	@PostMapping("/addContact")
	public String addOpportunity(@ModelAttribute("contact")Contact contact) {
		
		return contactServices.addContact(contact);
	}
	
	@RequestMapping("/filterSearchContacts")
	public String searchAllContact(Model model) {
		
		model.addAttribute("contact", new Contact());
		
		return contactServices.searchAllContact();
	}
	
	@PostMapping("/searchContactByNameAndEmail")
	public ModelAndView searchContactByNameAndEmail(@ModelAttribute("contact")Contact contact) {
		
		return contactServices.searchContactByNameAndEmail(contact.getName(),contact.getEmail());
	}
	
	@RequestMapping("/Contacts")
	public ModelAndView  searchContacts() {

		return contactServices.searchContacts();
	}
	
	@RequestMapping("/deleteContact/{cId}/")
	public ModelAndView deleteContact(@PathVariable int cId) {
		
		return contactServices.deleteContact(cId);
	}
	
	@RequestMapping("/manageContact/{cId}/")
	public String manageContact(@PathVariable int cId, Model model) {
		
		return contactServices.manageContact(cId,model);
	}
	
	@PostMapping("/updateContact")
	public ModelAndView updateContact(@ModelAttribute("contact")Contact contact) {
		
		return contactServices.updateContact(contact);
	}
	
	@RequestMapping("/addAssociatedContacts/{oId}/")
	public String  addAssociatedContact( @PathVariable int oId,Model model) {
		return contactServices.addAssociatedContact(oId,model);

	}
	
	@PostMapping("/addMultipleContacts")
	public String addMultipleContacts(@ModelAttribute("assContacts")List<Contact> contactsList) {
		
		return "addAssociatedContacts";
	}
	
}
