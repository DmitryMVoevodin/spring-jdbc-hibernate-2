package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.entity.Book;
import com.netcracker.spring.service.book.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClassTask1Book {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Book
        System.out.println("\n\n********************************* Testing Book *********************************");
        BookService bookService = (BookService) context.getBean("bookService");
        System.out.println("\nfindBookById(10):");
        System.out.println(bookService.findBookById(10));
        System.out.println("\nfindBookById(78):");
        System.out.println(bookService.findBookById(78));
        System.out.println("\ncountAllBooks():");
        System.out.println(bookService.countAllBooks());
        System.out.println("\nshowAllBooks():");
        bookService.showAllBooks();
        System.out.println("\ndeleteBookById(55) and showAllBooks():");
        bookService.deleteBookById(55); bookService.showAllBooks();
        System.out.println("\naddBook(...) and showAllBooks():");
        bookService.addBook(new Book("NewBook1", 2200.2, "Avtozavodskiy",10));
        bookService.showAllBooks();
        System.out.println("\nupdateBook(88, ...) and showAllBooks():");
        bookService.updateBook(88, new Book("NewBook2", 100, "Sormovskiy",20));
        bookService.showAllBooks();
        System.out.println("\nupdateBook(21, ...) and showAllBooks():");
        bookService.updateBook(21, new Book("NewBook2", 100, "Sormovskiy",20));
        bookService.showAllBooks();
        System.out.println("\ndeleteBookById(95) and showAllBooks():");
        bookService.deleteBookById(95);
        System.out.println("\ndeleteBookById(21) and showAllBooks():");
        bookService.deleteBookById(21);
        bookService.showAllBooks();
        System.out.println("\ndeleteBookById(10) and showAllBooks():");
        bookService.deleteBookById(10);
        bookService.showAllBooks();

        bookService.closeSessionFactory();

    }

}