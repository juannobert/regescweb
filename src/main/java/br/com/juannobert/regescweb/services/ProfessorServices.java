package br.com.juannobert.regescweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.juannobert.regescweb.domain.Professor;
import br.com.juannobert.regescweb.repositories.ProfessorRepository;

@Service
public class ProfessorServices {
	
	@Autowired
	ProfessorRepository repository;
	
	public List<Professor> findAll(){
		return repository.findAll();
	}
}