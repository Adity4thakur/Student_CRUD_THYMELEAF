package com.adimyth.StudentCrudExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adimyth.StudentCrudExample.entity.Student;

import jakarta.transaction.Transactional;


@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	;

	@Query("update Student s set  s.result = :status where id = :id")  // this is custom querry 
	@Modifying
	void updateResultStatus(long id, boolean status);

//	List<Student> findByNameContainingIgnoreCase(String keyword);

	// we are working on it (searching using name)
	

	

}
