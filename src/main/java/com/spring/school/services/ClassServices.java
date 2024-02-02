package com.spring.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.school.entities.ClassEntity;
import com.spring.school.repositories.ClassRepository;

@Service
public class ClassServices {

	@Autowired
	private ClassRepository repository;
	
	public List<ClassEntity> findAll() {
		return repository.findAll();
	}
	
	public ClassEntity findById(Long id) {
		Optional<ClassEntity> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public ClassEntity insert(ClassEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public ClassEntity update(Long id, ClassEntity obj) {
		ClassEntity newObj = repository.getReferenceById(id);
		updateData(obj, newObj);
		return repository.save(newObj);
	}

	private void updateData(ClassEntity obj, ClassEntity newObj) {
		newObj.setName(obj.getName());
		newObj.setAcademicYear(obj.getAcademicYear());
	}
	
}
