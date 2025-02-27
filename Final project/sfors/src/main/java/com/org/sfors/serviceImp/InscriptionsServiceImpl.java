package com.org.sfors.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.sfors.dto.InscriptionDto;
import com.org.sfors.entity.InscriptionEntity;
import com.org.sfors.entity.PublicationEntity;
import com.org.sfors.exception.ResourceAlreadyExistException;
import com.org.sfors.mapper.Mapper;
import com.org.sfors.repository.InscriptionRepository;
import com.org.sfors.repository.PublicationRepository;
import com.org.sfors.service.InscriptionsServices;

@Service
public class InscriptionsServiceImpl implements InscriptionsServices {

	@Autowired
	InscriptionRepository repositoryInscription;
	
	@Autowired
	PublicationRepository repositoryPublication;
	
	@Override
	public InscriptionDto addInscription(InscriptionDto inscriptiondto) {
		// TODO Auto-generated method stub
		InscriptionEntity inscription = new InscriptionEntity();
		 
		PublicationEntity publication = repositoryPublication.findById(inscriptiondto.getUuidPublication()).orElse(null);
	   
		InscriptionDto dtoInscription = new InscriptionDto();
		 if(dtoInscription.equals(null)) {
			 throw new ResourceAlreadyExistException(String.format("Inscription echoué !"));
			} else {
				inscription.setUuid(inscriptiondto.getUuid());
				inscription.setEntrepriseName(inscriptiondto.getEntrepriseName());
				inscription.setCodeNif(inscriptiondto.getCodeNif());
				inscription.setCodeRccm(inscriptiondto.getCodeRccm());
				inscription.setCodeDeclarant(inscriptiondto.getCodeDeclarant());
				inscription.setEmail(inscriptiondto.getEmail());
				
				inscription.setNom(inscriptiondto.getNom());
				inscription.setPrenoms(inscriptiondto.getPrenoms());
				inscription.setTelephone(inscriptiondto.getTelephone());
				inscription.setSexe(inscriptiondto.getSexe());
				inscription.setAdress(inscriptiondto.getAdress());
				inscription.setDateInscription(inscriptiondto.getDateInscription());
				inscription.setPublication(publication);
				
				inscription.setStatus("ATTENTE");
				
				InscriptionEntity inscriptionsSave = repositoryInscription.save(inscription);
				dtoInscription = Mapper.toInscriptionDto(inscriptionsSave);
				dtoInscription.setCode(200);
				dtoInscription.setStatut("Succes");
				dtoInscription.setTitre("Save");
				dtoInscription.setDescription("Inscription effectuée avec succès !");
				
		return dtoInscription;
	}
		
}

	@Override
	public InscriptionDto updatInscription(InscriptionDto inscriptiondto, String uuid) {
		// TODO Auto-generated method stub
		InscriptionEntity inscription = new InscriptionEntity();
		
		inscription = repositoryInscription.findById(uuid).orElse(null);
		PublicationEntity publication = repositoryPublication.findById(inscriptiondto.getUuidPublication()).orElse(null);
		InscriptionDto dtoInscription = new InscriptionDto();
		
		inscription.setUuid(inscriptiondto.getUuid());
		
		inscription.setEntrepriseName(inscriptiondto.getEntrepriseName());
		inscription.setCodeNif(inscriptiondto.getCodeNif());
		inscription.setCodeRccm(inscriptiondto.getCodeRccm());
		inscription.setCodeDeclarant(inscriptiondto.getCodeDeclarant());
		inscription.setEmail(inscriptiondto.getEmail());
		
		inscription.setNom(inscriptiondto.getNom());
		inscription.setPrenoms(inscriptiondto.getPrenoms());
		inscription.setTelephone(inscriptiondto.getTelephone());
		inscription.setSexe(inscriptiondto.getSexe());
		inscription.setAdress(inscriptiondto.getAdress());
		inscription.setStatus("VALIDE");
		inscription.setDateInscription(inscriptiondto.getDateInscription());
		
		inscription.setPublication(publication);
		
		InscriptionEntity inscriptionsUpdate = repositoryInscription.save(inscription);
		dtoInscription = Mapper.toInscriptionDto(inscriptionsUpdate);
		if(!dtoInscription.equals(null)){
			dtoInscription.setCode(200);
			dtoInscription.setStatut("Succes");
			dtoInscription.setTitre("Save");
			dtoInscription.setDescription("Inscription Validée avec succès !");
			return dtoInscription;
			}else{
			throw new ResourceAlreadyExistException(String.format("Validation Inscription echoué !"));
		}
	}

	@Override
	public InscriptionDto getInscription(String uuid) {
		// TODO Auto-generated method stub
		InscriptionEntity inscription = new InscriptionEntity();
		inscription = repositoryInscription.findById(uuid).orElseThrow();
		return Mapper.toInscriptionDto(inscription);
	}

	@Override
	public List<InscriptionDto> findAll() {
		// TODO Auto-generated method stub
		List<InscriptionEntity> lstInscriptions = repositoryInscription.findAll();
		List<InscriptionDto> lstdtoInscription = new ArrayList<InscriptionDto>();
		lstInscriptions.forEach(inscription -> lstdtoInscription.add(Mapper.toInscriptionDto(inscription)) );
		return lstdtoInscription;
	}

	@Override
	public InscriptionDto findByInscription(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInscription(String uuid) {
		// TODO Auto-generated method stub
		repositoryInscription.deleteById(uuid);
	}
}
