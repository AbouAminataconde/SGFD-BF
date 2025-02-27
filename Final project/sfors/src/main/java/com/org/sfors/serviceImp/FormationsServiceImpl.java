package com.org.sfors.serviceImp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.sfors.dto.FormationDto;
import com.org.sfors.entity.FormationEntity;
import com.org.sfors.exception.ResourceAlreadyExistException;
import com.org.sfors.mapper.Mapper;
import com.org.sfors.repository.FormationRepository;
import com.org.sfors.service.FormationsServices;

@Service
public class FormationsServiceImpl implements FormationsServices {
	
	@Autowired
	private FormationRepository repositoryFormation;

	@Override
	public FormationDto addFormation(FormationDto formationdto) {
		// TODO Auto-generated method stub
		FormationEntity formation = new FormationEntity();
		
		FormationDto dtoFormation = new FormationDto();
		 if(dtoFormation.equals(null)) {
			 throw new ResourceAlreadyExistException(String.format("Ajout Formation echoué !"));
			}else {
				
				formation.setUuid(formationdto.getUuid());
				formation.setLibelleFormation(formationdto.getLibelleFormation());
				formation.setDescriptionFormation(formationdto.getDescriptionFormation());
				
				FormationEntity formationSave = repositoryFormation.save(formation);
				dtoFormation = Mapper.toFormationDto(formationSave);
				dtoFormation.setCode(200);
				dtoFormation.setStatut("Succes");
				dtoFormation.setTitre("Save");
				dtoFormation.setDescription("Formation ajouté avec succès !");
				
		return dtoFormation;
	}
	
}

	@Override
	public FormationDto updatFormation(FormationDto formationdto, String uuid) {
		// TODO Auto-generated method stub
		FormationEntity formation = new FormationEntity();
		
		formation = repositoryFormation.findById(uuid).orElse(null);

		formation.setUuid(formationdto.getUuid());
		formation.setLibelleFormation(formationdto.getLibelleFormation());
		formation.setDescriptionFormation(formationdto.getDescriptionFormation());
		
		
		FormationEntity updatFormation = repositoryFormation.save(formation);
		
		FormationDto dtoFormation = new FormationDto();
		dtoFormation = Mapper.toFormationDto(updatFormation);
		
		if(!dtoFormation.equals(null)) {
			dtoFormation.setCode(200);
			dtoFormation.setStatut("Succes");
			dtoFormation.setTitre("Update");
			dtoFormation.setDescription("Update Formation effectué avec succès !");
		return dtoFormation;
		}else {
			throw new ResourceAlreadyExistException(String.format("Update Formation echoué !"));
		}
	}

	@Override
	public FormationDto getFormation(String uuid) {
		// TODO Auto-generated method stub
		FormationEntity formations = new FormationEntity();
		formations = repositoryFormation.findById(uuid).orElseThrow();
		return Mapper.toFormationDto(formations);
	}

	@Override
	public List<FormationDto> findAll() {
		// TODO Auto-generated method stub
		List<FormationEntity> lstFormation = repositoryFormation.findAll();
		List<FormationDto> lstdtoFormation = new ArrayList<FormationDto>();
		lstFormation.forEach(formation -> lstdtoFormation.add(Mapper.toFormationDto(formation)) );
		return lstdtoFormation;
	}

	@Override
	public void deleteFormation(String uuid) {
		// TODO Auto-generated method stub
		repositoryFormation.deleteById(uuid);
	}

}
