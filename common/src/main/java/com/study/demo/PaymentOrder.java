package com.study.demo;


import lombok.Data;


@Data
public class PaymentOrder {
    private Integer id;
    private String product;
    private Double price;

}
