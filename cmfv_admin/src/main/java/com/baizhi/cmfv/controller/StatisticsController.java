package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StatisticsController
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/9 15:01
 */
@RequestMapping("/statistics")
@Controller
public class StatisticsController {

    @RequestMapping("/getStatistics")
    @ResponseBody
    public String getStatistics() {
//        List<City> list = new ArrayList<City>();
//        list.add(new City("北京",1000));
//        list.add(new City("安徽",232));
//        list.add(new City("新疆",42324));
//        list.add(new City("湖北",23423));
//        list.add(new City("湖南",2342));
//        list.add(new City("广西",234));
//        list.add(new City("内蒙古",234));
//        list.add(new City("台湾",234));

        String str = "[{\"name\":\"北京\",\"value\":1000},{\"name\":\"安徽\",\"value\":232},{\"name\":\"新疆\",\"value\":2123},{\"name\":\"内蒙古\",\"value\":3214}]";

        return str;
    }

}
