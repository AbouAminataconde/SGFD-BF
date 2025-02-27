package com.org.sfors.controller;

import java.util.List;

import com.org.sfors.dto.UtilisateurDto;
import com.org.sfors.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UtilisateurController {
	 
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("/utilisateur/password/{username}/{password}")
	public UtilisateurDto getPassword(@PathVariable String username,@PathVariable String password) {
		return utilisateurService.getPassword(username, password);
	}
	
	
	@PostMapping("/utilisateur")
	public UtilisateurDto addUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
		return utilisateurService.addUtilisateur(utilisateurDto);
	}
	@PutMapping("/utilisateur/{uuid}")
	public UtilisateurDto updateUtilisateur(@RequestBody UtilisateurDto utilisateurDto,@PathVariable String uuid) {
		return utilisateurService.updateUtilisateur(utilisateurDto, uuid);
	}
	@GetMapping("/utilisateur")
	public List<UtilisateurDto> findAll(){
		return utilisateurService.findAll();
	}
	@GetMapping("/utilisateur/{uuid}")
	public UtilisateurDto getUtilisateur(@PathVariable String uuid) {
	    return utilisateurService.getUtilisateur(uuid);
	}
	@DeleteMapping("/utilisateur/{uuid}")
	public void deleteUtilisateur(@PathVariable String uuid) {
		utilisateurService.deleteUtilisateur(uuid);
	}
	
	@GetMapping("/utilisateurEmail/{email}")
	public UtilisateurDto findByEmail(@PathVariable String email){
		return utilisateurService.getUtilisateurByEmail(email);
	}

	
	
}
