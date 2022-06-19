package br.com.juannobert.regescweb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.juannobert.regescweb.domain.Professor;
import br.com.juannobert.regescweb.domain.enums.StatusProfessor;
import br.com.juannobert.regescweb.requests.ProfessorPostRequest;
import br.com.juannobert.regescweb.services.ProfessorServices;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
	@Autowired
	ProfessorServices professorServices;
	
	@GetMapping()
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("professores/index");
		mv.addObject("professores", professorServices.findAll());
		return mv;
	}
	
	@GetMapping("/new")
	public ModelAndView formNovoProfessor() {
		ModelAndView mv = new ModelAndView("professores/new");
		mv.addObject("statusProfessor", StatusProfessor.values());
		return mv;
	}
	
	@PostMapping()
	public ModelAndView novoProfessor(@Valid ProfessorPostRequest professorRequest,BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("/professores/new");
			mv.addObject("statusProfessor",StatusProfessor.values());
		}
		else {
			var professor = new Professor();
			BeanUtils.copyProperties(professorRequest, professor);
			professorServices.save(professor);
			mv.setViewName("redirect:/professores");
		}
		return mv;
	
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		Professor professor = professorServices.findById(id).get();
		professorServices.delete(professor);
		return "redirect:/professores";
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		Optional<Professor> optional = professorServices.findById(id);
		if(optional.isPresent()) {
			ModelAndView mv = new ModelAndView("/professores/show");
			mv.addObject("professor",optional.get());
			return mv;
			
		}
		return new ModelAndView("redirect:/professores");
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView Formeditar(@PathVariable Long id,ProfessorPostRequest professorRequest) {
		Optional<Professor> optional = professorServices.findById(id);
		if(optional.isPresent()) {
			ModelAndView mv = new ModelAndView("/professores/edit");
			Professor professor = optional.get();
			BeanUtils.copyProperties(professor, professorRequest,"id");
			mv.addObject("statusProfessor",StatusProfessor.values());
			mv.addObject("professorId",professor.getId());
			return mv;
			
		}
		return new ModelAndView("redirect:/professores");
		
	}
	
	@PostMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id,@Valid ProfessorPostRequest professorRequest,BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("/professores/edit");
			mv.addObject("statusProfessor",StatusProfessor.values());
		}
		else {
			Professor professor = professorServices.findById(id).get();;
				BeanUtils.copyProperties(professorRequest, professor,"id");
				professorServices.save(professor);
				mv.setViewName("redirect:/professores/"+professor.getId());
			}
		
		return mv;
		
	}
	
	@ModelAttribute(value = "professorPostRequest")
	public ProfessorPostRequest getRequisicaoNovoProfessor() {
	
	    return new ProfessorPostRequest();
	}
	
}
