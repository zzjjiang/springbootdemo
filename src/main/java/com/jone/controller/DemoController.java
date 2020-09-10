package com.jone.controller;

import com.jone.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzj
 * @description  thymeleaf 语法测试
 * @date 2020.09.10
 */
@Controller
public class DemoController {

    @RequestMapping("demo")
    public ModelAndView test(HttpSession session){
        session.setAttribute("demo","admin");
        ModelAndView mav = new ModelAndView("demo");
        User user = new User();
        user.setUserName("IMJ");
        user.setPhone("110");
        user.setSex(3);
        user.setEmail("zoujone@163.com");
        user.setCreateDate("2020-09-10 10:22:44");
        /*对象访问*/
        mav.addObject("user",user);
        /*单个属性访问*/
        mav.addObject("msg","I AM J");
        /*集合数据访问*/
        List<User> users = getUserList();
        mav.addObject("users",users);
        return mav;
    }

    private List<User> getUserList() {
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setUserName("u1");
        u1.setPhone("111");
        u1.setSex(1);
        u1.setCreateDate("2020-09-11 10:22:44");
        User u2 = new User();
        u2.setUserName("u2");
        u2.setPhone("222");
        u2.setSex(2);
        u2.setCreateDate("2020-09-12 10:22:44");
        User u3 = new User();
        u3.setUserName("u3");
        u3.setPhone("333");
        u3.setSex(1);
        u3.setCreateDate("2020-09-13 10:22:44");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }
}
