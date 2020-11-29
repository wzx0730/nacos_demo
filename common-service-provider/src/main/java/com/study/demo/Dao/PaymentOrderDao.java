package com.study.demo.Dao;


import com.study.demo.PaymentOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentOrderDao {

    @Select("select * from tb_orderId where id = #{id}")
    PaymentOrder getPaymentOder(@Param("id") Integer id);

}
