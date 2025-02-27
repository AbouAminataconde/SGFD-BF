package com.org.sfors.serviceImp;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.sfors.dto.FormateurDto;
import com.org.sfors.entity.FormateurEntity;
import com.org.sfors.exception.ResourceAlreadyExistException;
import com.org.sfors.mapper.Mapper;
import com.org.sfors.repository.FormateurRepository;
import com.org.sfors.service.FormateursServices;

@Service
public class FormateursServiceImpl implements FormateursServices {
	
	@Autowired
	private FormateurRepository repositoryFormateur;

	@Override
	public FormateurDto addFormateur(FormateurDto formateurdto) {
		// TODO Auto-generated method stub
		 FormateurEntity formateur = new FormateurEntity();
		 
		 FormateurDto dtoFormateur = new FormateurDto();
		 if(dtoFormateur.equals(null)) {
			 throw new ResourceAlreadyExistException(String.format("Ajout Affectation echoué"));
			}else {
				formateur.setUuid(formateurdto.getUuid());
				formateur.setNom(formateurdto.getNom());
				formateur.setPrenoms(formateurdto.getPrenoms());
				formateur.setSexe(formateurdto.getSexe());
				formateur.setPhone(formateurdto.getPhone());
				formateur.setEmail(formateurdto.getEmail());
				formateur.setAdress(formateurdto.getAdress());
				formateur.setProfession(formateurdto.getProfession());
				FormateurEntity formateurSave = repositoryFormateur.save(formateur);
				dtoFormateur = Mapper.toFormateurDto(formateurSave);
				dtoFormateur.setCode(200);
				dtoFormateur.setStatut("Succes");
				dtoFormateur.setTitre("Save");
				dtoFormateur.setDescription("Ajout Formateur effectué avec succès !");
				
		return dtoFormateur;
	}

}

	@Override
	public FormateurDto updatFormateur(FormateurDto formateurdto, String uuid) {
		// TODO Auto-generated method stub
		
		FormateurEntity formateur = new FormateurEntity();
		
		formateur = repositoryFormateur.findById(uuid).orElseThrow();
		
		formateur.setUuid(formateurdto.getUuid());
		formateur.setNom(formateurdto.getNom());
		formateur.setPrenoms(formateurdto.getPrenoms());
		formateur.setSexe(formateurdto.getSexe());
		formateur.setPhone(formateurdto.getPhone());
		formateur.setEmail(formateurdto.getEmail());
		formateur.setAdress(formateurdto.getAdress());
		formateur.setProfession(formateur.getProfession());
		
		FormateurEntity updatFormateur = repositoryFormateur.save(formateur);
		
		FormateurDto dtoFormateur = new FormateurDto();
		dtoFormateur = Mapper.toFormateurDto(updatFormateur);
		if(!dtoFormateur.equals(null)) {
			dtoFormateur.setCode(200);
			dtoFormateur.setStatut("Succes");
			dtoFormateur.setTitre("Update");
			dtoFormateur.setDescription("Update Formateur effectué avec succès !");
		return dtoFormateur;
		}else {
			throw new ResourceAlreadyExistException(String.format("Update Formateur echoué !"));
		}
		
	}

	@Override
	public FormateurDto getFormateur(String uuid) {
		// TODO Auto-generated method stub
		FormateurEntity formateurs = new FormateurEntity();
		formateurs = repositoryFormateur.findById(uuid).orElseThrow();
		return Mapper.toFormateurDto(formateurs);
	}

	@Override
	public List<FormateurDto> findAll() {
		// TODO Auto-generated method stub
		List<FormateurEntity> lstFormateur = repositoryFormateur.findAll();
		List<FormateurDto> lstdtoFormateur = new ArrayList<FormateurDto>();
		lstFormateur.forEach(formateur -> lstdtoFormateur.add(Mapper.toFormateurDto(formateur)) );
		return lstdtoFormateur;
	}

	@Override
	public FormateurDto getFormateurByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFormateur(String uuid) {
		// TODO Auto-generated method stub
		repositoryFormateur.deleteById(uuid);
	}

	
}
