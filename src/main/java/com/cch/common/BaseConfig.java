package com.cch.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseConfig {
	
	@Bean
	public MyBean myBean() {
		String password = PropManager.proMap.get("myBean.password");
		MyBean bean = new MyBean("shun liu", password, "this is @bean test");
		System.out.println("ioc init Bean in myBean(): "+bean);
		return bean;
		
	}
	
	@Bean({"bean1","bean2"})
	public MyBean2 getMyBean() {
		String password = PropManager.proMap.get("myBean.password");
		MyBean2 bean = new MyBean2("shun liu2", password+"bean1", "this is @bean(\"bean1\") test");
		System.out.println("ioc init Bean2 in getMyBean(): "+bean);
		return bean;
		
	}
}
