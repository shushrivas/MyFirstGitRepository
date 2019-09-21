package com.clc.service;

import java.util.List;

import com.clc.bean.Student;

public interface StudentIdService {
public boolean saveInfo(Student s);
public List<Student> getAllStudent();
public Student getUpdateStudent(int id);
public boolean removeInfo(Student stud);

}
