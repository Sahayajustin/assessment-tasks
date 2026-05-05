package com.assessment.taskmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.assessment.taskmanagement.model.Task;

@Repository
public class TaskDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;

	public TaskDAO() {
		emf = Persistence.createEntityManagerFactory("task");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}

	public List<Task> getAllTask() {
		String query = "SELECT t FROM Task t";
		Query q = em.createQuery(query);
		return q.getResultList();
	}

	public void addTask(Task task) {
		et.begin();
		em.persist(task);
		et.commit();
	}

	public void editTask(Task task) {
		et.begin();
		em.merge(task);
		et.commit();

	}

	public Task getTask(int id) {
		return em.find(Task.class, id);
	}

	public void deleteTask(Task task) {
		et.begin();
		em.remove(task);;
		et.commit();	
	}
}
