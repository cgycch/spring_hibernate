package com.cch.services;

import com.cch.entities.Book;

public interface BookService {
    String findBookById(int id);
    void saveBook(Book book);
    void saveBook2(Book book);
    void saveBook3(Book book);
}
