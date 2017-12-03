package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.demo.model.Department;

@Component
public class Service2 {

	@PersistenceContext
	private EntityManager entityManager;
	// 更新数据
	@Transactional
	public void update(String name) {
		int i = entityManager.createQuery("UPDATE Employe e SET  e.name=?1").setParameter(1, name).executeUpdate();
	}

	// 单表查询所有的对象集合
	public List<Department> findall() {

		TypedQuery<Department> query = entityManager.createQuery("select d from  Department d ", Department.class);
		return query.getResultList();
	}

	// 单表查询符合条件的对象
	public Department find() {

		TypedQuery<Department> query = entityManager
				.createQuery("select d from  Department d where d.id=?1", Department.class).setParameter(1, "11");
		return query.getSingleResult();

	}

	// 多对一查询
	public List<Department> find2() {
		List<Department> list = entityManager.createQuery("select  e.department  from Employe e  ", Department.class)
				.getResultList();
		return list;
	}


}