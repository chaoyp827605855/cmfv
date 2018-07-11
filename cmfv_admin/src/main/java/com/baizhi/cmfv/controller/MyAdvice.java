package com.baizhi.cmfv.controller;

import com.baizhi.cmfv.bean.Log;
import com.baizhi.cmfv.bean.Manager;
import com.baizhi.cmfv.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @ClassName MyAdvice
 * @Description 类的作用
 * @Author Chao
 * @Date 2018/7/9 20:32
 */
@Aspect
@Component  // 将该类添加到spring容器中
public class MyAdvice {

    @Autowired
    private HttpSession session;
    @Autowired
    private LogService logService;
    //声明切入点
    @Pointcut(value = "(execution(* com.baizhi.cmfv.service.impl.*.modify*(..))||execution(* com.baizhi.cmfv.service.impl.*.remove*(..)) || execution(* com.baizhi.cmfv.service.impl.*.add*(..)) ) && !execution(* com.baizhi.cmfv.service.impl.LogServiceImpl.*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) {
        Log log = new Log();
        //获取当前登录用户
        Manager manager = (Manager) session.getAttribute("Manager");
        //获取log日志的uuid
        String uuid = UUID.randomUUID().toString().replace("-","");

        //获取类的对象
        Class clazz = pjp.getTarget().getClass();
        System.out.println("--------clazz-------------"+clazz.getName());

        //获取方法的参数
        Object[] args = pjp.getArgs();
        //获取方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        //获取方法对象
        Method method = methodSignature.getMethod();
        //获取方法名
        String methodName = method.getName();
        String operation = null;
        //判断 methodName 是否以指定字符串开头
        if(methodName.startsWith("add")){
            operation = "新增";
        }
        if(methodName.startsWith("modify")){
            operation = "修改";
        }
        if(methodName.startsWith("remove")){
            operation = "删除";
        }
        //为log对象赋值
        log.setId(uuid);
        log.setUser(manager.getName());
        //获取当前时间
        log.setTime(new Date());
        //获取全限定名
        String classFromName = clazz.getName();
        String className = classFromName.substring(classFromName.lastIndexOf(".")+1).replace("ServiceImpl","");
        log.setResource(className);
        log.setOperation(operation);
        String message = "";
        for (Object arg : args) {
            message += arg.toString();
        }
        log.setMessage(message);
        //----------------------------------前

        // result 标识 方法 是否出现异常
        String result = "success";
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            result = "failure";
            throwable.printStackTrace();
        }finally {
            log.setResult(result);
            logService.addLog(log);
        }
        //----------------------------------后
        return obj;
    }

}
