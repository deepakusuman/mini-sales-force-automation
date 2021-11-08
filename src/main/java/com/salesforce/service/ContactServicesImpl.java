package com.salesforce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.salesforce.dao.ContactRepo;
import com.salesforce.model.Contact;

@Service
public class ContactServicesImpl implements ContactServices {

	
	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public String addContact(Contact contact) {
		
		contactRepo.save(contact);
		
		return "confirmContact";
		
	}
	
	@Override
	public String searchAllContact() {
		return "filterSearchContacts";
	}

	@Override
	public ModelAndView searchContactByNameAndEmail(String name, String email) {

		List<Contact> contacts = contactRepo.findAllByNameAndEmail(name, email);
		ModelAndView mv = new ModelAndView("/resultContacts");
		mv.addObject("contacts", contacts);
		
		return mv;
	}
	
	@Override
	public ModelAndView searchContacts() {

		ModelAndView mv = new ModelAndView("searchContacts");
		List<Contact> contacts = contactRepo.findAll();
		mv.addObject("contacts", contacts);

		return mv;
	}
	
	@Override
	public ModelAndView deleteContact(int cId) {

		contactRepo.deleteById(cId);
		RedirectView redirectView = new RedirectView("/Contacts");
		ModelAndView mv = new ModelAndView(redirectView);
		List<Contact> Contacts = contactRepo.findAll();
		mv.addObject("Contacts", Contacts);

		return mv;
	}
	
	@Override
	public String manageContact(int cId,Model model) {
		
		model.addAttribute("contact", contactRepo.findById(cId).orElse(new Contact()));
		
		return "manageContact";
	}
	
	@Override
	public ModelAndView updateContact(Contact contact) {
		
		contactRepo.save(contact);
		RedirectView redirectView = new RedirectView("/Contacts");
		ModelAndView mv = new ModelAndView(redirectView);
		List<Contact> Contacts = contactRepo.findAll();
		mv.addObject("Contacts", Contacts);
		return mv;
		
	}
	
	@Override
	public String addAssociatedContact(int oId,Model model) {
		
		model.addAttribute("contacts", contactRepo.findAll());
		model.addAttribute("oId", oId);
		model.addAttribute("assContacts", new ArrayList<Contact>());
		return "addAssociatedContacts";
	}
}
