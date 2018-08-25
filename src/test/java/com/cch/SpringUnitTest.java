package com.cch;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cch.common.MyBean;
import com.cch.common.MyBean2;
import com.cch.entities.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@Transactional(transactionManager = "transactionManager", readOnly = true)
public class SpringUnitTest {

	@BeforeClass
	public static void beforeIoc() {
		System.out.println("BeforeClass()");
		System.out.println("=========print System environment variables begin==============");
		Map<String, String> map = System.getenv();
		System.out.println("JAVA_HOME:"+map.get("JAVA_HOME"));
		System.out.println("MAVEN_HOME:"+System.getenv("MAVEN_HOME"));
		/*for (Iterator<String> itr = map.keySet().iterator(); itr.hasNext();) {
			String key = itr.next();
			System.out.println(key + "=" + map.get(key));
		}*/
		System.out.println("=========print System environment variables end==============");
		System.out.println("");
		
		try {
			Class.forName("com.cch.common.PropManager");
		} catch (ClassNotFoundException e) {
			System.err.println("PropManager init fail. "+e.getMessage());
		}
	}
	
	@Autowired
	private Hello hello;
	
	@Autowired
	private MyBean mybean;
	
	@Resource(name="bean2")
	private MyBean2 mybeantwo;

	@Before
	public void bef() {
		System.out.println("");
		System.out.println("Before()");
	}

	@Test
	public void test() {
		System.out.println("Test() one hello name: " + hello.getName());
	}

	@Test
	public void test2() {
		System.out.println("Test() two mybean pass: " + mybean.getPassword());
		System.out.println("Test() two mybeantwo pass: " + mybeantwo.getPassword());
	}

	@After
	public void aft() {
		System.out.println("After()");
	}

}
