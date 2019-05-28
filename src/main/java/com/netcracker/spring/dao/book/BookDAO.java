package com.netcracker.spring.dao.book;

import com.netcracker.spring.dao.BaseDAO;
import com.netcracker.spring.entity.Book;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository("bookDAO")
@Transactional
public class BookDAO extends BaseDAO implements BookDAOInterface {

    public void deleteBookById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM books WHERE book_id = " + id);
        query.executeUpdate();
    }

    public void updateBook(int id, Book book) {
        Book b = null;
        book.setBookId(id);
        try{
            String sql = "SELECT * FROM books WHERE book_id = " + book.getBookId();
            Query query = getSession().createNativeQuery(sql).addEntity(Book.class);
            b = (Book) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        if (b != null) {
            merge(book);
        }
    }

    public void addBook(Book book) {
        persist(book);
    }

    public Book findBookById(int id) {
        Book book = null;
        try{
            String sql = "SELECT * FROM books WHERE book_id = " + id;
            Query query = getSession().createNativeQuery(sql).addEntity(Book.class);
            book = (Book) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return book;
    }

    public List<Book> findAllBooks() {
        List<Book> listBook = null;
        try{
            String sql = "SELECT * FROM books";
            Query query = getSession().createNativeQuery(sql).addEntity(Book.class);
            listBook = query.list();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return listBook;
    }

    public int countAllBooks() {
        List<Book> listBook = findAllBooks();
        if (listBook == null) {
            return 0;
        } else {
            return listBook.size();
        }
    }

    public void closeSessionFactory() {
        super.closeSessionFactory();
    }

}