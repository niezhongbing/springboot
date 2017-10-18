package com.itmayiedu.test01.mapping;

import com.itmayiedu.entity.Gifts;

public interface GiftsMapper {
    int insert(Gifts record);

    int insertSelective(Gifts record);
}