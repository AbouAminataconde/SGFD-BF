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
import com.org.sfors.dto.FormateurDto;
import com.org.sfors.service.FormateursServices;


@RestController
@CrossOrigin
public class FormateurController {
	
	@Autowired
	private FormateursServices serviceFormateur;
	
	/**
	 * Endpoint
	 * @param dtoFormateur
	 * @return
	 */
	
	@PostMapping("/formateur")
	public FormateurDto addFormateur(@RequestBody FormateurDto dtoFormateur ) {
		
		return serviceFormateur.addFormateur(dtoFormateur);
	}
	
	@PutMapping("/formateur/{uuid}")
	public FormateurDto updatFormateur(@RequestBody FormateurDto dtoFormateur,@PathVariable String uuid ) {
		
		return serviceFormateur.updatFormateur(dtoFormateur, uuid);
	}
	
	@GetMapping("/formateur")
	public List<FormateurDto> findAllFormateur(){
		return serviceFormateur.findAll();
	}
	
	@GetMapping("/formateur/{uuid}")
	public FormateurDto findFormateurByUuid(@PathVariable String uuid) {
		return serviceFormateur.getFormateur(uuid);
	}

	@DeleteMapping("/formateur/{uuid}")
	public void deleteByUuid(@PathVariable String uuid) {
		 serviceFormateur.deleteFormateur(uuid);
	}
}
