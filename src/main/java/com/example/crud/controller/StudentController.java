package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;
import com.example.crud.servce.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Student> student = studentService.getAllStudent();
		System.out.println(student);
		model.addAttribute("student",student);
		return "studentList";
		
	}
	
	@GetMapping("/student")
	public List<Student> getStudent() {
		List<Student> student = studentService.getAllStudent();
		System.out.println(student);
		return student;
		
	}

}
