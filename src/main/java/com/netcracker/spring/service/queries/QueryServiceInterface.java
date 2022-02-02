package com.netcracker.spring.service.queries;

import java.util.List;

public interface QueryServiceInterface {

    /*Создать запрос для вывода всех различных названий и стоимостей книг*/
    void query2a();

    /*Создать запрос для вывода всех различных районов, в которых проживают покупатели*/
    void query2b();

    /*Создать запрос для вывода всех различных месяцев, когда производились покупки*/
    void query2c();

    /*Создать запросы для получения информации о фамилиях и
    размере скидки всех покупателей, проживающих в Нижегородском районе*/
    void query3a(String cusInhabit);

    /*Создать запросы для получения информации о
    названиях магазинов Сормовского или Советского районов*/
    void query3b();

    /*Создать запросы для получения информации о названиях  и стоимости книг,
    в которых встречается слово Windows, или стоящих более 20000 руб.
    Вывод результатов организовать по названию и убыванию цены книг*/
    void query3c();

    /*Для каждой покупки вывести фамилию покупателя и название магазина, где производилась покупка*/
    void query4a();

    /*Для каждой покупки вывести дату, фамилию покупателя, скидку, название и количество купленных книг*/
    void query4b();

    /*Определить номер заказа, фамилию покупателя и дату для покупок, в которых
    было продано книг на сумму не меньшую чем 60000 руб.*/
    void query5a();

    /*Определить покупки, сделанные покупателем в своем районе не ранее марта месяца.
    Вывести фамилию покупателя, район, дату. Произвести сортировку*/
    void query5b();

    /*Определить магазины, расположенные в любом районе, кроме Автозаводского,
    где покупали книги те, у кого скидка от 10% до 15%*/
    void query5c();

    /*Определить данные по покупке книг (название, район складирования, количество),
    приобретенных в районе складирования и содержащихся в запасе более 10 штук.
    Включить данные о стоимости и отсортировать по возрастанию*/
    void query5d();

    void closeSessionFactory();

}