package br.com.luiza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.luiza.data.vo.v1.PersonVO;
import br.com.luiza.data.vo.v2.PersonVOV2;
import br.com.luiza.services.PersonServices;


//O @RestController contém o @Controller e o @ResponseBody 
@RestController 
@RequestMapping("/api/person/v1")
public class PersonControler {

	@Autowired //O spring faz a instanciacao da classe PersonSercices
	public PersonServices service;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById (@PathVariable(value = "id")Long id)
		throws Exception
	{
		
		return service.findById(id);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll ()
	{
		return service.findAll();
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create (@RequestBody PersonVO person)
	{
		return service.create(person);
	}
	@PostMapping(value = "/v2",produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createV2 (@RequestBody PersonVOV2 person)
	{
		return service.createV2(person);
	}
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update (@RequestBody PersonVO person)
	{
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id")Long id)
		
	{
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}


}
