package com.lurenqiang.car.Service;

import com.lurenqiang.car.Entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {
    List<Car> selectAll();
}
