package com.org.sfors.service;

import java.util.List;

import com.org.sfors.dto.FormateurDto;

public interface FormateursServices {
	
	FormateurDto addFormateur(FormateurDto formateurdto);
	
	FormateurDto updatFormateur(FormateurDto formateurdto, String uuid);
	
	FormateurDto getFormateur(String uuid);
	
	List<FormateurDto> findAll();
	
	FormateurDto getFormateurByEmail(String email);
	
	void deleteFormateur(String uuid);

}
