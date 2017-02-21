package com.vpals.apps.Ingestion.CustomJobExecutor.entity;

public class CustomJobDetails {

	private String customJobLocation;
	private HostDetails hostDetails;
	private String customJobArgText;
	private String customJobFileName;
	private String customJobClassName;
	
	public String getCustomJobClassName() {
		return customJobClassName;
	}
	public void setCustomJobClassName(String customJobClassName) {
		this.customJobClassName = customJobClassName;
	}
	private String customJobType;
	
	public String getCustomJobLocation() {
		return customJobLocation;
	}
	public void setCustomJobLocation(String customJobLocation) {
		this.customJobLocation = customJobLocation;
	}
	public HostDetails getHostDetails() {
		return hostDetails;
	}
	public void setHostDetails(HostDetails hostDetails) {
		this.hostDetails = hostDetails;
	}
	public String getCustomJobArgText() {
		return customJobArgText;
	}
	public void setCustomJobArgText(String customJobArgText) {
		this.customJobArgText = customJobArgText;
	}
	public String getCustomJobFileName() {
		return customJobFileName;
	}
	public void setCustomJobFileName(String customJobFileName) {
		this.customJobFileName = customJobFileName;
	}
	public String getCustomJobType() {
		return customJobType;
	}
	public void setCustomJobType(String customJobType) {
		this.customJobType = customJobType;
	}
	
}
