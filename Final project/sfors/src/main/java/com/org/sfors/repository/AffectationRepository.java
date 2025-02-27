package com.org.sfors.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.sfors.entity.AffectationEntity;

@Repository
public interface AffectationRepository extends JpaRepository< AffectationEntity, String> {
	
}
