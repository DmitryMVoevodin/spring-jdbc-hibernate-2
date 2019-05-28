package com.netcracker.spring.service.book;

import com.netcracker.spring.dao.book.BookDAOInterface;
import com.netcracker.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService implements BookServiceInterface {

    @Autowired
    private BookDAOInterface bookDAOInterface;

    public void deleteBookById(int id) {
        bookDAOInterface.deleteBookById(id);
    }

    public void updateBook(int id, Book book) {
        bookDAOInterface.updateBook(id, book);
    }

    public void addBook(Book book) {
        bookDAOInterface.addBook(book);
    }

    public Book findBookById(int id) {
        return bookDAOInterface.findBookById(id);
    }

    public List<Book> findAllBooks() {
        return bookDAOInterface.findAllBooks();
    }

    public int countAllBooks() {
        return bookDAOInterface.countAllBooks();
    }

    public void closeSessionFactory() { bookDAOInterface.closeSessionFactory(); }

    public void showAllBooks() {
        List<Book> listBook = findAllBooks();
        if(listBook != null) {
            for(Book bk : listBook) {
                System.out.println(bk);
            }
        }
    }
}