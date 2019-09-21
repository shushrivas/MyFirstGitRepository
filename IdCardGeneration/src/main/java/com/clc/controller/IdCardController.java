package com.clc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clc.bean.Student;
import com.clc.serviceimpl.StudentIdImpl;

@Controller

public class IdCardController {
	@Autowired
	StudentIdImpl sii;

	@RequestMapping(value = "/reply")
	public String displayHomePage(Model m) {
		// String s = "Inside Hello World Controller";
		Student s = new Student();

		m.addAttribute("studForm", s);
		return "reg";

	}

	/*
	 * @RequestMapping(value = "/saveInfo", method = RequestMethod.POST) public
	 * ModelAndView displayStatus(@ModelAttribute("studForm") Student s) {
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * System.out.println(s);
	 * 
	 * boolean b = sii.saveInfo(s); String msg =
	 * b?"Student Info Save /sucesssfully":"problem in save";
	 * 
	 * map.put("msgg", msg); map.put("studFrom", new Student());
	 * 
	 * 
	 * return new ModelAndView("reg", map);
	 * 
	 * }
	 */

	@RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
	public String displayStatus(@Valid @ModelAttribute("studForm") Student s, BindingResult br, Model m) {
		System.out.println(s);
		if (br.hasErrors()) {
			m.addAttribute("msg", "please insert only 4 char");
			return "reg";
		}

		boolean b = sii.saveInfo(s);
		String msg = b ? "Student Info Save /sucesssfully" : "problem in save";
		m.addAttribute("msgg", msg);
		m.addAttribute("studForm", new Student());

		return "reg";

	}

	@RequestMapping("displayInfo")
	public String displayStudInfo(Model map) {

		List<Student> listOfStudents = sii.getAllStudent();
		map.addAttribute("listOfStudents", listOfStudents);

		return "displyinfo";

	}

	@RequestMapping("edit")
	public String updateStudInfo(Model m, @RequestParam("id") int sid) {

		System.out.println(sid);

		Student student = sii.getUpdateStudent(sid);
		System.out.println("sssname  === " + student);
		m.addAttribute("studForm", student);

		return "reg";

	}

	@RequestMapping("delete")
	public String deleteStudInfo(Model m, @RequestParam("id") int sid) {

		System.out.println(sid);

		Student student = sii.getUpdateStudent(sid);
		sii.removeInfo(student);
		List<Student> listOfStudents = sii.getAllStudent();
		m.addAttribute("listOfStudents", listOfStudents);
		m.addAttribute("studInfo", new Student());
		return "displyinfo";

	}

}
