package com.lurenqiang.car.Controller;



import com.alibaba.fastjson.JSONObject;
import com.lurenqiang.car.Entity.Car;
import com.lurenqiang.car.Service.CarService;
import com.lurenqiang.car.Utils.CarUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@Slf4j
@RequestMapping(value = "car")
    public class CarController {
    private CarService carService;
    private CarUtils carUtils;
    public CarController(CarService carService,CarUtils carUtils) {
        this.carService = carService;
        this.carUtils = carUtils;
    }





    @RequestMapping("/test")
    @ResponseBody
    public List<Car>  selectAll()
    {
        return carService.selectAll();
    }

    @RequestMapping(value = "/testMD5",method = RequestMethod.POST)
    public void testMD5(@RequestBody JSONObject jsonObject){
        String name = jsonObject.getString("name");
        String MD5 = carUtils.MD5Encyption(name);

    }
}
