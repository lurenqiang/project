package com.lurenqiang.crawler.Service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public interface CrawlerService {
    String CrawlerCar(Map map);
    List<String> selectCarName();
    Map<String,String> selectWebByCarName(String carName);
}
