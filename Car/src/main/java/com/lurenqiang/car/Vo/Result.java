package com.lurenqiang.car.Vo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Result {
    public String loginresult(int code,String msg)
    {
        Map<String ,Object> result = new HashMap<>();
        result.put("CODE",code);
        result.put("MSG",msg);
        return JSONObject.toJSONString(result);
    }
}
