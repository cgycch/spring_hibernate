package com.cch.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cch.CloudRunnerTest;


@RunWith(CloudRunnerTest.class)
public class BookServiceTest2 {
	@Before
	public void bef() {
		System.out.println("bef");
	}
	@Test
	public void test() {
		System.out.println("test");
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@After
	public void aft() {
		System.out.println("afrer");
	}

}
