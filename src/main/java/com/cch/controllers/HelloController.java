package com.cch.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cch.entities.Book;
import com.cch.services.BookService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private BookService service;
	
	@RequestMapping("/test")
    public String controllerTest(ModelMap map){
        String runTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        map.addAttribute("date", runTime);
        System.out.println("进入controller里,当前时间："+runTime);
        Book book = new Book(1, "bookName", "isbn", 2, 3);
        service.saveBook(book);
        return "success";
    }
	@RequestMapping("/test2")
	public String controllerTest2(ModelMap map){
		String runTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		map.addAttribute("date", runTime);
		System.out.println("2进入controller里,当前时间："+runTime);
		Book book = new Book(1, "bookName2", "isbn", 2, 3);
		service.saveBook2(book);
		return "error";
	}
	@RequestMapping("/test3")
	public String controllerTest3(ModelMap map){
		String runTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		map.addAttribute("date", runTime);
		System.out.println("3进入controller里,当前时间："+runTime);
		Book book = new Book(1, "bookName3", "isbn", 2, 3);
		service.saveBook3(book);
		return "success";
	}
}
