package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.model.Department;
import com.example.demo.service.Service3;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpringDataJPA {

	@Autowired
	private Service3 service3;

	@Test
	public void findall() {
		Iterable<Department> findAll = service3.findAll();
		System.out.println(findAll);
	}

	@Test
	public void count() {
		long count = service3.count();
		System.out.println(count);
	}
	@Test
	public void updata() {
		service3.updata();
		
	}
}
