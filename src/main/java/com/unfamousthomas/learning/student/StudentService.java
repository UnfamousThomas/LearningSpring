package com.unfamousthomas.learning.student;

import com.unfamousthomas.learning.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findByName(student.getName());
        if(optionalStudent.isPresent()) {
            throw new IllegalStateException("Name exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        studentOptional.ifPresent(studentRepository::delete);
    }

    public void updateStudent(Long studentId, String name, LocalDateTime birth) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isEmpty()) throw new IllegalStateException("Student not found");
        Student student = studentOptional.get();
        if(name != null) student.setName(name);
        if(birth != null) student.setBirth(birth);

        studentRepository.save(student);
    }
}
