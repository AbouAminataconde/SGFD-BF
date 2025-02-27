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

import com.org.sfors.dto.InscriptionDto;
import com.org.sfors.service.InscriptionsServices;


@RestController
@CrossOrigin
public class InscriptionController {
	
	@Autowired
	private InscriptionsServices serviceInscription;
	
	/**
	 * Endpoint
	 * @param dtoInscription
	 * @return
	 */
	
	@PostMapping("/inscription")
	public InscriptionDto addInscription(@RequestBody InscriptionDto dtoInscription ) {
		
		return serviceInscription.addInscription(dtoInscription);
	}
	
	@PutMapping("/inscription/{uuid}")
	public InscriptionDto updatinscription(@RequestBody InscriptionDto dtoInscription,@PathVariable String uuid ) {
		
		return serviceInscription.updatInscription(dtoInscription, uuid);
	}
	
	@GetMapping("/inscription/all")
	public List<InscriptionDto> findAllInscription(){
		return serviceInscription.findAll();
	}
	
	@GetMapping("/inscription/{uuid}")
	public InscriptionDto findInscriptionByUuid(@PathVariable String uuid) {
		return serviceInscription.getInscription(uuid);
	}

	@DeleteMapping("/inscription/{uuid}")
	public void deleteByUuid(@PathVariable String uuid) {
		serviceInscription.deleteInscription(uuid);
	}
}
