package com.netcracker.spring.service.queries;

import com.netcracker.spring.dao.queries.QueryDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("queryService")
public class QueryService implements QueryServiceInterface {

    @Autowired
    private QueryDAOInterface queryDAOInterface;

    public void query2a() {
        queryDAOInterface.query2a();
    }

    public void query2b() {
        queryDAOInterface.query2b();
    }

    public void query2c() {
        queryDAOInterface.query2c();
    }

    public void query3a(String cusInhabit) {
        queryDAOInterface.query3a(cusInhabit);
    }

    public void query3b() {
        queryDAOInterface.query3b();
    }

    public void query3c() {
        queryDAOInterface.query3c();
    }

    public void query4a() {
        queryDAOInterface.query4a();
    }

    public void query4b() {
        queryDAOInterface.query4b();
    }

    public void query5a() {
        queryDAOInterface.query5a();
    }

    public void query5b() {
        queryDAOInterface.query5b();
    }

    public void query5c() {
        queryDAOInterface.query5c();
    }

    public void query5d() {
        queryDAOInterface.query5d();
    }

    public void closeSessionFactory() {
        queryDAOInterface.closeSessionFactory();
    }

}