package com.org.sfors.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "affectation")
public class AffectationEntity extends AbstractEntity{
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateAffectation;

	@ManyToOne
	private FormateurEntity formateur;
	
	@ManyToOne
	private FormationEntity formation;

	public Date getDateAffectation() {
		return dateAffectation;
	}

	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}

	public FormateurEntity getFormateur() {
		return formateur;
	}

	public void setFormateur(FormateurEntity formateur) {
		this.formateur = formateur;
	}

	public FormationEntity getFormation() {
		return formation;
	}

	public void setFormation(FormationEntity formation) {
		this.formation = formation;
	}
	
	

}
