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

import com.org.sfors.dto.FormationDto;
import com.org.sfors.service.FormationsServices;


@RestController
@CrossOrigin
public class FormationController {
	
	@Autowired
	private FormationsServices serviceFormation;
	
	/**
	 * Endpoint
	 * @param dtoFormation
	 * @return
	 */
	
	@PostMapping("/formation")
	public FormationDto addFormation(@RequestBody FormationDto dtoFormation ) {
		
		return serviceFormation.addFormation(dtoFormation);
	}
	
	@PutMapping("/formation/{uuid}")
	public FormationDto updatFormation(@RequestBody FormationDto dtoFormation,@PathVariable String uuid ) {
		
		return serviceFormation.updatFormation(dtoFormation, uuid);
	}
	
	@GetMapping("/formation/all")
	public List<FormationDto> findAllFormation(){
		return serviceFormation.findAll();
	}
	
	@GetMapping("/formation/{uuid}")
	public FormationDto findFormationByUuid(@PathVariable String uuid) {
		return serviceFormation.getFormation(uuid);
	}

	@DeleteMapping("/formation/{uuid}")
	public void deleteByUuid(@PathVariable String uuid) {
		serviceFormation.deleteFormation(uuid);
	}
}
