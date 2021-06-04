package com.gridi.studentmanager.service;

import com.gridi.studentmanager.exception.UserNotFoundException;
import com.gridi.studentmanager.model.Student;
import com.gridi.studentmanager.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id).orElseThrow(
                () -> new UserNotFoundException("Student by id " + id+ "was not found"));
    }

    public void deleteStudent (Long id) {
        studentRepository.deleteStudentById(id);
    }
}
