package com.org.sfors.dto;

public class ResponseDto {
	
	private int code;
	private String titre;
	private String statut;
	private String description;

	public ResponseDto() {}
	
	public ResponseDto(int code, String titre,String statut, String description) {
		super();
		this.code = code;
		this.titre = titre;
		this.statut = statut;
		this.description = description;
		
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
