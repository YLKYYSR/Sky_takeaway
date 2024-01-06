package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlovarMapper {
    /**
     * 插入口味数据
     * @param flavors
     */
    void InsertBeach(List<DishFlavor> flavors);
}
