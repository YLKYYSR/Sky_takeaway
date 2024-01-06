package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlovarMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DishServiceIml implements DishService {
    @Autowired
    private DishFlovarMapper dishFlavorMapper;
    @Autowired
    private DishMapper dishMapper;

    @Transactional//管理事务，保证原子性
    public void saveWithFlavor(DishDTO dishDTO) {
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        dishMapper.insert(dish);
        Long dishId = dish.getId();
        List<DishFlavor> flavor = dishDTO.getFlavors();
        if(flavor != null && flavor.size()>0){
            flavor.forEach(disFlavor-> disFlavor.setDishId(dishId));
        }//向口味表插入数据
        dishFlavorMapper.InsertBeach(flavor);
    }
}
