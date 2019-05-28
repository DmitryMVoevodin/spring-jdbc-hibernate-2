package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.service.queries.QueryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClassTask4 {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Task4

        QueryService queryService = (QueryService) context.getBean("queryService");

        System.out.println("\n\n********************************* Testing Queries 4a *********************************");
        /*Для каждой покупки вывести фамилию покупателя и название магазина, где производилась покупка*/
        queryService.query4a();

        System.out.println("\n\n********************************* Testing Queries 4b *********************************");
        /*Для каждой покупки вывести дату, фамилию покупателя, скидку, название и количество купленных книг*/
        queryService.query4b();

        queryService.closeSessionFactory();

    }

}