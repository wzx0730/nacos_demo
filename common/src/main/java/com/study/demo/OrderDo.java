package com.study.demo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDo {
    private Integer id;
    private Integer orderId;
    private Date createTime;
    private Date gmtTime;

}
