package com.taskmanager.linkedlist;

import com.taskmanager.model.Task;

public class TaskSinglyLinkedList {

	Node head;

	public TaskSinglyLinkedList() {
		this.head = null;
	}

	class Node {
		Task task;
		Node next;

		public Node(Task task) {
			this.task = task;
			this.next = null;
		}
	}

	public void addFirst(Task task) {
		Node newNode = new Node(task);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void displayTasks() {
		Node temp = head;
		if (head == null) {
			System.out.println("No tasks available.");
			return;
		}
		System.out.println("Task List");
		while (temp != null) {
			System.out.println(temp.task.taskId + " - " + temp.task.taskName + " - " + temp.task.priority + " - "
					+ temp.task.status);
			temp = temp.next;
		}
	}

	public void addTask(Task task) {
		Node newNode = new Node(task);
		Node temp = head;
		Node prev = null;
		if (head == null) {
			addFirst(task);
		} else {
			while (temp != null) {
			    if(temp.task.taskId==task.taskId) {
			    	System.err.println("TaskId Already Exists: "+task.taskId);
			    	return;
			    }
				prev = temp;
				temp = temp.next;
			}
			prev.next = newNode;
			System.out.println("Task added successfully.");
		}
	}

	public Task searchTask(int taskId) {
		Node temp = head;
		while (temp != null) {
			if (temp.task.taskId == taskId) {
				return temp.task;
			}
			temp = temp.next;
		}
		return null;
	}

	public void deleteTask(int taskId) {

		if (head == null) {
			System.out.println("No tasks available.");
			return;
		}
		if (head.task.taskId == taskId) {
			head = head.next;
			System.out.println("Task Deleted...");
			return;
		} else {
			Node temp = head;
			while (temp.next != null) {
				if (temp.next.task.taskId == taskId) {
					temp.next = temp.next.next;
					System.out.println("Task Deleted Succesfully..");
					return;
				}
				temp = temp.next;
			}
		}
		System.out.println("Task ID not found.");
	}

	public int getTaskCount() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	public void reverseTasks() {
		Node temp = head;
		Node prev = null;
		Node next;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		head = prev;
		System.out.println("reversed.....");
	}

	public synchronized Task getNextPendingTask() {
		Node temp = head;

		while (temp != null) {
			if (temp.task.status.equals("PENDING")) {
				temp.task.status = "IN_PROGRESS";
				return temp.task;
			}
			temp = temp.next;
		}

		return null;
	}
}
