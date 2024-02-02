package com.spring.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.school.entities.SchoolEntity;
import com.spring.school.repositories.SchoolRepository;

@Service
public class SchoolServices {

	@Autowired
	private SchoolRepository repository;
	
	public List<SchoolEntity> findAll() {
		return repository.findAll();
	}
	
	public SchoolEntity findById(Long id) {
		Optional<SchoolEntity> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public SchoolEntity insert(SchoolEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public SchoolEntity update(Long id, SchoolEntity obj) {
		SchoolEntity newObj = repository.getReferenceById(id);
		updateData(obj, newObj);
		return repository.save(newObj);
	}

	private void updateData(SchoolEntity obj, SchoolEntity newObj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setAddress(obj.getAddress());
		newObj.setDirector(obj.getDirector());
		newObj.setTel(obj.getTel());
	}
	
}
