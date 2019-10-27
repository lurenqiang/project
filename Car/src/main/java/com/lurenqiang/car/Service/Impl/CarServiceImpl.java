package com.lurenqiang.car.Service.Impl;

import com.lurenqiang.car.Dao.CarMapper;
import com.lurenqiang.car.Entity.Car;
import com.lurenqiang.car.Service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> selectAll() {
        return carMapper.selectAll();
    }
}
