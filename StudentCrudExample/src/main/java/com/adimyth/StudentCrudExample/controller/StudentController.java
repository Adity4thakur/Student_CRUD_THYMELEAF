package com.adimyth.StudentCrudExample.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.adimyth.StudentCrudExample.entity.Student;
import com.adimyth.StudentCrudExample.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestParam;

//import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

//@GetMapping("/all")
//public String getAllStudent(Model model) 
//{
//	List<Student> studentList = new ArrayList<>();
//	studentRepository.findAll().forEach(studentList::add);
//	((Object) model).put("studentList" , studentList);
//	return "student";
//	
//	
//	
//}

	@GetMapping("/all")
	public String getAllStudent(Model model) {
		List<Student> studentList = new ArrayList<>();
		studentRepository.findAll().forEach(studentList::add);
		model.addAttribute("studentList", studentList);
		// model.addAttribute("studentList", studentList);
		return "students"; // Assuming "student" is the name of your view or template
	}

	@GetMapping("/new")
	public String getStudentForm(Model model) {

		Student student = new Student();
		student.setResult(false);

		model.addAttribute("student", student);
		model.addAttribute("pageTitle", "create new Student");
		return "student_form";

	}

	@PostMapping("/save")
	public String saveStudent(Student student, Model model, RedirectAttributes rediAttributes) {
		studentRepository.save(student);
		rediAttributes.addFlashAttribute("message", "student details has been saved");

		// redirectAttributes.addFlashAttribute("message","Student details has been
		// saved");

		return "redirect:/students/all";

	}

	@GetMapping("/delete/{id}")
	public String deletestudentById(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {

		studentRepository.deleteById(id);
		return "redirect:/students/all";

	}

	@GetMapping("{id}")
	public String editStudentById(@PathVariable("id") long id, RedirectAttributes redirectAttributes, Model model) {

		Student s = studentRepository.findById(id).get();
		model.addAttribute("student", s);
		model.addAttribute("pageTitle", "Edit Student with id " + id);
		return "student_form";
	}

	@GetMapping("{id}/result/{status}")
	public String updateResultById(@PathVariable ("id") long id, @PathVariable("status") boolean status , Model model , RedirectAttributes redirectAttributes) {

		studentRepository.updateResultStatus(id , status);
		String result = status ? "Pass" : "Fail";
		String message = "Student with Id " +id + "has been updated to results"+result;
		
		redirectAttributes.addFlashAttribute("message", message);
		
//		studentRepository.updateResultStatus(id, status);
//		redirectAttributes.addFlashAttribute("message", redirectAttributes);
		return "redirect:/students/all";
	}

//	@GetMapping("/keyword")
//	public String findStudentByNameContainsKeyword(@Param("keyword")String keyword , Model model ,RedirectAttributes redirectAttributes) 
//	{
//		List<Student> studentList = new ArrayList<>();
//		studentRepository.findByNameContainingIgnorieCase(keyword).forEach(studentList::add);
//		model.addAttribute("stuentList" , studentList);
//		//redirectAttributes.addFlashAttribute("message", message);
//		String message = "student who contains name as "+keyword;
//		redirectAttributes.addFlashAttribute("message", message);
//		//redirectAttributes.addFlashAttribute("message", message);
//		return "students";
//	}
}
