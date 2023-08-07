package com.example.Inicial_Test.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student updatedStudent, Long id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {
            // Update fields from the updatedPerson object
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setDob(updatedStudent.getDob());
            existingStudent.setAge(updatedStudent.getAge());

            return studentRepository.save(existingStudent);
        }

        return null; // Or throw an exception indicating the person doesn't exist
    }
}
