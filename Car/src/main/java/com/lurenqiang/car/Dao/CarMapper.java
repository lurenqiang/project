package com.lurenqiang.car.Dao;

import com.lurenqiang.car.Entity.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> selectAll();
}
