package com.org.sfors.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.sfors.enums.EnumGenre;
import com.org.sfors.enums.EnumRole;

@RestController
@CrossOrigin(origins = "*")
public class EnumController {

	@GetMapping("/genre")
	 public List<EnumGenre> allGenre() {
		 return new ArrayList<EnumGenre>(EnumSet.allOf(EnumGenre.class));
    }
	
	@GetMapping("/role")
	 public List<EnumRole> allRoles() {
		 return new ArrayList<EnumRole>(EnumSet.allOf(EnumRole.class));
   }
	
	@GetMapping("/roleNew")
	public List<EnumRole> allRoleNew() {
		return new ArrayList<EnumRole>(EnumSet.of(EnumRole.ADMIN,EnumRole.INSCRIPTION,EnumRole.FORMATION,EnumRole.TRANSITAIRE));
	}
	
}
