package com.adimyth.StudentCrudExample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

//	CREATE TABLE student1 (
//		    id BIGINT NOT NULL AUTO_INCREMENT,
//		    name VARCHAR(255) DEFAULT NULL,
//		    city VARCHAR(255) DEFAULT NULL,
//		    marks INT DEFAULT 0,
//		    result BOOLEAN DEFAULT 0,
//		    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//		    PRIMARY KEY (id)
//		);


 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Column()
 private String name;
 
 @Column()
 private String city;
 
 @Column()
 private int marks;
 
 @Column()
 private boolean result;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public int getMarks() {
	return marks;
}

public void setMarks(int marks) {
	this.marks = marks;
}

public boolean isResult() {
	return result;
}

public void setResult(boolean result) {
	this.result = result;
}

public Student(Long id, String name, String city, int marks, boolean result) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.marks = marks;
	this.result = result;
}


public Student() 
{
	}


@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", city=" + city + ", marks=" + marks + ", result=" + result + "]";
} // it is complotly optional
	
	
	
}
