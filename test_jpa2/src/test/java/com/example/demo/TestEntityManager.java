package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Department;
import com.example.demo.service.Service1;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEntityManager {

	@Autowired
	private Service1 service1;

	@Test
	public void insert() {
		Department department = new Department();
		department.setId(1000);
		department.setName("部门6");
		service1.insert1(department);

	}
	
	@Test
	public void insert2() {
		service1.insert2();
	}
	@Test
	public void delete() {
		service1.remove(100);
	}

}
