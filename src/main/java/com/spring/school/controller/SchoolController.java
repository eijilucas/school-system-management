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

import com.spring.school.entities.SchoolEntity;
import com.spring.school.services.SchoolServices;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolServices services;
	
	@GetMapping("/fullsearch")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<List<SchoolEntity>> findAll() {
		List<SchoolEntity> list = services.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/findById/{id}")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<SchoolEntity> findById(@PathVariable Long id) {
		SchoolEntity obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/save")
	@CrossOrigin(allowedHeaders = "*", origins = "*")
	public ResponseEntity<SchoolEntity> insert(@RequestBody SchoolEntity obj) {
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
	public ResponseEntity<SchoolEntity> update(@PathVariable Long id, @RequestBody SchoolEntity obj) {
		services.update(id, obj);
		return ResponseEntity.ok().build();
	}
}
