package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.services.StudentService;

@RestController
@RequestMapping("/stud")
public class StudentController {
   StudentService ss;

   public StudentController(StudentService ss) {
	  super();
	  this.ss = ss;
   } 
   @PostMapping
   public String addStudent(@RequestBody Student s) {
	   String msg=ss.addStudent(s);
	   return msg;
   }
   @GetMapping(value="{kodId}")
   public Student getStudent(@PathVariable("kodId") String kodId) {
       Student s=ss.getStudent(kodId);
       return s;
   }
   @GetMapping
   public List<Student> getAllStudents(){
	   List<Student> slist= ss.getAllStudents();
	   return slist;
   }
   @PutMapping
   public String updateStudent(@RequestBody Student s) {
	   String msg=ss.updateStudent(s);
	   return msg;
   }
   @DeleteMapping(value="{kodId}")
   public String deleteStudent(@PathVariable String kodId) {
	  return ss.deleteStudent(kodId);
   }
}
