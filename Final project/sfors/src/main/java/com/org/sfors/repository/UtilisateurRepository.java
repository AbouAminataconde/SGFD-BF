package com.org.sfors.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.org.sfors.entity.UtilisateurEntity;

public interface UtilisateurRepository extends CrudRepository<UtilisateurEntity, String> {
	//Optional<Users> findByEmail(String email);
	
	 @Query("select u from UtilisateurEntity u where u.email=:x or u.phone=:x")
	 Optional<UtilisateurEntity> findByEmail(@Param("x") String email);
	 
	 @Query("select u from UtilisateurEntity u")
	 List<UtilisateurEntity> findAll();
}
