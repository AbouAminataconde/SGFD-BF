package com.org.sfors.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "formation")
public class FormationEntity extends AbstractEntity{
	
	private String libelleFormation;
	private String descriptionFormation;

	@OneToMany(mappedBy = "formation")
	List<AffectationEntity> affectationList;
	
	@OneToMany(mappedBy = "formation")
	List<PublicationEntity> publicationList;
	
	/*@OneToMany(mappedBy = "formation")
	List<InscriptionEntity> inscriptionList;*/

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

	public List<AffectationEntity> getAffectationList() {
		return affectationList;
	}

	public void setAffectationList(List<AffectationEntity> affectationList) {
		this.affectationList = affectationList;
	}

	public List<PublicationEntity> getPublicationList() {
		return publicationList;
	}

	public void setPublicationList(List<PublicationEntity> publicationList) {
		this.publicationList = publicationList;
	}

	/*public List<InscriptionEntity> getInscriptionList() {
		return inscriptionList;
	}

	public void setInscriptionList(List<InscriptionEntity> inscriptionList) {
		this.inscriptionList = inscriptionList;
	}*/
	
	

}
