package com.lurenqiang.sore.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Auther: lurenqiang
 * @Date: 2019/11/8
 * @Description:
 */
@Data
public class HandlerDTO implements Serializable {
    private String id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    private String type;
    @Email(message = "邮件格式不对")
    private String email;




}
