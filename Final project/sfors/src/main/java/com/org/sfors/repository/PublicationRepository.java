package com.org.sfors.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.sfors.entity.PublicationEntity;

@Repository
public interface PublicationRepository extends JpaRepository< PublicationEntity, String> {
	
}
