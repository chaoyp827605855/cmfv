package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.Manager;
import com.baizhi.cmfv.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @ClassName ManagerController
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/4 13:54
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/manager/login")
    public String login(String mName , String mPassword ,String checkbox , HttpServletResponse response , HttpSession session , Map<String , Object> map) throws UnsupportedEncodingException {
        Manager man = managerService.queryByName(mName);
        if(man == null) {
            map.put("loginError" , "账号或密码错误，请重新登录...");
            return "login";
        }
        System.out.println(checkbox + "++++++++++++++++++++++++++++");
        //判断登录是否成功
        Manager manager = managerService.queryByIdAndPwd(mName,mPassword,man.getmSalt());
        if(manager != null) {
            if("on".equals(checkbox)){
                Cookie c1 = new Cookie("mName",URLEncoder.encode(mName ,"UTF-8"));
                c1.setMaxAge(60*60*24*7);//设置Cookie生命周期（负数:不创建）、（零：浏览器关闭）、（正数：秒）
                c1.setPath("/");
                //2.添加Cookie到response中
                response.addCookie(c1);
                //3.响应（带着Cookie完成响应）
            }
            session.setAttribute("Manager" , manager );
            return "index";
        }
        map.put("loginError" , "账号或密码错误，请重新登录...");
        return "login";
    }



}