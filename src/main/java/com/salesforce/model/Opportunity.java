package com.salesforce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Opportunity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "opportunitySeq")
	@SequenceGenerator(name = "opportunitySeq", sequenceName = "msfa_opportunity_sequence", initialValue = 5, allocationSize = 1)
	private int oId;

	private String name;

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(double winPercentage) {
		this.winPercentage = winPercentage;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public int getPrimaryContactId() {
		return primaryContactId;
	}

	public void setPrimaryContactId(int primaryContactId) {
		this.primaryContactId = primaryContactId;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getEstimatedRevenue() {
		return estimatedRevenue;
	}

	public void setEstimatedRevenue(String estimatedRevenue) {
		this.estimatedRevenue = estimatedRevenue;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	private double winPercentage;

	private String account;

	private String primaryContact;

	private int primaryContactId;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date closeDate;

	private String estimatedRevenue;

	private RiskLevel riskLevel;

	@ManyToMany
	@JoinTable(name = "associated_contacts", joinColumns = @JoinColumn(name = "o_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<Contact> associatedContacts = new ArrayList<>();
	
	public List<Contact> getAssociatedContacts() {
		return associatedContacts;
	}

	public void addAssociatedContacts(Contact contact) {
		associatedContacts.add(contact);
	}

}
