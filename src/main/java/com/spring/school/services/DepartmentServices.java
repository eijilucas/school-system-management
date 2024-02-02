package com.spring.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.school.entities.DepartmentEntity;
import com.spring.school.repositories.DepartmentRepository;

@Service
public class DepartmentServices {

	@Autowired
	private DepartmentRepository repository;
	
	public List<DepartmentEntity> findAll() {
		return repository.findAll();
	}
	
	public DepartmentEntity findById(Long id) {
		Optional<DepartmentEntity> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public DepartmentEntity insert(DepartmentEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public DepartmentEntity update(Long id, DepartmentEntity obj) {
		DepartmentEntity newObj = repository.getReferenceById(id);
		updateData(obj, newObj);
		return repository.save(newObj);
	}

	private void updateData(DepartmentEntity obj, DepartmentEntity newObj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
	}
	
}
