package com.arm.sbproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arm.sbproject.service.IStudentService;

@Controller
public class StudentController {
	private IStudentService service;

	public StudentController(IStudentService service) {
		super();
		this.service = service;
	}

	// Write handler method to handle list of students and return model and view
	@GetMapping("/getAll")
	public String getAll(Model model) {
		model.addAttribute("students", service.getAllStudent());
		return "students";

	}

}
