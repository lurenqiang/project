package com.lurenqiang.sore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: lurenqiang
 * @Date: 2019/11/8
 * @Description:
 */
@Controller
public class soreController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
