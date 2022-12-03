package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String student){
       return studentRepository.findStudentByName(student);
    }
    public Teacher getTeacherByName(String teacher){
        return studentRepository.findTeacherByName(teacher);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.studentsFromTeacher(teacher);
    }
    public List<String> getAllStudents(){
        return studentRepository.allStudent();
    }
    public void deleteTeacherByName(String teacher){
        studentRepository.deleteStudentTeacher(teacher);
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeacher();
    }
}
