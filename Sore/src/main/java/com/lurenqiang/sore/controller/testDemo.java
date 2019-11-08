package com.lurenqiang.sore.controller;

import com.lurenqiang.sore.vo.HandlerDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: lurenqiang
 * @Date: 2019/11/8
 * @Description:
 */
@RestController
public class testDemo {
    @RequestMapping("test")
    public String test(@Valid @RequestBody HandlerDTO dto){
        return "";
    }
}
