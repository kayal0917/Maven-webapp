package com.chainsys.mavendemo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chainsys.mavendemo.dao.StudentImpl;
import com.chainsys.mavendemo.model.Student;

@Controller
public class MyController {
    
    @Autowired
    StudentImpl studentimpl;

    @RequestMapping("/")
    public String home() {
        System.out.println("Home Page");
        return "register.jsp";
    }

    /*
     * @RequestMapping("/save") public String save() {
     * System.out.println("Success Page"); return "success.jsp"; }
     */

    @GetMapping("/register")
    public String saveUser(@RequestParam("name") String name, @RequestParam("grade") Integer grade) {
        Student user = new Student();
        user.setName(name);
        user.setGrade(grade);
        studentimpl.insertStudents(user);
        return "display.jsp";
    }
    @GetMapping("/listofusers")
    public String getAllUser(Model model) {
    	System.out.println("getting datas");
    	List<Student>users=studentimpl.getAllUsers();
    	System.out.println(users);
    	model.addAttribute("users",users);
    	return"listuser.jsp";
    }
    @GetMapping("/update")
    public String update(@RequestParam ("name")String name, @RequestParam ("grade") int grade,Model model)
    {
        Student user = new Student();
        user.setName(name);
        user.setGrade(grade);       
		studentimpl.update(user);       
    	List<Student>users=studentimpl.getAllUsers();
        model.addAttribute("users", users);        
        return "listuser.jsp";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam ("name") String name, Model model)
    {
        Student user = new Student();
        
        user.setName(name);
        
        studentimpl.delete(user);
        
        List<Student> users = studentimpl.getAllUsers();
        model.addAttribute("users", users);
        
        return "listuser.jsp";
    }
}

