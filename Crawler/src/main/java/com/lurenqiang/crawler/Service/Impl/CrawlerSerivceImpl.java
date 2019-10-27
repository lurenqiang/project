package com.lurenqiang.crawler.Service.Impl;

import com.lurenqiang.crawler.Dao.CrawlerCarMapper;
import com.lurenqiang.crawler.Entity.Car;
import com.lurenqiang.crawler.Service.CrawlerService;
import com.lurenqiang.crawler.Service.Impl.CrawlerCarService.CrawlerCarService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CrawlerSerivceImpl implements CrawlerService {
    private CrawlerCarMapper crawlerCarMapper;
    private CrawlerCarService crawlerCarService;

    public CrawlerSerivceImpl(CrawlerCarMapper crawlerCarMapper,CrawlerCarService crawlerCarService) {
        this.crawlerCarMapper = crawlerCarMapper;
        this.crawlerCarService=crawlerCarService;
    }

    @Override
    public String CrawlerCar(Map map) {
        //先爬取所需要的所有链接
        crawlerCarService.CrawlerCarLinkings(map);
        //对爬取的链接进行页面分析---爬出的数据


        Document document = Jsoup.parse(response);
        Elements elements = document.select("div[class=content]").select("div[class=row]").select("div[class=column grid-16 contentright]").
                select("div[class=row]").select("div[class=column grid-16]").select("div[class=tab tab02 brandtab-cont]").select("div[class=tab-content fn-visible]").select("div[class=tab-content-item current]")
        .select("div[class=list-cont]").select("div[class=list-cont-main]");
        List<Car> carList = new LinkedList<>();
        if(elements!=null&&elements.size()>0){
            for(Element element:elements){
                Car car= new Car();
                car.setCarName(element/*.select("div[class=list-cont]").select("div[class=list-cont-main]")*/.select("div[class=main-title]").select("a").text());
                car.setCarType(element/*.select("div[class=list-cont]").select("div[class=list-cont-main]")*/.select("div[class=main-lever]").select("div[class=main-lever-left]").select("ul[class=lever-ul]").select("li").select("span[class=info-gray]").text());
                car.setCarStructure(element/*.select("div[class=list-cont]").select("div[class=list-cont-main]")*/.select("div[class=main-lever]").select("div[class=main-lever-left]").select("ul[class=lever-ul]").select("li").select("a").text());
                carList.add(car);
            }

        }
        return carList.toString();
    }

    @Override
    public List<String> selectCarName() {
        return crawlerCarMapper.selectCarName();
    }

    @Override
    public Map<String, String> selectWebByCarName(String carName) {
        return crawlerCarMapper.selectWebByCarName(carName);
    }
}
