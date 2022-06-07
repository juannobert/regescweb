package br.com.juannobert.regescweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.juannobert.regescweb.domain.Professor;

public interface PrefessorRepository extends JpaRepository<Long, Professor> {
	

}
