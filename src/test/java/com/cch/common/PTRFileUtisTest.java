package com.cch.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.cch.common.utils.PTRFileUtils;
import com.cch.entities.MyUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(BlockJUnit4ClassRunner.class)
public class PTRFileUtisTest {

	@Test
	public void testMyUser() throws IOException {
		System.out.println("testMyUser() is running");
		String filePath = this.getClass().getResource("/data/user.json").getPath();
		String content = PTRFileUtils.readFileToString(new File(filePath), "utf-8");
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<MyUser> toValueTypeRef = new TypeReference<MyUser>() {};
		JsonNode node = mapper.readTree(content);
		MyUser user = mapper.convertValue(node, toValueTypeRef);
		System.out.println(user);
		System.out.println("testMyUser() is end");
	}
	
	@Test
	public void testUserList() throws IOException {
		System.out.println("testUserList() is running");
		String filePath = this.getClass().getResource("/data/userList.json").getPath();
		String content = PTRFileUtils.readFileToString(new File(filePath), "utf-8");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(content);
		if(node.findValue("status").intValue()==200) {
			TypeReference<List<MyUser>> toValueTypeRef = new TypeReference<List<MyUser>>() {};
			List<MyUser> list = mapper.convertValue(node.findPath("data"), toValueTypeRef);
			System.out.println(list);
		}else {
			System.err.println(node.get("msg").toString());
		}
		System.out.println("testUserList() is end");
	}
}
