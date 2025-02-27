package com.org.sfors.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.org.sfors.dto.UtilisateurDto;
import com.org.sfors.entity.UtilisateurEntity;
import com.org.sfors.exception.ResourceAlreadyExistException;
import com.org.sfors.mapper.Mapper;
import com.org.sfors.repository.UtilisateurRepository;
import com.org.sfors.service.UtilisateurService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	Logger logger = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

	@Override
	public UtilisateurDto addUtilisateur(UtilisateurDto utilisateurDto) {
		// TODO Auto-generated method stub
		UtilisateurEntity utilisateur = new UtilisateurEntity();
		
		UtilisateurDto dtoUsers = new UtilisateurDto();
		 if(dtoUsers.equals(null)) {
			 throw new ResourceAlreadyExistException(String.format("Création user echoué !"));
		 }else {
		utilisateur.setUuid(utilisateurDto.getUuid());
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setPhone(utilisateurDto.getPhone());
		utilisateur.setRoles(utilisateurDto.getRoles());
		utilisateur.setPassword(passwordEncoder.encode(utilisateurDto.getPassword()));
		
		 utilisateur.setEnabled(true);
		 utilisateur.setNonExpired(true);
		 utilisateur.setNonLocked(true);
		
		UtilisateurEntity utilisateurSave = utilisateurRepository.save(utilisateur);
		dtoUsers = Mapper.toUtilisateurDto(utilisateurSave);
		dtoUsers.setCode(200);
		dtoUsers.setStatut("Succes");
		dtoUsers.setTitre("Save");
		dtoUsers.setDescription("Utilisateur crée avec succès !");
		return dtoUsers;
		 }
	}
	
	@Override
	public UtilisateurDto updateUtilisateur(UtilisateurDto utilisateurDto, String uuid) {
		// TODO Auto-generated method stub
		UtilisateurEntity utilisateur = new UtilisateurEntity();
		
		 utilisateur = utilisateurRepository.findById(uuid).orElseThrow(null);
		
		utilisateur.setUuid(utilisateurDto.getUuid());
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setPhone(utilisateurDto.getPhone());
		utilisateur.setRoles(utilisateurDto.getRoles());
		utilisateur.setPassword(passwordEncoder.encode(utilisateurDto.getPassword()));
		 utilisateur.setEnabled(utilisateurDto.isEnabled());
		 utilisateur.setNonExpired(utilisateurDto.isNonExpired());
		 utilisateur.setNonLocked(utilisateurDto.isNonLocked());
		 
		 UtilisateurEntity utlilisateurUpdate= utilisateurRepository.save(utilisateur);
		 UtilisateurDto dtoUsers = new UtilisateurDto();
		dtoUsers = Mapper.toUtilisateurDto(utlilisateurUpdate);
		if(!dtoUsers.equals(null)) {
			dtoUsers.setCode(200);
			dtoUsers.setStatut("Succes");
			dtoUsers.setTitre("Update");
			dtoUsers.setDescription("Update User effectué avec succès !");
		return dtoUsers;
		}else {
			throw new ResourceAlreadyExistException(String.format("Update user  failled !"));
		}
	}
	
	

	@Override
	public void deleteUtilisateur(String uuid) {
		// TODO Auto-generated method stub
		utilisateurRepository.deleteById(uuid);

	}

	@Override
	public List<UtilisateurDto> findAll() {
		// TODO Auto-generated method stub
		List<UtilisateurEntity> users = utilisateurRepository.findAll();
		List<UtilisateurDto> utilisateurDtos = new ArrayList<UtilisateurDto>();
		users.forEach(user -> utilisateurDtos.add(Mapper.toUtilisateurDto(user)));
		return utilisateurDtos;
	}

	@Override
	public UtilisateurDto getUtilisateur(String uuid) {
		// TODO Auto-generated method stub
		UtilisateurEntity utilisateur = utilisateurRepository.findById(uuid).orElseThrow(null);
		return Mapper.toUtilisateurDto(utilisateur);
	}

	@Override
	public UtilisateurDto getUtilisateurByEmail(String email) {
		Optional<UtilisateurEntity> optionalUtilisateur = utilisateurRepository.findByEmail(email);
		UtilisateurEntity utilisateur = optionalUtilisateur.orElseThrow(null);
		return Mapper.toUtilisateurDto(utilisateur);
	}

	public void deconnecterUtilisateur() {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UtilisateurEntity utilisateur = utilisateurRepository.findByEmail(auth.getName()).orElseThrow(null);
		utilisateur.setOnline(false);
		utilisateurRepository.save(utilisateur);
		
	}
	
	@Override
	public UtilisateurDto getPassword(String usernameOrPhoneNumber,String newPassowd) {
		// TODO Auto-generated method stub
		Optional<UtilisateurEntity> utilisateur = utilisateurRepository.findByEmail(usernameOrPhoneNumber);
		UtilisateurEntity utilisateurSave = new UtilisateurEntity();
		if(utilisateur.isPresent()) {
			utilisateur.get().setPassword(passwordEncoder.encode(newPassowd));
			utilisateurSave = 	utilisateurRepository.save(utilisateur.get());
		}
		return Mapper.toUtilisateurDto(utilisateurSave);
	}

	@Override
	public List<UtilisateurDto> getByUserOnLigne() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
