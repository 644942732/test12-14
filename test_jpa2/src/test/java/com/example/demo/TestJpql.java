package com.example.demo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Department;
import com.example.demo.service.Service1;
import com.example.demo.service.Service2;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestJpql {
	private Service2 service;
	private static final Logger log = LoggerFactory.getLogger(TestJpa2Application.class);

	// 单表查询所有的对象集合
	@Test
	public void findall() {

		List<Department> list = service.findall();
		System.out.println(list);
	}

	// 单表查询符合条件的对象
	@Test
	public void find() {

		Department department = service.find();
		System.out.println(department);

	}

	// 多对一查询
	@Test
	public void find2() {
		List<Department> list = service.find2();
		System.out.println(list);
	}

	@Test
	@Transactional
	public void update() {
		service.update("wangwu");
	}

}
