package com.netcracker.spring.service.book;

import com.netcracker.spring.entity.Book;

import java.util.List;

public interface BookServiceInterface {

    void deleteBookById(int id);

    void updateBook(int id, Book book);

    void addBook(Book book);

    Book findBookById(int id);

    List<Book> findAllBooks();

    int countAllBooks();

    void closeSessionFactory();

    void showAllBooks();

}
