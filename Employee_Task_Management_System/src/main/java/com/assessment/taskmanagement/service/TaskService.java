package com.assessment.taskmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.assessment.taskmanagement.dao.EmployeeDAO;
import com.assessment.taskmanagement.dao.TaskDAO;
import com.assessment.taskmanagement.model.Task;

@Service
public class TaskService {
	@Autowired
	private TaskDAO dao;
    @Autowired
    private EmployeeDAO empdao;
	public List<Task> getAllTask() {
		return dao.getAllTask();
	}

	public String addTask(Task task) {
		task.setAssignedEmployee(empdao.getEmployee(task.getAssignedEmployeeId()));
		dao.addTask(task);
		return "redirect:/task";
	}

	public String editTask(Task task) {
		task.setAssignedEmployee(empdao.getEmployee(task.getAssignedEmployeeId()));
		dao.editTask(task);
		return "redirect:/task";
	}

	public String deleteTask(int id) {
		Task task=dao.getTask(id);
		if(task!=null) {
			dao.deleteTask(task);
		}
		return "redirect:/task";
	}

	public void editTask(int id, Model model) {
		Task task=dao.getTask(id);
		if(task!=null) {
		    model.addAttribute("task", task);
		    model.addAttribute("tasks", dao.getAllTask());
		    model.addAttribute("employees",empdao.getAllEmployees());
		}
	}

}
