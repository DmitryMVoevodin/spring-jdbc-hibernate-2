package com.netcracker.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("baseDAO")
public class BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void closeSessionFactory() {
        sessionFactory.close();
    }

    protected void persist(Object object) {
        getSession().persist(object);
    }

    protected void merge(Object object) { getSession().merge(object); }

    protected void delete(Object object) {
        getSession().delete(object);
    }

}