package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.service.queries.QueryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClassTask5 {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Task5

        QueryService queryService = (QueryService) context.getBean("queryService");

        System.out.println("\n\n********************************* Testing Queries 5a *********************************");
        /*Определить номер заказа, фамилию покупателя и дату для покупок, в которых
        было продано книг на сумму не меньшую чем 60000 руб.*/
        queryService.query5a();

        System.out.println("\n\n********************************* Testing Queries 5b *********************************");
        /*Определить покупки, сделанные покупателем в своем районе не ранее марта месяца.
        Вывести фамилию покупателя, район, дату. Произвести сортировку*/
        queryService.query5b();

        System.out.println("\n\n********************************* Testing Queries 5c *********************************");
        /*Определить магазины, расположенные в любом районе, кроме Автозаводского,
        где покупали книги те, у кого скидка от 10% до 15%*/
        queryService.query5c();

        System.out.println("\n\n********************************* Testing Queries 5d *********************************");
        /*Определить данные по покупке книг (название, район складирования, количество),
        приобретенных в районе складирования и содержащихся в запасе более 10 штук.
        Включить данные о стоимости и отсортировать по возрастанию*/
        queryService.query5d();

        queryService.closeSessionFactory();

    }

}
