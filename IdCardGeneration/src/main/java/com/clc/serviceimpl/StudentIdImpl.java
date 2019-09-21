package com.clc.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clc.bean.Student;
import com.clc.service.StudentIdService;

@Repository
public class StudentIdImpl implements StudentIdService {

	@Autowired
	SessionFactory sfactory;

	public SessionFactory getSfactory() {
		return sfactory;
	}

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	public boolean saveInfo(Student s) {

		Session session = sfactory.openSession();
		Transaction tr = session.beginTransaction();

		try {
			if (s.getStudId() == 0) {
				session.save(s);
				session.flush();
			} else {
				session.update(s);
				session.flush();
			}

			return true;
		} catch (Exception e) {
			session.flush();
			return false;
		} finally {

			tr.commit();
			session.close();

		}

	}

	public List<Student> getAllStudent() {
		Session s = sfactory.openSession();
		Transaction tr = s.beginTransaction();
		List<Student> liststOfStudent = s.createCriteria(Student.class).list();
		return liststOfStudent;
	}

	public Student getUpdateStudent(int id) {
		Session s = sfactory.openSession();

		Student stud = s.get(Student.class, id);

		return stud;
	}

	public boolean removeInfo(Student stud) {
		Session s = sfactory.openSession();
		Transaction tr = s.beginTransaction();
		try {
			s.delete(stud);
			s.flush();

			return true;
		} catch (Exception e) {
			return false;
		} finally {
			tr.commit();
			s.close();
			
		}
	}
}