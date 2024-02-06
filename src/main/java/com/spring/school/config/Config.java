package com.spring.school.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.spring.school.entities.ClassEntity;
import com.spring.school.entities.DepartmentEntity;
import com.spring.school.entities.DisciplineEntity;
import com.spring.school.entities.SchoolEntity;
import com.spring.school.entities.StudentEntity;
import com.spring.school.entities.TeacherEntity;
import com.spring.school.repositories.ClassRepository;
import com.spring.school.repositories.DepartmentRepository;
import com.spring.school.repositories.DisciplineRepository;
import com.spring.school.repositories.SchoolRepository;
import com.spring.school.repositories.StudentRepository;
import com.spring.school.repositories.TeacherRepository;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DisciplineRepository disciplineRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SchoolEntity sc1 = new SchoolEntity(null, "Escola ABC", "Rua XYZ, 123", "1123459876", "escolabc@example.com", "João Silva");
		schoolRepository.saveAll(Arrays.asList(sc1));
		
		DepartmentEntity d1 = new DepartmentEntity(null, "Ciências Naturais", "Departamento responsável pelas disciplinas de Biologia, Física, Química e Matemática");
		DepartmentEntity d2 = new DepartmentEntity(null, "Linguagens e Humanidades", "Departamento responsável pelas disciplinas de Português, Inglês, Geografia, História, entre outras");
		departmentRepository.saveAll(Arrays.asList(d1, d2));
		
		DisciplineEntity di1 = new DisciplineEntity(null, "Matemática", "Estudo do raciocínio lógico e abstrato, que estuda quantidades, espaço e medidas", d1);
		DisciplineEntity di2 = new DisciplineEntity(null, "Física", "Estuda a natureza e seus fenômenos em seus aspectos gerais", d1);
		DisciplineEntity di3 = new DisciplineEntity(null, "Química", "Estudo científico das propriedades e transformações da matéria", d1);
		DisciplineEntity di4 = new DisciplineEntity(null, "Biologia", "Estuda, descreve, preserva e melhora a vida e os organismos vivos", d1);
		DisciplineEntity di5 = new DisciplineEntity(null, "Português", "Estudo da Língua Portuguesa", d2);
		DisciplineEntity di6 = new DisciplineEntity(null, "História", "Estudo que acompanha os acontecimentos do passado", d2);
		DisciplineEntity di7 = new DisciplineEntity(null, "Inglês", "Estudo da Língua Inglesa", d2);
		DisciplineEntity di8 = new DisciplineEntity(null, "Geografia", "Estudo responsável por examinar a superfície do planeta Terra", d2);
		disciplineRepository.saveAll(Arrays.asList(di1, di2, di3, di4, di5, di6, di7, di8));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ClassEntity c1 = new ClassEntity(null, "Turma A", "2023");
		ClassEntity c2 = new ClassEntity(null, "Turma B", "2023");
		ClassEntity c3 = new ClassEntity(null, "Turma C", "2023");
		classRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		StudentEntity s1 = new StudentEntity(null, "Ana Silva", "ana@example.com", sdf.parse("15/03/2005"), c1);
		StudentEntity s2 = new StudentEntity(null, "Pedro Henrico", "pedro@example.com",  sdf.parse("20/05/2006"), c2);
		StudentEntity s3 = new StudentEntity(null, "José Pereira", "jose@example.com", sdf.parse("09/06/2005"),c3);
		studentRepository.saveAll(Arrays.asList(s1, s2, s3));
		
		TeacherEntity t1 = new TeacherEntity(null, "Carlos Augusto", "carlosprof@example.com", di8);
		TeacherEntity t2 = new TeacherEntity(null, "Cíntia Azevedo", "cintiaprof@example.com", di6);
		TeacherEntity t3 = new TeacherEntity(null, "Luiz Gustavo", "luizprof@example.com", di7);
		TeacherEntity t4 = new TeacherEntity(null, "Alex DaVinci", "alexprof@example.com", di2);
		TeacherEntity t5 = new TeacherEntity(null, "João Costa da Silva", "joaoprof@example.com", di3);
		TeacherEntity t6 = new TeacherEntity(null, "Pedro Giantonini", "pedroprof@example.com", di5);
		TeacherEntity t7 = new TeacherEntity(null, "Nélio Cabrine", "nelioprof@example.com", di4);
		TeacherEntity t8 = new TeacherEntity(null, "Jorge Luiz", "jorgeprof@example.com", di1);
		teacherRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8));
	}

}
