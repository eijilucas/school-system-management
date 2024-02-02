package com.spring.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.school.entities.SchoolEntity;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long>{

}
