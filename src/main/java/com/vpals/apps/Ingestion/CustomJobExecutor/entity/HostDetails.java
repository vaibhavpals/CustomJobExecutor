package com.vpals.apps.Ingestion.CustomJobExecutor.entity;

public class HostDetails {
	private String hostName;
	private String hostUser;
	private String hostPassword;
	private int hostPort;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostUser() {
		return hostUser;
	}
	public void setHostUser(String hostUser) {
		this.hostUser = hostUser;
	}
	public String getHostPassword() {
		return hostPassword;
	}
	public void setHostPassword(String hostPassword) {
		this.hostPassword = hostPassword;
	}
	public int getHostPort() {
		return hostPort;
	}
	public void setHostPort(int hostPort) {
		this.hostPort = hostPort;
	}
	
}
