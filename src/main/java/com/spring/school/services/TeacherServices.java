package com.spring.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.school.entities.TeacherEntity;
import com.spring.school.repositories.TeacherRepository;

@Service
public class TeacherServices {

	@Autowired
	private TeacherRepository repository;
	
	public List<TeacherEntity> findAll() {
		return repository.findAll();
	}
	
	public TeacherEntity findById(Long id) {
		Optional<TeacherEntity> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public TeacherEntity insert(TeacherEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public TeacherEntity update(Long id, TeacherEntity obj) {
		TeacherEntity newObj = repository.getReferenceById(id);
		updateData(obj, newObj);
		return repository.save(newObj);
	}

	private void updateData(TeacherEntity obj, TeacherEntity newObj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
}
