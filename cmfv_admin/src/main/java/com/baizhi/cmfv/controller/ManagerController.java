package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.Manager;
import com.baizhi.cmfv.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @ClassName ManagerController
 * @Description 管理员的功能实现
 * @Author Chao
 * @Date 2018/7/4 13:54
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String login(String name , String password ,boolean checkbox , HttpServletResponse response , HttpSession session , Map<String , Object> map) throws UnsupportedEncodingException {
        System.out.println("--------checkbox-------"+checkbox);

        //在web环境中安全管理器会自动初始化
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(name,password,checkbox));
            System.out.println(subject.hasRole("root")?"----root-----":"------无-------");
            return "redirect:/main/main.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "redirect:/jsp/login.jsp";
        } catch (IncorrectCredentialsException ice) {
            ice.printStackTrace();
            return "redirect:/jsp/login.jsp";
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            return "redirect:/jsp/login.jsp";
        }

//        Manager man = managerService.queryByName(name);
//        if(man == null) {
//            map.put("loginError" , "账号或密码错误，请重新登录...");
//            return "jsp/login";
//        }
//        //判断登录是否成功
//        Manager manager = managerService.queryByIdAndPwd(name,password,man.getSalt());
//        if(manager != null) {
//            System.out.println("--------checkbox-------"+checkbox);
//            if(checkbox){
//                Cookie c1 = new Cookie("name",URLEncoder.encode(name ,"UTF-8"));
//                c1.setMaxAge(60*60*24*7);//设置Cookie生命周期（负数:不创建）、（零：浏览器关闭）、（正数：秒）
//                c1.setPath("/");
//                //2.添加Cookie到response中
//                response.addCookie(c1);
//                //3.响应（带着Cookie完成响应）
//            }
//            session.setAttribute("Manager" , manager );
//            return "redirect:/main/main.jsp";
//        }
//        map.put("loginError" , "账号或密码错误，请重新登录...");
//        return "jsp/login";
    }


    @RequestMapping("/modify")
    public String modify(Manager manager , HttpSession session , Model model) {
        if(managerService.modify(manager)) {
            Manager man = managerService.queryById(manager.getId());
            session.removeAttribute("Manager");
            session.setAttribute("Manager" , man);
            return "redirect:/main/main.jsp";
        }
        model.addAttribute("updateError" , "修改失败...");
        return "jsp/updateManager";
    }

}
