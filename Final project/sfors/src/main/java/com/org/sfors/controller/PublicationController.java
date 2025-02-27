package com.org.sfors.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.sfors.dto.PublicationDto;
import com.org.sfors.service.PublicationServices;


@RestController
@CrossOrigin
public class PublicationController {
	
	@Autowired
	private PublicationServices servicePublication;
	
	/**
	 * Endpoint
	 * @param dtoInscription
	 * @return
	 */
	
	@PostMapping("/publication")
	public PublicationDto newPublication(@RequestBody PublicationDto dtoPublication ) {
		return servicePublication.addPublication(dtoPublication);
	}
	
	@PutMapping("/publication/{uuid}")
	public PublicationDto updatPublication(@RequestBody PublicationDto dtoPublication,@PathVariable String uuid ) {
		return servicePublication.updatPublication(dtoPublication, uuid);
	}
	
	@GetMapping("/publication/all")
	public List<PublicationDto> findAllPublication(){
		return servicePublication.findAll();
	}
	
	@GetMapping("/publication/{uuid}")
	public PublicationDto findPublicationByUuid(@PathVariable String uuid) {
		return servicePublication.getPublication(uuid);
	}

	@DeleteMapping("/publication/{uuid}")
	public void deleteByUuid(@PathVariable String uuid) {
		servicePublication.deletePublication(uuid);
	}
}
