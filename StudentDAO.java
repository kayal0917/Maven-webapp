package com.chainsys.mavendemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.mavendemo.model.Student;

@Repository
public interface StudentDAO {
   public void insertStudents(Student user);
   public List<Student> getAllUsers();
	public void delete(Student user) ;
	public void update(Student user);
	 
	}


