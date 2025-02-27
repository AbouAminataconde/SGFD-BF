package com.org.sfors.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.sfors.entity.FormationEntity;

@Repository
public interface FormationRepository extends JpaRepository< FormationEntity, String> {
	//@Query("select a from Adherant a where a.supprimer is false and lower(a.nom) like concat('%', :key,'%') or lower(a.matricule) like concat('%', :key,'%') or lower(a.numeroAdherant) like concat('%', :key,'%') or lower(a.prenom) like concat('%', :key,'%')")
	//List<FormationEntity> findFormation();
}
