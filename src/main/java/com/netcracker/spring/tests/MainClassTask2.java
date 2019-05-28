package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.service.queries.QueryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClassTask2 {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Task2

        QueryService queryService = (QueryService) context.getBean("queryService");

        System.out.println("\n\n********************************* Testing Queries 2a *********************************");
        /*Создать запрос для вывода всех различных названий и стоимостей книг*/
        queryService.query2a();

        System.out.println("\n\n********************************* Testing Queries 2b *********************************");
        /*Создать запрос для вывода всех различных районов, в которых проживают покупатели*/
        queryService.query2b();

        System.out.println("\n\n********************************* Testing Queries 2c *********************************");
        /*Создать запрос для вывода всех различных месяцев, когда производились покупки*/
        queryService.query2c();

        queryService.closeSessionFactory();

    }

}
