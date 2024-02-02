package com.spring.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.school.entities.StudentEntity;
import com.spring.school.repositories.StudentRepository;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository repository;
	
	public List<StudentEntity> findAll() {
		return repository.findAll();
	}
	
	public StudentEntity findById(Long id) {
		Optional<StudentEntity> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public StudentEntity insert(StudentEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public StudentEntity update(Long id, StudentEntity obj) {
		StudentEntity newObj = repository.getReferenceById(id);
		updateData(obj, newObj);
		return repository.save(newObj);
	}

	private void updateData(StudentEntity obj, StudentEntity newObj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setBirthDate(obj.getBirthDate());
	}
	
}
