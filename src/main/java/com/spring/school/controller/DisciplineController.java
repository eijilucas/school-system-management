package com.spring.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.school.entities.DisciplineEntity;
import com.spring.school.services.DisciplineServices;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {

	@Autowired
	private DisciplineServices services;
	
	@GetMapping("/fullsearch")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<List<DisciplineEntity>> findAll() {
		List<DisciplineEntity> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/findById/{id}")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<DisciplineEntity> findById(@PathVariable Long id) {
		DisciplineEntity obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/save")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<DisciplineEntity> insert(@RequestBody DisciplineEntity obj) {
		services.insert(obj);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<DisciplineEntity> update(@PathVariable Long id, @RequestBody DisciplineEntity obj) {
		services.update(id, obj);
		return ResponseEntity.ok().build();
	}
}
