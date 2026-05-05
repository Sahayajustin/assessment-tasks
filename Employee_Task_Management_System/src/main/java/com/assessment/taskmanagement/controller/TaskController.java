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

import com.assessment.taskmanagement.dao.EmployeeDAO;
import com.assessment.taskmanagement.model.Task;
import com.assessment.taskmanagement.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService service;  
    @Autowired
    private EmployeeDAO dao;
  
	@GetMapping("/list")
	public List<Task> getAllTask() {
		return service.getAllTask();
	}
	@GetMapping
	public String getTaskePage(Model model) {
		model.addAttribute("employees",dao.getAllEmployees());
		model.addAttribute("tasks", service.getAllTask());
		return "Task";
	}
	@PostMapping("/add")
	public String addTask(@ModelAttribute Task task) {
		return service.addTask(task);
	}
	@PostMapping("edit/save")
	public String editTask(@ModelAttribute Task task) {
		return service.editTask(task);
	}
	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable(name = "id") int id) {
		return service.deleteTask(id);
	}
	@GetMapping("/edit/{id}")
	public String editTask(@PathVariable(name = "id") int id,Model model) {
		 service.editTask(id,model);
		 return "Task";
	}
}
