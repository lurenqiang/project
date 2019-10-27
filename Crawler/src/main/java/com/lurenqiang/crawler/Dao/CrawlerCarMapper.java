package com.lurenqiang.crawler.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author:lurenqiang
 * @date:2019/9/21
 */
@Mapper
public interface CrawlerCarMapper {
    List<String> selectCarName();
    Map<String,String> selectWebByCarName(String carName);
}
