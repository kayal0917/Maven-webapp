package com.chainsys.mavendemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.chainsys.mavendemo.model.Student;

@Repository
public interface StudentDAO {
   public void insertStudents(Student user);
   public List<Student> getAllUsers();
	public void delete(Student user) ;
	public void update(Student user);
//	public List<Student> search(Student user);
    public List<Student> search(String user);

	}


