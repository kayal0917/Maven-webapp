package com.chainsys.mavendemo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.chainsys.mavendemo.mapper.StudentMapper;
import com.chainsys.mavendemo.model.Student;
@Repository

public class StudentImpl implements StudentDAO {
	

	    @Autowired
	    JdbcTemplate jdbcTemplate;
	    StudentMapper mapper;
	    
	public void insertStudents(Student user) {
	      String save = "insert into demo(name, grade) values (?,?)";
	        
	        Object[] params = {user.getName(), user.getGrade()};
	        jdbcTemplate.update(save, params);
	        
	}

	@Override
	public List<Student> getAllUsers() 
	{
		String select="select name,grade from demo";
        List<Student> userList=jdbcTemplate.query(select, new StudentMapper());
        return userList;
	}
	public void update(Student user)
    {
        String update = "update demo set name=?, grade=? where name=?";
        Object[] name = {user.getName(), user.getGrade(), user.getName()};
        jdbcTemplate.update(update, name);            
    }
	public void delete(Student user) 
    {
        String delete = "delete from demo where name=?";
        Object[] name = {user.getName()};
        jdbcTemplate.update(delete, name);
        
    }

}


