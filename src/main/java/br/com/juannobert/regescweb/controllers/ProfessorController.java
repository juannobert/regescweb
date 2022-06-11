package br.com.juannobert.regescweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.juannobert.regescweb.domain.enums.StatusProfessor;
import br.com.juannobert.regescweb.services.ProfessorServices;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
	@Autowired
	ProfessorServices professorServices;
	
	@GetMapping()
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("professores/index");
		mv.addObject("professores", professorServices.findAll());
		return mv;
	}
	
	@GetMapping("/new")
	public ModelAndView formNewProfessor() {
		ModelAndView mv = new ModelAndView("professores/new");
		mv.addObject("statusProfessor", StatusProfessor.values());
		return mv;
	}
	
	@PostMapping("/professorres")
	public String newProfessor() {
		return "";
	}
	
}
