package com.chainsys.mavendemo.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.chainsys.mavendemo.model.Student;
public class StudentMapper  implements RowMapper<Student> {
	
	
	    @Override
	    public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	    {
	    	Student user=new Student();
	        String name=rs.getString(1);
	        int grade=rs.getInt(2);
	        user.setName(name);
	     user.setGrade(grade);
	        return user;
	    }

	}
