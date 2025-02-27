package com.org.sfors.service;

import java.util.List;

import com.org.sfors.dto.InscriptionDto;

public interface InscriptionsServices {
	
	InscriptionDto addInscription(InscriptionDto inscriptiondto);
	
	InscriptionDto updatInscription(InscriptionDto inscriptiondto, String uuid);
	
	InscriptionDto getInscription(String uuid);
	
	List<InscriptionDto> findAll();
	
	InscriptionDto findByInscription(String email);
	
	void deleteInscription(String uuid);

}
