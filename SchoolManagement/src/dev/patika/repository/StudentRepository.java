package dev.patika.repository;

import dev.patika.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findByGender(String gender);
}
