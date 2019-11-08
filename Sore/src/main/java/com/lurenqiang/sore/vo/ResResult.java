package com.lurenqiang.sore.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: lurenqiang
 * @Date: 2019/11/8
 * @Description: 对返回的对象进行处理
 */
@Data
public class ResResult implements Serializable {
    private String code;
    private String message;
    public ResResult(String code, String message) {
        //super();
        this.code = code;
        this.message = message;
    }
}
