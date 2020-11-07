package com.narval.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MainMenuController {
	@Value("${spring.application.name}")
	String appName;
	
	@RequestMapping(value="/MainMenu", method = RequestMethod.GET)
    public String MainMenu(Model model) {
        model.addAttribute("appName", appName);
        return "MainMenu";
    }	



}