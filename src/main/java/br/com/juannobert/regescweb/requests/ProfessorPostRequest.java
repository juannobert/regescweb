package br.com.juannobert.regescweb.requests;

import br.com.juannobert.regescweb.domain.enums.StatusProfessor;

public class ProfessorPostRequest {
	
	private String name;

	private Double salary;

	private StatusProfessor statusProfessor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public StatusProfessor getStatusProfessor() {
		return statusProfessor;
	}

	public void setStatusProfessor(StatusProfessor statusProfessor) {
		this.statusProfessor = statusProfessor;
	}
	
	
}
