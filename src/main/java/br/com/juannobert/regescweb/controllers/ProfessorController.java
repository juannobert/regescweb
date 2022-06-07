package br.com.juannobert.regescweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	@GetMapping()
	public String findAll() {
		return "professores/index";
		
	}
	
}
