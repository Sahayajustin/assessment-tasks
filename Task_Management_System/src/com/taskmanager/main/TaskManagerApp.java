package com.taskmanager.main;

import java.util.Scanner;

import com.taskmanager.linkedlist.TaskSinglyLinkedList;
import com.taskmanager.model.Task;
import com.taskmanager.thread.WorkerThread;

public class TaskManagerApp{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TaskSinglyLinkedList list = new TaskSinglyLinkedList();

		while (true) {
			System.out.println("\n1. Add Task");
			System.out.println("2. Delete Task");
			System.out.println("3. Search Task");
			System.out.println("4. Display All Tasks");
			System.out.println("5. Reverse Task List");
			System.out.println("6. Start Task Processing");
			System.out.println("7. Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter Task ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Task Name: ");
				String name = sc.nextLine();

				System.out.print("Enter Priority (HIGH/MEDIUM/LOW): ");
				String priority = sc.nextLine();

				list.addTask(new Task(id, name, priority));
				
				break;

			case 2:
				System.out.print("Enter Task ID to delete: ");
				list.deleteTask(sc.nextInt());
				break;

			case 3:
				System.out.print("Enter Task ID to search: ");
				Task t = list.searchTask(sc.nextInt());
				if (t != null) {
					System.out.println(t.taskId +" - "+ t.taskName +" - "+ t.priority+ " - " + t.status);
				} else {
					System.out.println("Task not found.");
					
				}
				break;

			case 4:
				list.displayTasks();
				break;

			case 5:
				list.reverseTasks();
				break;

			case 6:
				System.out.println("Starting Task Processing..");
				System.out.println();

				WorkerThread t1 = new WorkerThread(list, "Worker-1");
				WorkerThread t2 = new WorkerThread(list, "Worker-2");

				t1.start();
				t2.start();

				try {
					t1.join();
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("All tasks completed.");
				break;
			
			case 7:
				System.out.println("Exiting...");
//				sc.close();
				return;
			
				
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}

//	public static void main(String[] args) {
//		TaskSinglyLinkedList li=new TaskSinglyLinkedList();
//		Task task=new Task(101,"Task-1","HiGH");
//		Task task2=new Task(102,"Task-2","LOW");
//		Task task3=new Task(103,"Task-3","MID");
//		li.add(task);
//		li.add(task2);
//		li.add(task3);
//		Task task4=li.getTask(105);
//		System.out.println(task4);
//		li.display();
////		li.deleteTask(102);
//		System.out.println(li.search(103));
////		li.reverseTasks();
//		li.display();
//		System.out.println(li.getTaskCount());
//		System.out.println(li.getNextPendingTask());
//	}

//}
