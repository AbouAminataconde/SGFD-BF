package com.org.sfors.service;

import java.util.List;

import com.org.sfors.dto.FormationDto;

public interface FormationsServices {
	
	FormationDto addFormation(FormationDto formationdto);
	
	FormationDto updatFormation(FormationDto formationdto, String uuid);
	
	FormationDto getFormation(String uuid);
	
	List<FormationDto> findAll();
	
	void deleteFormation(String uuid);

}
