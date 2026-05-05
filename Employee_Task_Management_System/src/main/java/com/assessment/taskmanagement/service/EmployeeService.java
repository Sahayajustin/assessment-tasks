package com.assessment.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.assessment.taskmanagement.dao.EmployeeDAO;
import com.assessment.taskmanagement.model.Employee;

@Service
public class EmployeeService {
     @Autowired
     private EmployeeDAO dao;
	
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	public String addEmployee(Employee employee) {
			dao.addEmployee(employee);
		return "redirect:/employee";
	}

	public String deleteEmployee(int id) {
		Employee employee=dao.getEmployee(id);
		if(employee!=null) {
		    dao.deleteEmployee(employee);
		}
		return "redirect:/employee";
	}

	public void editEmployee(int id, Model model) {
			Employee employee=dao.getEmployee(id);
			if(employee!=null) {
			    model.addAttribute("employee", employee);
			    model.addAttribute("employees", dao.getAllEmployees());
			}
		}

	public String editEmployee(Employee employee) {
		dao.editEmployee(employee);
		return "redirect:/employee";
	}

}
