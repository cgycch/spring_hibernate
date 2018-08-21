package com.cch.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cch.dao.BookDao;
import com.cch.entities.Book;
import com.cch.entities.Hello;
import com.cch.services.BookService;

@Service
public class BookServiceImpl implements BookService{
	
    @Autowired
    private BookDao bookDao;
    
    @SuppressWarnings("unused")
	@Autowired
    private Hello hello;
    
    public String findBookById(int id)
    {
        return bookDao.findBookById(id);
    }
    @Transactional
    public void saveBook(Book book)
    {
        bookDao.saveBook(book);
    }
    public void saveBook2(Book book)
    {
        bookDao.saveBook(book);
        if("".equals("")) {
         	throw new RuntimeException("saveBook2 is not support");
         }
        System.out.println("can not be continue");
    }
    public void saveBook3(Book book)
    {
    	bookDao.saveBook(book);
    	try {
    		if("".equals("")) {
    			throw new RuntimeException("saveBook3 is not support");
    		}
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	System.out.println("can be continue");
    }
}
