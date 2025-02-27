package com.org.sfors.serviceImp;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.sfors.dto.PublicationDto;
import com.org.sfors.entity.FormationEntity;
import com.org.sfors.entity.PublicationEntity;
import com.org.sfors.exception.ResourceAlreadyExistException;
import com.org.sfors.mapper.Mapper;
import com.org.sfors.repository.FormationRepository;
import com.org.sfors.repository.PublicationRepository;

import com.org.sfors.service.PublicationServices;

@Service
public class PublicationServiceImpl implements PublicationServices {
	
	@Autowired
	private PublicationRepository repositoryPublication;
	
	@Autowired
	private FormationRepository repositoryFormation;

	@Override
	public PublicationDto addPublication(PublicationDto publicationDto) {
		// TODO Auto-generated method stub
		PublicationEntity Publication = new PublicationEntity();
		 
		FormationEntity formation = repositoryFormation.findById(publicationDto.getUuidFormation()).orElse(null);
	   
		PublicationDto dtoPublication = new PublicationDto();
		 if(dtoPublication.equals(null)) {
			 throw new ResourceAlreadyExistException(String.format("Publication formation echoué !"));
			}else {
				Publication.setUuid(publicationDto.getUuid());
				Publication.setDatePub(publicationDto.getDatePub());
				Publication.setDateDebut(publicationDto.getDateDebut());
				Publication.setDateFin(publicationDto.getDateFin());
				Publication.setFormation(formation);
				
				PublicationEntity PublicationSave = repositoryPublication.save(Publication);
				dtoPublication = Mapper.toPublicationDto(PublicationSave);
				dtoPublication.setCode(200);
				dtoPublication.setStatut("Succes");
				dtoPublication.setTitre("Save");
				dtoPublication.setDescription("Formation publiée avec succès !");
				
		return dtoPublication;
	}
	
}

	@Override
	public PublicationDto updatPublication(PublicationDto publicationDto, String uuid) {
		// TODO Auto-generated method stub
		PublicationEntity Publication = new PublicationEntity();
		
		Publication = repositoryPublication.findById(uuid).orElse(null);
		
		FormationEntity formation = repositoryFormation.findById(publicationDto.getUuidFormation()).orElse(null);
		
		Publication.setUuid(publicationDto.getUuid());
		Publication.setDatePub(publicationDto.getDatePub());
		Publication.setDateDebut(publicationDto.getDateDebut());
		Publication.setDateFin(publicationDto.getDateFin());
		Publication.setFormation(formation);
		
		PublicationEntity updatPublication = repositoryPublication.save(Publication);
		PublicationDto dtoPublication = new PublicationDto();
		dtoPublication = Mapper.toPublicationDto(updatPublication);
		if(!dtoPublication.equals(null)) {
			dtoPublication.setCode(200);
			dtoPublication.setStatut("Succes");
			dtoPublication.setTitre("Update");
			dtoPublication.setDescription("Publication update avec succès !");
		return dtoPublication;
		}else {
			throw new ResourceAlreadyExistException(String.format("Update Publication formation echoué !"));
		}
	}

	@Override
	public PublicationDto getPublication(String uuid) {
		// TODO Auto-generated method stub
		PublicationEntity Publications = new PublicationEntity();
		Publications = repositoryPublication.findById(uuid).orElseThrow();
		return Mapper.toPublicationDto(Publications);
	}

	@Override
	public List<PublicationDto> findAll() {
		// TODO Auto-generated method stub
		List<PublicationEntity> lstPublication = repositoryPublication.findAll();
		List<PublicationDto> lstdtoPublication = new ArrayList<PublicationDto>();
		lstPublication.forEach(Publication -> lstdtoPublication.add(Mapper.toPublicationDto(Publication)) );
		return lstdtoPublication;
	}

	@Override
	public void deletePublication(String uuid) {
		// TODO Auto-generated method stub
		repositoryPublication.deleteById(uuid);
	}

	@Override
	public PublicationDto findByPublication(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
