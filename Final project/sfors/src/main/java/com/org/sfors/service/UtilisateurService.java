package com.org.sfors.service;

import java.util.List;

import com.org.sfors.dto.UtilisateurDto;

public interface UtilisateurService {
	
	UtilisateurDto addUtilisateur(UtilisateurDto utilisateurDto);
	
	UtilisateurDto updateUtilisateur(UtilisateurDto utilisateurDto, String uuid);
	
	public UtilisateurDto getPassword(String usernameOrPhoneNumber,String newPassowd);
	
	void deleteUtilisateur(String uuid);
	
	UtilisateurDto getUtilisateur(String uuid);
	
	public void deconnecterUtilisateur();
	
	List<UtilisateurDto> getByUserOnLigne();
	
	List<UtilisateurDto> findAll();
	
	UtilisateurDto getUtilisateurByEmail(String email);
	
	
	
	

}
