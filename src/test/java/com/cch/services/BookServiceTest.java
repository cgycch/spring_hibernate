package com.cch.services;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:applicationContext.xml"})
@Transactional(transactionManager="transactionManager",readOnly=true)
public class BookServiceTest {
	private static int count =0;
	
	@Autowired
	private BookService service;
	
	@Before
	public void before() {
		System.out.println("================before count: " +count++);
	}
	@After
	public void after() {
		System.out.println("================after count: " +count++);
	}
	
	
	@BeforeClass
	public static void initclass() {
		System.out.println("@BeforeClass() is before ioc contain");
	}
	
	@Test
	@Transactional
	@Rollback(true)// 事务自动回滚，默认是true。可以不写
	public void test() {
		String name = service.findBookById(2);
		System.out.println("test run...");
		Assert.assertNotNull(name);
	}
	@Test
	public void test2() {
		String name = service.findBookById(2);
		System.out.println("test2 run...");
		Assert.assertNotNull(name);
	}
	@Test
	public void test3() {
		String name = service.findBookById(2);
		System.out.println("test3 run...");
		Assert.assertNotNull(name);
	}

}
