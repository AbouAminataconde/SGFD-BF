package com.org.sfors.dto;

import java.util.List;

import com.org.sfors.entity.PublicationEntity;

public class FormationDto extends ResponseDto{
	
	private String uuid;
	private String libelleFormation;
	private String descriptionFormation;
	List<PublicationEntity> publicationList;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getLibelleFormation() {
		return libelleFormation;
	}
	public void setLibelleFormation(String libelleFormation) {
		this.libelleFormation = libelleFormation;
	}
	public String getDescriptionFormation() {
		return descriptionFormation;
	}
	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}
	
}
