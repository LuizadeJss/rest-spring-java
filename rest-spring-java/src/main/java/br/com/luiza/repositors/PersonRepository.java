package br.com.luiza.repositors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luiza.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	//torna possivel executar as operações básicas de um CRUD apenas extendendo o JpaRepository
}
