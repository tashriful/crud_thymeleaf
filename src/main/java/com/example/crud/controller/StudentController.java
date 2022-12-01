package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.crud.model.Student;
import com.example.crud.servce.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping("/add-student")
	public String showAddForm(Student student, Model model) {
		return "add-student";
	}

	@PostMapping("/save")
	public String save(Student student, Model model){
		studentService.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Long id){
		studentService.deleteStudent(id);
		return "redirect:/";
	}

	@GetMapping("showUpdate/{id}")
	public String showUpdateForm(Model model, @PathVariable("id") Long id){
		Optional<Student> student = studentService.getStudentByID(id);
		model.addAttribute("student", student);
		return "edit-form";
	}

	@PostMapping("update/{id}")
	public String update(@PathVariable("id") long id, Student student,
						 BindingResult result, Model model){

		if (result.hasErrors()) {
			student.setId(id);
			return "update-user";
		}

		studentService.saveStudent(student);
		return "redirect:/index";
	}

}
