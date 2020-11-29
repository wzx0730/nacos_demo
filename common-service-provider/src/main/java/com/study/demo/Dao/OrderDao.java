package com.study.demo.Dao;

import com.study.demo.OrderDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderDao {

    @Select("select * from tb_tr_order where orderId = #{orderId}")
    OrderDo selectById(@Param("orderId") Integer orderId);
}
