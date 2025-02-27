package com.org.sfors.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.sfors.entity.InscriptionEntity;

@Repository
public interface InscriptionRepository extends JpaRepository< InscriptionEntity, String> {
	
}
