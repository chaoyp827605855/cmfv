package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.util.Verification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName VerificationController
 * @Description 验证信息
 * @Author Chao
 * @Date 2018/7/4 22:09
 */
@Controller
public class VerificationController {
    /**
     * @Description  ajax验证 输入的验证码是否正确
     * @Author       chao
     * @Date         2018/7/4 19:10
     * @Param        参数的作用
     */
    @RequestMapping("/verifCode")
    @ResponseBody
    public String verifCode(HttpSession session , String submitVerification) {
        //获取session中的验证码
        String verification = (String) session.getAttribute("verification");
        System.out.println(verification+"---------------------"+submitVerification);
        if(verification.equalsIgnoreCase(submitVerification)) {
            return "OK";
        }
        return "Error";
    }

    /**
     * @Description  获得验证码
     * @Author       chao
     * @Date         2018/7/4 19:09
     * @Param        参数的作用
     */
    //获取验证码中的随机码，验证码刷新时访问该方法
    @RequestMapping("/verification")
    public String verification(HttpServletResponse response , HttpSession session) throws IOException {
        //随机生成字符串，并写入session
        String code = Verification.getRandCode(4);
        session.setAttribute("verification" , code);
        BufferedImage image = Verification.getImage(100,30, code, 5);
        response.setContentType("image/png");
        OutputStream out = response.getOutputStream();
        out.write(Verification.getByteArray(image));
        out.flush();
        out.close();
        return null;
    }
}
