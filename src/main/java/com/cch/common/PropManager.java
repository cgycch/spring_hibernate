package com.cch.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropManager {

	public static Map<String, String> proMap = new HashMap<>();

	static {
		System.out.println("init PropManager begin....");
		// 读取属性文件init.properties
		Properties prop = new Properties();
		InputStream in = null;
		try {
			//getResourceAsStream 直接将文件装载到内存中
			//InputStream in = PropManager.class.getClassLoader().getResourceAsStream("configs/init.properties");
			String path = PropManager.class.getClassLoader().getResource("configs/init.properties").getPath();
			in = new BufferedInputStream(new FileInputStream(path));
			prop.load(in); // 加载属性列表
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				//System.out.println(key + ":" + prop.getProperty(key));
				proMap.put(key, prop.getProperty(key));
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("init PropManager end....");
		System.out.println("eg myBean.password:"+proMap.get("myBean.password"));
		System.out.println("");
	}

	public String getProperties(String key) {
		return proMap.get(key);
	}

	public void setProperties(String key, String value) {
		proMap.put(key, value);
	}

}
