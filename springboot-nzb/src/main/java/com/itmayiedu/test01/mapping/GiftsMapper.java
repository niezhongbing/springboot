package com.itmayiedu.test01.mapping;

import java.util.List;
import java.util.Map;

import com.itmayiedu.entity.Gifts;

public interface GiftsMapper {
    int insert(Gifts record);

    int insertSelective(Gifts record);
    
    List<Gifts> selectAllGifts(Map<String, Object> map);
}