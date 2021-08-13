package dev.patika.controller;

import dev.patika.model.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService=new StudentService();

    public Student findById(int studentId){
        return studentService.findById(studentId);
    }

    public List<Student> findAllStudent(){
        return studentService.findAll();
    }

    public void saveStudent(Student student){
        studentService.save(student);
    }

    public void deleteStudent(Student student){
        studentService.delete(student);
    }

    public void updateStudent(Student student){
        studentService.update(student);
    }
}
