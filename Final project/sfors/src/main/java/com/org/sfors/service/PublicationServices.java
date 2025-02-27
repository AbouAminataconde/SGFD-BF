package com.org.sfors.service;

import java.util.List;

import com.org.sfors.dto.InscriptionDto;
import com.org.sfors.dto.PublicationDto;

public interface PublicationServices {
	
	PublicationDto addPublication(PublicationDto publicationdto);
	
	PublicationDto updatPublication(PublicationDto publicationdto, String uuid);
	
	PublicationDto getPublication(String uuid);
	
	List<PublicationDto> findAll();
	
	PublicationDto findByPublication(String email);
	
	void deletePublication(String uuid);

}
