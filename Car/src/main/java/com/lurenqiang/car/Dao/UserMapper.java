package com.lurenqiang.car.Dao;

import com.lurenqiang.car.Vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectByName(String name);
}
