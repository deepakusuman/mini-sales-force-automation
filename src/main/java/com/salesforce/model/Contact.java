package com.salesforce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contactSeq")
	@SequenceGenerator(name = "contactSeq", sequenceName = "msfa_contact_sequence", initialValue = 5, allocationSize = 1)
	private int cId;

	private String name;

	private String account;

	private String address;

	private String title;

	private String workPhone;

	private String mobilePhone;

	private String email;

	@ManyToMany(mappedBy = "associatedContacts",  cascade = CascadeType.REMOVE)
	private List<Opportunity> linkedOpportunities = new ArrayList<>();

	public void addOpportunities(Opportunity opportunity) {
		linkedOpportunities.add(opportunity);
	}
	

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
