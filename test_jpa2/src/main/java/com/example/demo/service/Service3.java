package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Department;
import com.example.demo.repository.DepatmentRepository;
import com.example.demo.repository.EmployesRepository;

@Component
public class Service3 {

	@Autowired
	private DepatmentRepository depatmentRepository;
	@Autowired
	private EmployesRepository employesRepository;

	// 接口内置方法查询所有
	public Iterable<Department> findAll() {
		return depatmentRepository.findAll();

	}

	// 查询实体数量
	public long count() {
		return depatmentRepository.count();
	}

	// @Test和@Transactional使用会出现数据无法持久话的问题
	@Transactional
	public void updata() {
		Department department2 = new Department();
		department2.setId(98);
		depatmentRepository.updateById(98, "部门22");
		;

	}
}
