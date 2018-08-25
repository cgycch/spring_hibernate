package com.cch.common;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;

import com.cch.common.utils.PTRFileUtils;


public class PTRFileUtisTest2 {
	
	@Test
	public void deleteDirectory() throws IOException {
		System.out.println("deleteDirectory() is run...");
		PTRFileUtils.deleteDirectory(new File("D:\\temp2"));
	}
	@Test
	public void deleteQuietlyTest() {
		System.out.println("listFilesTest() is run...");
		boolean status = PTRFileUtils.deleteQuietly(new File("D:\\temp2"));
		System.out.println("status: "+status);
	}
	
	@Test
	public void listFilesTest() {
		System.out.println("listFilesTest() is run...");
		//String[] extensions = new String[] {"txt"};
		String[] extensions = null;
		String filePath = this.getClass().getResource("/data/temp").getPath();
		@SuppressWarnings("unchecked")            
		Collection<File> files = PTRFileUtils.listFiles(new File(filePath), extensions, true);
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
	
	@After
	public void after() {
		System.out.println("");
	}
	

}
