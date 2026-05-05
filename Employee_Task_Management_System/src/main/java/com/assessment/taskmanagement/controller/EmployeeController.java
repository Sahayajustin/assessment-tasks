package com.assessment.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assessment.taskmanagement.model.Employee;
import com.assessment.taskmanagement.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;  
  
	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	@GetMapping
	public String getEmployeePage(Model model) {
		model.addAttribute("employees", getAllEmployees());
		return "Employee";
	}
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee) {
		return service.addEmployee(employee);
	}
	@PostMapping("edit/save")
	public String editEmployee(@ModelAttribute Employee employee) {
		return service.editEmployee(employee);
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") int id) {
		return service.deleteEmployee(id);
	}
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable(name = "id") int id,Model model) {
		 service.editEmployee(id,model);
		 return "Employee";
	}
}
