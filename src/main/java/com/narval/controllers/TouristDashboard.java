package com.narval.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.narval.Models.Usuario;
import com.narval.repository.UserRepository;
import com.narval.repository.VinicolaRepository;

@Controller
public class TouristDashboard {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	VinicolaRepository vinicolaRepository;
	
	@GetMapping("/TouristDashboard")
	public String TouristDashboard() {
		UserDetails userDetails=currentUserDetails();
		int id=userRepository.getIdByEmail(userDetails.getUsername());
		System.out.println(id);
		return "TouristDashboard";
	}
	
	
	public static UserDetails currentUserDetails(){
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    if (authentication != null) {
	        Object principal = authentication.getPrincipal();
	        return principal instanceof UserDetails ? (UserDetails) principal : null;
	    }
	    return null;
	}
}
