package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.demo.model.Department;
import com.example.demo.model.Employe;

@Component
public class Service1 {

	@PersistenceContext
	private EntityManager entityManager;

	

	// 删除数据
	@Transactional
	public void remove(int id) {

		Department department = entityManager.find(Department.class, id);

		Department department2 = new Department();
		department2.setId(100);
		entityManager.remove(department);

	}

	// 新增数据
	@Transactional
	public void insert1(Department department) {
		entityManager.persist(department);
	}

	@Transactional
	public void insert2() {
		Employe employe = new Employe();
		employe.setId(101);
		employe.setName("黄武");
		employe.setSalary(100);
		Department department = new Department();
		department.setId(99);
		employe.setDepartment(department);
		entityManager.persist(employe);
	}

}
