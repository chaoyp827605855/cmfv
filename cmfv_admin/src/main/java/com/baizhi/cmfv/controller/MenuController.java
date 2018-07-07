package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.Menu;
import com.baizhi.cmfv.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName MenuController
 * @Description 分类的功能实现
 * @Author Chao
 * @Date 2018/7/5 11:07
 */
@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/showAll")
    @ResponseBody
    public List<Menu> showAll(){
        return menuService.queryAll();
    }

}
