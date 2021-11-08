package com.salesforce.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.salesforce.model.Contact;

public interface ContactServices {
	
	public String addContact(Contact contact);
	
	public String searchAllContact();

	public ModelAndView searchContactByNameAndEmail(String name, String email);
	
	public ModelAndView searchContacts();
	
	public ModelAndView deleteContact(int cId);
	
	public String manageContact(int cId,Model model);
	
	public ModelAndView updateContact(Contact contact);
	
	public String addAssociatedContact(int oId,Model model);

}
