package com.org.sfors.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.org.sfors.enums.EnumRole;

@Entity
//@Table(name = "utilisateur")
public class UtilisateurEntity extends AbstractEntity {
	
	@Column(unique = true, nullable = false)
	@Email(message = "Email should be valid")
	private String email; 
	
	@Column(unique = true, nullable = false)
	private String phone;
	 
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "UTILISATEUR_ROLES", joinColumns = @JoinColumn(name = "USER_ID"))
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE")
	private List<EnumRole> roles = new ArrayList<EnumRole>();
	
	@Column(name = "HASHED_PASSWORD", nullable = true)
	private String password;
	
	private boolean online;

    boolean nonExpired = true;

    boolean nonLocked = true;

    boolean Enabled = false;
    

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
