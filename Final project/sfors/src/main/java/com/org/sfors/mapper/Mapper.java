package com.org.sfors.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.org.sfors.dto.AffectationDto;
import com.org.sfors.dto.FormateurDto;
import com.org.sfors.dto.FormationDto;
import com.org.sfors.dto.InscriptionDto;
import com.org.sfors.dto.PublicationDto;
import com.org.sfors.dto.UtilisateurDto;
import com.org.sfors.entity.AffectationEntity;
import com.org.sfors.entity.FormateurEntity;
import com.org.sfors.entity.FormationEntity;
import com.org.sfors.entity.InscriptionEntity;
import com.org.sfors.entity.PublicationEntity;
import com.org.sfors.entity.UtilisateurEntity;
import com.org.sfors.enums.EnumRole;

public class Mapper {
	
	/**
	 * Mapper
	 * @param Code declarant
	 * @return
	 
	public static DeclarantCodeDto toDeclarantCodeDto(DeclarantCode declarantCode) {
		
		DeclarantCodeDto dtodeclarantCode = new DeclarantCodeDto();
		
		dtodeclarantCode.setCodeDeclarant(declarantCode.getCodeDeclarant());
		dtodeclarantCode.setUuid(declarantCode.getUuid());
		
		return dtodeclarantCode;
	}*/
	
	
	/**
	 * Mapper
	 * @param formateur
	 * @return
	 */
	
	public static FormateurDto toFormateurDto(FormateurEntity formateur) {
		FormateurDto dtoFormateur = new FormateurDto();
		
		dtoFormateur.setUuid(formateur.getUuid());
		dtoFormateur.setNom(formateur.getNom());
		dtoFormateur.setPrenoms(formateur.getPrenoms());
		dtoFormateur.setPhone(formateur.getPhone());
		dtoFormateur.setSexe(formateur.getSexe());
		dtoFormateur.setEmail(formateur.getEmail());
		dtoFormateur.setProfession(formateur.getProfession());
		dtoFormateur.setAdress(formateur.getAdress());
		
		return dtoFormateur;
	}
	
	/**
	 * Mapper
	 * @param Affectation
	 * @return
	 */
	
	public static AffectationDto toAffectationDto(AffectationEntity affectation) {
		AffectationDto dtoaffectation = new AffectationDto();
		
		dtoaffectation.setUuid(affectation.getUuid());
		dtoaffectation.setDateAffectation(affectation.getDateAffectation());
		
		dtoaffectation.setUuidFormateur(affectation.getFormateur().getUuid());
		dtoaffectation.setNomFormateur(affectation.getFormateur().getNom());
		dtoaffectation.setPrenomFormateur(affectation.getFormateur().getPrenoms());
		
		dtoaffectation.setUuidFormation(affectation.getFormation().getUuid());
		dtoaffectation.setLibelleFormation(affectation.getFormation().getLibelleFormation());
		dtoaffectation.setDescriptionFormation(affectation.getFormation().getDescriptionFormation());
		
		
		return dtoaffectation;
	}
	
	/**
	 * Mapper
	 * @param formation
	 * @return
	 */
	
	public static FormationDto toFormationDto(FormationEntity formation) {
		
		FormationDto dtoFormation = new FormationDto();
		
		dtoFormation.setUuid(formation.getUuid());
		dtoFormation.setLibelleFormation(formation.getLibelleFormation());
		dtoFormation.setDescriptionFormation(formation.getDescriptionFormation());
		return dtoFormation;
	}
	
	
	/**
	 * Mapper
	 * @param Publication
	 * @return
	 */
	
	public static PublicationDto toPublicationDto(PublicationEntity publication) {
		PublicationDto dtopublicationDto = new PublicationDto();
		
		dtopublicationDto.setUuid(publication.getUuid());
		dtopublicationDto.setDatePub(publication.getDatePub());
		dtopublicationDto.setDateDebut(publication.getDateDebut());
		dtopublicationDto.setDateFin(publication.getDateFin());
		
		dtopublicationDto.setUuidFormation(publication.getFormation().getUuid());
		
		dtopublicationDto.setLibelleFormation(publication.getFormation().getLibelleFormation());
		dtopublicationDto.setDescriptionFormation(publication.getFormation().getDescriptionFormation());
		
		return dtopublicationDto;
	}
	
	
	/**
	 * Mapper
	 * @param inscription
	 * @return
	*/
	
	public static InscriptionDto toInscriptionDto(InscriptionEntity inscription) {
		InscriptionDto dtoInscription = new InscriptionDto();
		
		dtoInscription.setUuid(inscription.getUuid());
		//info entreprise
		dtoInscription.setEntrepriseName(inscription.getEntrepriseName());
		dtoInscription.setCodeNif(inscription.getCodeNif());
		dtoInscription.setCodeRccm(inscription.getCodeRccm());
		dtoInscription.setCodeDeclarant(inscription.getCodeDeclarant());
		dtoInscription.setEmail(inscription.getEmail());
		//info participant
		dtoInscription.setNom(inscription.getNom());
		dtoInscription.setPrenoms(inscription.getPrenoms());
		dtoInscription.setSexe(inscription.getSexe());
		dtoInscription.setTelephone(inscription.getTelephone());
		dtoInscription.setAdress(inscription.getAdress());
		dtoInscription.setDateInscription(inscription.getDateInscription());
		dtoInscription.setStatus(inscription.getStatus());
		
		dtoInscription.setUuidPublication(inscription.getPublication().getUuid());
		dtoInscription.setDatePublication(inscription.getPublication().getDatePub());
		dtoInscription.setDateDebut(inscription.getPublication().getDateDebut());
		dtoInscription.setDateFin(inscription.getPublication().getDateFin());
		
		dtoInscription.setLebelleFormation(inscription.getPublication().getFormation().getLibelleFormation());
		dtoInscription.setDescriptionFormation(inscription.getPublication().getFormation().getDescriptionFormation());
		
		return dtoInscription;
	}
 
	/**
	 * Mapper
	 * @param utilisateur
	 * @return
	 */
	
	public static UtilisateurDto toUtilisateurDto(UtilisateurEntity utilisateur) {
		UtilisateurDto dtoutilisateur = new UtilisateurDto();
		
		dtoutilisateur.setUuid(utilisateur.getUuid());
		dtoutilisateur.setEmail(utilisateur.getEmail());
		dtoutilisateur.setPhone(utilisateur.getPhone());
		dtoutilisateur.setRoles(utilisateur.getRoles());
		//dto.setPassword(utilisateur.getPassword());
		
		dtoutilisateur.setOnline(utilisateur.isOnline());
		dtoutilisateur.setEnabled(utilisateur.isEnabled());
		dtoutilisateur.setNonExpired(utilisateur.isNonExpired());
		dtoutilisateur.setNonLocked(utilisateur.isNonLocked());
		
		return dtoutilisateur;

	}
	
	/**
	 * Mapper
	 * @param user
	 * @return
	 */
	public static UserDetails toUserDetails(UtilisateurEntity user) {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (Iterator iterator = user.getRoles().iterator(); iterator.hasNext();) {
			EnumRole enumRole = (EnumRole) iterator.next();
			authorities.add(new SimpleGrantedAuthority(enumRole.name()));
		}
		UserDetails userdetails = new User(user.getEmail(), user.getPassword(), authorities);

		return userdetails;
	}

}
