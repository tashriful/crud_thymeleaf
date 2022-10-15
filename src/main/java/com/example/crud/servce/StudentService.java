package com.example.crud.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public List<Student> getAllStudent()
	{
		List<Student> students = studentRepository.findAll();
		System.out.println(students);
		return students;
	}

}
