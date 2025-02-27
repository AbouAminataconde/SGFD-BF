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
import com.org.sfors.dto.AffectationDto;
import com.org.sfors.service.AffectationServices;



@RestController
@CrossOrigin
public class AffectationController {
	
	@Autowired
	private AffectationServices affectationServices;
	
	/**
	 * Endpoint
	 * @param dtoFormation
	 * @return
	 */
	
	@PostMapping("/affectation")
	public AffectationDto addAffectation(@RequestBody AffectationDto affectation ) {
		
		return affectationServices.addAffectation(affectation);
	}
	
	@PutMapping("/affectation/{uuid}")
	public AffectationDto updatAffectation(@RequestBody AffectationDto dtoAffectation,@PathVariable String uuid ) {
		
		return affectationServices.updatAffectation(dtoAffectation, uuid);
	}
	
	@GetMapping("/affectation")
	public List<AffectationDto> findAllAffectation(){
		return affectationServices.findAll();
	}
	
	@GetMapping("/affectation/{uuid}")
	public AffectationDto getAffectation(@PathVariable String uuid) {
		return affectationServices.getAffectation(uuid);
	}

	@DeleteMapping("/affectation/{uuid}")
	public void deleteByUuid(@PathVariable String uuid) {
		affectationServices.deleteAffectation(uuid);
	}
}
