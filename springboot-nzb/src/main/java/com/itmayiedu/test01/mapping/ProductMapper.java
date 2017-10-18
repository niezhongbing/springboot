package com.itmayiedu.test01.mapping;

import com.itmayiedu.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer prodid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer prodid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}