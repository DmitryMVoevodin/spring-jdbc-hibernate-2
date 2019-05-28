package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.service.queries.QueryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClassTask3 {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Task3

        QueryService queryService = (QueryService) context.getBean("queryService");

        System.out.println("\n\n********************************* Testing Queries 3a *********************************");
        /*Создать запросы для получения информации о фамилиях и
        размере скидки всех покупателей, проживающих в Нижегородском районе*/
        queryService.query3a("Nizegorodskiy");

        System.out.println("\n\n********************************* Testing Queries 3b *********************************");
        /*Создать запросы для получения информации о
        названиях магазинов Сормовского или Советского районов*/
        queryService.query3b();

        System.out.println("\n\n********************************* Testing Queries 3c *********************************");
        /*Создать запросы для получения информации о названиях  и стоимости книг,
        в которых встречается слово Windows, или стоящих более 20000 руб.
        Вывод результатов организовать по названию и убыванию цены книг*/
        queryService.query3c();

        queryService.closeSessionFactory();

    }

}
