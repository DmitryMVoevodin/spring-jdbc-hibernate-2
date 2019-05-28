package com.netcracker.spring.dao.queries;

import com.netcracker.spring.dao.BaseDAO;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository("queryDAO")
@Transactional
public class QueryDAO extends BaseDAO implements QueryDAOInterface {

    public void query2a() {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT DISTINCT book_title, book_price FROM books";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("title=" + obj[0] + "; price=" + obj[1]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query2b() {
        List<String> listQuery = null;
        try {
            String sql = "SELECT DISTINCT customer_inhabitation FROM customers";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(String obj : listQuery) {
                System.out.println("region=" + obj);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query2c() {
        List<Double> listQuery = null;
        try {
            String sql = "SELECT DISTINCT EXTRACT(MONTH FROM pur_date) FROM purchases";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Double obj : listQuery) {
                String monthString = "";
                switch ((int) obj.doubleValue()) {
                    case 1: monthString = "Jan(1)"; break;
                    case 2: monthString = "Feb(2)"; break;
                    case 3: monthString = "Mar(3)"; break;
                    case 4: monthString = "Apr(4)"; break;
                    case 5: monthString = "May(5)"; break;
                    case 6: monthString = "Jun(6)"; break;
                    case 7: monthString = "Jul(7)"; break;
                    case 8: monthString = "Aug(8)"; break;
                    case 9: monthString = "Sep(9)"; break;
                    case 10: monthString = "Oct(10)"; break;
                    case 11: monthString = "Nov(11)"; break;
                    case 12: monthString = "Dec(12)"; break;
                }
                System.out.println("month=" + monthString);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query3a(String cusInhabit) {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT customer_secondname, customer_discount FROM customers " +
                    "WHERE customer_inhabitation = '" + cusInhabit + "'";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("name=" + obj[0] + "; discount=" + obj[1]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query3b() {
        List<String> listQuery = null;
        try {
            String sql = "SELECT shop_title FROM shops " +
                    "WHERE shop_inhabitation = 'Sormovskiy' OR shop_inhabitation = 'Sovetskiy'";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(String obj : listQuery) {
                System.out.println("title of shop=" + obj);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query3c() {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT book_title, book_price FROM books " +
                    "WHERE UPPER(book_title) LIKE '%WINDOWS%' OR book_price > 20000 " +
                    "ORDER BY book_title ASC, book_price DESC";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("title=" + obj[0] + "; price=" + obj[1]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query4a() {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT pur_date, customer_secondname, shop_title FROM " +
                    "(SELECT * FROM purchases JOIN customers ON pur_buyer = customer_id) table1 " +
                    "JOIN shops ON pur_seller = shop_id";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("date=" + obj[0] + "; name=" + obj[1] + "; shop=" + obj[2]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query4b() {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT pur_date, customer_secondname, customer_discount, book_title, pur_count " +
                    "FROM (SELECT * FROM purchases JOIN customers ON pur_buyer = customer_id) table1 " +
                    "JOIN books ON pur_book = book_id";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("date=" + obj[0] + "; name=" + obj[1] + "; discount=" + obj[2] +
                        "; title of book=" + obj[3] + "; count=" + obj[4]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query5a() {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT pur_id, pur_date, customer_secondname " +
                    "FROM (SELECT * FROM purchases JOIN customers ON pur_buyer = customer_id) table1 " +
                    "JOIN books ON pur_book = book_id WHERE pur_sum >= 60000";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("id=" + obj[0] + "; date=" + obj[1] + "; name=" + obj[2]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query5b() {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT pur_date, customer_secondname, shop_inhabitation " +
                    "FROM (SELECT * FROM purchases JOIN customers ON pur_buyer = customer_id) table1 " +
                    "JOIN shops ON pur_seller = shop_id " +
                    "WHERE customer_inhabitation = shop_inhabitation AND EXTRACT(MONTH FROM pur_date) >= 3 " +
                    "ORDER BY pur_date";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("date=" + obj[0] + "; name=" + obj[1] + "; address of shop=" + obj[2]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query5c() {
        List<String> listQuery = null;
        try {
            String sql = "SELECT DISTINCT shop_title " +
                    "FROM (SELECT * FROM purchases JOIN customers ON pur_buyer = customer_id " +
                    "WHERE customer_discount BETWEEN 10 AND 15) table1 " +
                    "JOIN shops ON pur_seller = shop_id " +
                    "WHERE shop_inhabitation <> 'Avtozavodskiy'";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(String obj : listQuery) {
                System.out.println("title of shop=" + obj);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void query5d() {
        List<Object[]> listQuery = null;
        try {
            String sql = "SELECT DISTINCT book_title, book_inhabitation, book_count, book_price " +
                    "FROM (SELECT * FROM purchases JOIN books ON pur_book = book_id " +
                    "WHERE book_count > 10) table1 " +
                    "JOIN shops ON pur_seller = shop_id " +
                    "WHERE shop_inhabitation = book_inhabitation " +
                    "ORDER BY book_price ASC;";
            Query query = getSession().createSQLQuery(sql);
            System.out.println(query.getQueryString());
            listQuery = query.list();
            for(Object[] obj : listQuery) {
                System.out.println("title of book=" + obj[0] + "; storage=" + obj[1] + "; count=" + obj[2] + "; price=" + obj[3]);
            }
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
    }

    public void closeSessionFactory() {
        super.closeSessionFactory();
    }

}