package com.lurenqiang.crawler.Service.Impl.CrawlerCarService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author:lurenqiang
 * @date:2019/9/22
 */
@Component
public class CrawlerCarService {
    public Map<String,List<String>> CrawlerCarLinkings(Map map){
        Map<String,List<String>> mapList = new LinkedHashMap<>();
        if(!StringUtils.isBlank(String.valueOf(map.get("carWebForSale")))){
            //对在售的辆进车行广度检索所有的合格链接
            CrawlerWeb("carWebForSale",String.valueOf(map.get("carWebForSale")), mapList);
        }

    }

    //对在售的辆进车行广度检索所有的合格链接
    private void CrawlerWeb(String key,String carWeb,Map<String,List<String>> mapList) {
        List<String> stringList =new LinkedList<>();
        stringList.add(carWeb);

    }
}
