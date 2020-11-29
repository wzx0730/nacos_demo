package com.study.demo.controller;

import com.study.demo.AccountDo;
import com.study.demo.Dao.AccountDao;
import com.study.demo.Dao.OrderDao;
import com.study.demo.Dao.PaymentOrderDao;
import com.study.demo.OrderDo;
import com.study.demo.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PaymentOrderDao paymentOrderDao;

    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/provider/hello/{param}")
    public String sayHello(@PathVariable("param") String param) {
        return "hello Nacos " + param;
    }


    @RequestMapping("/order/{id}")
    public OrderDo getOrderById(@PathVariable("id") Integer id) {
        OrderDo orderDo = orderDao.selectById(id);
        return orderDo;
    }

    @RequestMapping("/account/{id}")
    public AccountDo getAccount(@PathVariable("id") Integer id) {
        AccountDo accountDo = accountDao.getAccount(id);
        return accountDo;
    }

    @RequestMapping("/payment/{id}")
    public PaymentOrder getPayment(@PathVariable("id") Integer id) {
        PaymentOrder orderDo = paymentOrderDao.getPaymentOder(id);
        return orderDo;
    }

    @RequestMapping("/account/{id}/{cost}")
    public Boolean updateAccount(@PathVariable("id") Integer id, @PathVariable("cost") Double cost) {
        Integer integer = accountDao.updateRemains(cost, id);
        return integer > 0;
    }

}
