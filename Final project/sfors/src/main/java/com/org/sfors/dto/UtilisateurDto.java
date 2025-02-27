package com.org.sfors.dto;

import java.util.ArrayList;
import java.util.List;

import com.org.sfors.enums.EnumRole;

public class UtilisateurDto extends ResponseDto{
	
	private String uuid;
	private String email;
	private String phone;
	private String password;
	private List<EnumRole> roles = new ArrayList<EnumRole>();
	
	private boolean online;
    private boolean nonExpired ;
    private boolean nonLocked;
    private boolean Enabled;
    
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<EnumRole> getRoles() {
		return roles;
	}
	public void setRoles(List<EnumRole> roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public boolean isNonExpired() {
		return nonExpired;
	}
	public void setNonExpired(boolean nonExpired) {
		this.nonExpired = nonExpired;
	}
	public boolean isNonLocked() {
		return nonLocked;
	}
	public void setNonLocked(boolean nonLocked) {
		this.nonLocked = nonLocked;
	}
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	

}
