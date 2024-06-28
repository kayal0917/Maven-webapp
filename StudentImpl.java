package com.chainsys.mavendemo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

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
		String select="select name,grade from demo where delete_users=0";
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
        String delete = "update demo set delete_users=1 where name=?";
        Object[] name = {user.getName()};
        jdbcTemplate.update(delete, name);
        
    }
//public List<Student> search(Student user)
//{
//	String search="select name,grade from demo where name=? and delete_users=0";
//    Object[] name = {user.getName()};
//List<Student> userList=jdbcTemplate.query(search,new StudentMapper(),name);
//	return userList;
//	
//}
	@Override
public List<Student> search(String name) 
{
    String search = String.format 
            (
                "SELECT name,grade FROM demo " +
                "WHERE (name LIKE '%%%s%%' OR grade LIKE '%%%s%%') " +
                "AND delete_users=0",
                name, name
            );
            return jdbcTemplate.query(search, new StudentMapper());        
}





}


