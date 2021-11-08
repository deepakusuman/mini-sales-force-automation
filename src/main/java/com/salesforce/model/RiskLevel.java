package com.salesforce.model;

public enum RiskLevel {
	
	HIGH("HIGH"),
	MEDIUM("MEDIUM"),
	LOW("LOW");
	
	
	private final String displayValue;
	
	private RiskLevel(String displayValue) {
		this.displayValue = displayValue;
	}
	
	 public String getDisplayValue() {
	        return displayValue;
	    }

}
