package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String,Student> StudentMap;
    private HashMap<String,Teacher> TeacherMap;
    private HashMap<String, List<String>> StudentTeacherPair;
    public StudentRepository(){
        this.StudentMap = new HashMap<>();
        this.TeacherMap = new HashMap<>();
        this.StudentTeacherPair = new HashMap<>();
    }
    public void addStudent(Student student){
        StudentMap.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        TeacherMap.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        if(StudentMap.containsKey(student) && TeacherMap.containsKey(teacher)){
            List<String> studentTeacherPair=new ArrayList<>();
            if(StudentTeacherPair.containsKey(teacher)){
                studentTeacherPair = StudentTeacherPair.get(teacher);
            }
            studentTeacherPair.add(student);
            StudentTeacherPair.put(teacher,studentTeacherPair);
        }
    }
    public Student findStudentByName(String student){
        return StudentMap.get(student);
    }
    public Teacher findTeacherByName(String teacher){
        return TeacherMap.get(teacher);
    }
    public List<String> studentsFromTeacher(String teacher){
        List<String> studentList = new ArrayList<>();
        if(StudentTeacherPair.containsKey(teacher)){
            studentList = StudentTeacherPair.get(teacher);
        }
        return studentList;
    }
    public List<String> allStudent(){
        List<String> listOfStudent = new ArrayList<>();
        for(String student : StudentMap.keySet()){
            listOfStudent.add(student);
        }
        return listOfStudent;
    }
    public void deleteStudentTeacher(String teacher){
        List<String> students = new ArrayList<>();
        if(StudentTeacherPair.containsKey(teacher)){
            students = StudentTeacherPair.get(teacher);
            for(String student : students){
                if(StudentMap.containsKey(student)){
                    StudentMap.remove(student);
                }
            }
            StudentTeacherPair.remove(teacher);
        }
        if(TeacherMap.containsKey(teacher)){
            TeacherMap.remove(teacher);
        }
    }
    public void deleteAllTeacher(){
        List<String> teachersStudent = new ArrayList<>();
        for(String teacher : StudentTeacherPair.keySet()){
            for(String student : StudentTeacherPair.get(teacher)){
                teachersStudent.add(student);
            }
        }
        for(String student : teachersStudent){
            if(StudentMap.containsKey(student)){
                StudentMap.remove(student);
            }
        }
        for(String teacher : TeacherMap.keySet()){
            TeacherMap.remove(teacher);
        }
        for(String studentTeacher : StudentTeacherPair.keySet()){
            StudentTeacherPair.remove(studentTeacher);
        }
    }
}

