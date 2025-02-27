package com.org.sfors.serviceImp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.sfors.dto.AffectationDto;
import com.org.sfors.entity.AffectationEntity;
import com.org.sfors.entity.FormateurEntity;
import com.org.sfors.entity.FormationEntity;
import com.org.sfors.exception.ResourceAlreadyExistException;
import com.org.sfors.mapper.Mapper;
import com.org.sfors.repository.AffectationRepository;
import com.org.sfors.repository.FormateurRepository;
import com.org.sfors.repository.FormationRepository;
import com.org.sfors.service.AffectationServices;

@Service
public class AffectationsServiceImpl implements AffectationServices {
	
	@Autowired
	private FormateurRepository formateurRepository;
	
	@Autowired
	private FormationRepository formationRepository;
	
	@Autowired
	private AffectationRepository affectationRepository;
	
	@Override
	public AffectationDto addAffectation(AffectationDto affectationdto) {
		// TODO Auto-generated method stub
		AffectationEntity affectation = new AffectationEntity();
		
		FormateurEntity formateur = formateurRepository.findById(affectationdto.getUuidFormateur()).orElse(null);
		 
		FormationEntity formation = formationRepository.findById(affectationdto.getUuidFormation()).orElse(null);
		
		AffectationDto dtoAffectation = new AffectationDto();
		 if(dtoAffectation.equals(null)) {
			
			 throw new ResourceAlreadyExistException(String.format("Ajout Affectation echoué", dtoAffectation.getStatut()));
			 
			}else {
				affectation.setUuid(affectationdto.getUuid());
				affectation.setDateAffectation(affectationdto.getDateAffectation());
				affectation.setFormateur(formateur);
				affectation.setFormation(formation);
			
				AffectationEntity affectationsaveSave = affectationRepository.save(affectation);
				dtoAffectation = Mapper.toAffectationDto(affectationsaveSave);
				dtoAffectation.setCode(200);
				dtoAffectation.setStatut("Succes");
				dtoAffectation.setTitre("Save");
				dtoAffectation.setDescription("Affectation effectué avec succès !");
				
		return dtoAffectation;
	}

}

	@Override
	public AffectationDto updatAffectation(AffectationDto affectationdto, String uuid) {
		// TODO Auto-generated method stub
		
		AffectationEntity affectation = new AffectationEntity();
		
		affectation = affectationRepository.findById(uuid).orElseThrow();
		FormateurEntity formateur = formateurRepository.findById(affectationdto.getUuidFormateur()).orElse(null);
		FormationEntity formation = formationRepository.findById(affectationdto.getUuidFormation()).orElse(null);
		
		affectation.setUuid(affectationdto.getUuid());
		affectation.setDateAffectation(affectationdto.getDateAffectation());
		affectation.setFormateur(formateur);
		affectation.setFormation(formation);
	
		AffectationDto dtoaffectation = new AffectationDto();
		AffectationEntity updateaffectation = affectationRepository.save(affectation);
		dtoaffectation = Mapper.toAffectationDto(updateaffectation);
		if(dtoaffectation.equals(null)) {
			dtoaffectation.setCode(200);
			dtoaffectation.setStatut("Succes");
			dtoaffectation.setTitre("Update");
			dtoaffectation.setDescription("Update Formateur effectué avec succès !");
		return dtoaffectation;
		}else {
			throw new ResourceAlreadyExistException(String.format("Ajout Affectation echoué", dtoaffectation.getStatut())); 
		}
	}

	@Override
	public AffectationDto getAffectation(String uuid) {
		// TODO Auto-generated method stub
		AffectationEntity affectation = new AffectationEntity();
		affectation = affectationRepository.findById(uuid).orElseThrow();
		return Mapper.toAffectationDto(affectation);
	}

	@Override
	public List<AffectationDto> findAll() {
		// TODO Auto-generated method stub
		List<AffectationEntity> lstAffectation = affectationRepository.findAll();
		List<AffectationDto> lstdtoAffectation = new ArrayList<AffectationDto>();
		lstAffectation.forEach(formateur -> lstdtoAffectation.add(Mapper.toAffectationDto(formateur))); 
		return lstdtoAffectation;
	}


	@Override
	public void deleteAffectation(String uuid) {
		// TODO Auto-generated method stub
		affectationRepository.deleteById(uuid);
	}
	
}
