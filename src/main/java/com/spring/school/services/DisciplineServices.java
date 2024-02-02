package com.spring.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.school.entities.DisciplineEntity;
import com.spring.school.repositories.DisciplineRepository;

@Service
public class DisciplineServices {

	@Autowired
	private DisciplineRepository repository;
	
	public List<DisciplineEntity> findAll() {
		return repository.findAll();
	}
	
	public DisciplineEntity findById(Long id) {
		Optional<DisciplineEntity> obj = repository.findById(id);
		return obj.orElseThrow();
	}
	
	public DisciplineEntity insert(DisciplineEntity obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public DisciplineEntity update(Long id, DisciplineEntity obj) {
		DisciplineEntity newObj = repository.getReferenceById(id);
		updateData(obj, newObj);
		return repository.save(newObj);
	}

	private void updateData(DisciplineEntity obj, DisciplineEntity newObj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
	}
	
}
