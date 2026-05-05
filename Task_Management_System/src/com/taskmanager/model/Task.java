package com.taskmanager.model;

public class Task {
	public int taskId;
	public String taskName;
	public String priority;
	public String status;
	public Task(int taskId, String taskName, String priority) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.status = "PENDING";
	}
//	@Override
//	public String toString() {
//		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", priority=" + priority + ", status=" + status
//				+ "]";
//	}
}
