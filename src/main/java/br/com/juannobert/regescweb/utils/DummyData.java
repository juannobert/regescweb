package br.com.juannobert.regescweb.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.juannobert.regescweb.domain.Professor;
import br.com.juannobert.regescweb.domain.enums.StatusProfessor;
import br.com.juannobert.regescweb.repositories.ProfessorRepository;

@Component
@Profile("dev")
public class DummyData {
		
	@Autowired
	ProfessorRepository repository;
	@PostConstruct
	public void save() {
		Professor p1 = new Professor("Batman",2000,StatusProfessor.ATIVO);
		Professor p2 = new Professor("Super Man",5000,StatusProfessor.APOSENTADO);
		
		repository.saveAll(Arrays.asList(p1,p2));
	}
}
