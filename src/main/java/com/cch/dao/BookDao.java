package com.cch.dao;

import com.cch.entities.Book;

public interface BookDao {
	 public String findBookById(int id);
	 public void saveBook(Book book);
}
