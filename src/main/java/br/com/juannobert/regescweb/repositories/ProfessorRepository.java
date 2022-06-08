package br.com.juannobert.regescweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.juannobert.regescweb.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	

}
