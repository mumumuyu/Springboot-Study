package com.lgd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    @RequestMapping("/user/login")
    public String UserLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model){
        if (!username.isEmpty() && "123456".equals(password)){
            session.setAttribute("userLogin",username);
            return "redirect:/main";
        }else{
            model.addAttribute("msg","您的用户名或密码错误");
            return "index";
        }
    }
}
