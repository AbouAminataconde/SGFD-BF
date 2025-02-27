package com.org.sfors.service;

import java.util.List;

import com.org.sfors.dto.AffectationDto;

public interface AffectationServices {
	
	AffectationDto addAffectation(AffectationDto affectationdto);
	
	AffectationDto updatAffectation(AffectationDto affectationdto, String uuid);
	
	AffectationDto getAffectation(String uuid);
	
	List<AffectationDto> findAll();
	
	void deleteAffectation(String uuid);

}
