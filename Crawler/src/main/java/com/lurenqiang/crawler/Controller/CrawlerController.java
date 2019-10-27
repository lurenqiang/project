package com.lurenqiang.crawler.Controller;

import com.alibaba.fastjson.JSONObject;
import com.lurenqiang.crawler.Service.CrawlerService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
public class CrawlerController {
    private final CrawlerService crawlerService;

    public CrawlerController(CrawlerService crawlerService) {
        this.crawlerService = crawlerService;
    }

    @RequestMapping(value = "search")
    public ModelAndView searchCarName()
    {
        List<String> carList =crawlerService.selectCarName();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("search");
        modelAndView.addObject("carList",carList);
        log.info(String.valueOf(carList));
        log.info(String.valueOf(modelAndView.getModel()));
        log.info(modelAndView.toString());
        return modelAndView;
    }

    @RequestMapping(value = "car_crawler",method = POST)
    public void carCrawler(String carName){
        //String str = jsonObject.getString("carName");
        Map<String,String> map = crawlerService.selectWebByCarName(carName);
            if(map.size()>0){
                log.info("{}拥有的可爬取的网站,可以进行爬取",carName);
               /* for(Map.Entry<String,String> m:map.entrySet()){
                    Connection.Response response = Jsoup.connect(m.getValue()).method(Connection.Method.GET).execute();
                    if(response.statusCode()==200){
                        log.info("ping通");
                        return crawlerService.CrawlerCar(response.body());
                    }
                }*/
               crawlerService.CrawlerCar(map);
            }

    }
}
