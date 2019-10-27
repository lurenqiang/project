package com.lurenqiang.car.Entity;

import lombok.Data;


@Data
public class Car {
    private Integer id;
    private String carName;
    private String carBrand;
    private Double price;
    private String carEngineMode; //车的引擎的样式(电动,汽油)

}
