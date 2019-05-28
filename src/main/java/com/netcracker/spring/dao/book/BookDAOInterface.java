package com.netcracker.spring.dao.book;

import com.netcracker.spring.entity.Book;

import java.util.List;

public interface BookDAOInterface {

    void deleteBookById(int id);

    void updateBook(int id, Book book);

    void addBook(Book book);

    Book findBookById(int id);

    List<Book> findAllBooks();

    int countAllBooks();

    void closeSessionFactory();

}
