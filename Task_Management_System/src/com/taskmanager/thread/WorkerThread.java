package com.taskmanager.thread;

import com.taskmanager.linkedlist.TaskSinglyLinkedList;
import com.taskmanager.model.Task;

public class WorkerThread extends Thread {

	private TaskSinglyLinkedList tasks;

	public WorkerThread(TaskSinglyLinkedList tasks, String name) {
		super(name);
		this.tasks = tasks;
	}

	public void run() {

		while (true) {
			Task task = tasks.getNextPendingTask();
			if (task == null) {
				break;
			}
			System.out.println(getName() + " Processing Task ID : " + task.taskId);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			task.status = "COMPLETED";
			System.out.println(getName() + " Completed Task ID :" + task.taskId);
		}
	}

}
