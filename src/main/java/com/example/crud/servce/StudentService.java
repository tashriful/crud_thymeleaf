package com.example.crud.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public List<Student> getAllStudent()
	{
		List<Student> studentsList = studentRepository.findAll();
		System.out.println(studentsList);
		return studentsList;
	}

	public Student saveStudent(Student student){
		return studentRepository.save(student);
	}

	public void deleteStudent(Long id){
		studentRepository.deleteById(id);

	}

	public Optional<Student> getStudentByID(Long id){
		Optional<Student> student = studentRepository.findById(id);
		if(student == null){
			throw new EntityNotFoundException("Student not found");
		}
		return student;

	}


}
