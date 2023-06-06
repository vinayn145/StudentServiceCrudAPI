package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{
	StudentRepository srepo;

	public StudentServiceImplementation(StudentRepository srepo) {
		super();
		this.srepo = srepo;
	}

	@Override
	public String addStudent(Student s) {
		srepo.save(s);
		return "Student added successfully!";
	}

	@Override
	public Student getStudent(String kodId) {
		Student st=srepo.findById(kodId).get();
		return st;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student>slist=srepo.findAll();
		return slist;
	}

	@Override
	public String updateStudent(Student s) {
		srepo.save(s);
		return "Student updated successfully!";
	}

	@Override
	public String deleteStudent(String kodId) {
		srepo.deleteById(kodId);
		return "Student deleted successfully!";
	}
	

}
