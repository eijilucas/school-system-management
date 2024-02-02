package com.spring.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.school.entities.TeacherEntity;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{

}
