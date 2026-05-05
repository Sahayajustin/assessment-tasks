package com.assessment.taskmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.assessment.taskmanagement.model.Employee;


@Repository
public class EmployeeDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
      public EmployeeDAO() {
		emf=Persistence.createEntityManagerFactory("task");
		em=emf.createEntityManager();
		et=em.getTransaction();
	}
	  public List<Employee> getAllEmployees() {
		String query="SELECT e FROM Employee e";
		Query q=em.createQuery(query);
		return q.getResultList();
		
	  }
	  public void addEmployee(Employee employee) {
		et.begin();
		em.persist(employee);
		et.commit();
	  }
	  public void deleteEmployee(Employee employee) {
		et.begin();
		em.remove(employee);
		et.commit();
		
	  }
	  public Employee getEmployee(int id) {
		  return em.find(Employee.class, id);
	  }
	  public void editEmployee(Employee employee) {
		   et.begin();
		   em.merge(employee);
		   et.commit();
	  }
	  
	  

}
