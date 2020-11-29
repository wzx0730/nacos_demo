package com.study.demo.Dao;

import com.study.demo.AccountDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountDao {
    @Select("select * from tb_account_test where id=#{id}")
    AccountDo getAccount(Integer id);

    @Update("update tb_account_test set remains = #{price} where id = #{id} ")
    Integer updateRemains(@Param("price") Double price,@Param("id") Integer id);
}
