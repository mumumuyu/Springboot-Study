package com.lgd.controller;

import com.lgd.pojo.ResBody;
import com.lgd.pojo.User;
import com.lgd.service.UserService;
import com.lgd.utils.JWTUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @ApiOperation(value="用户登录", notes="根据用户名，密码进行登录")
    @PostMapping("/login.do")
    @ResponseBody
    public String login(String code, String pwd, HttpSession session){
        User user = service.getUser(code);
        String password = user.getPassword();
        ResBody resBody = new ResBody();
        if(password.equals(pwd)) {
            session.setAttribute("user",user);
            session.setAttribute("token", JWTUtil.sign(code, password));
            resBody.setCode(200);
            return "ok";
        } else{
            resBody.setCode(500);
            return "no";
        }
    }

    @ApiOperation(value="修改密码")
    @PostMapping("/user/updatePass")
    public ResBody updatePass(@RequestBody Map<String, Object> params,
                              HttpSession session) {
        ResBody resBody = new ResBody();
        String newPsw = params.get("newPsw").toString();
        User user = (User) session.getAttribute("user");
        user.setPassword(newPsw);
        int i = service.updatePass(user.getId(),newPsw);
        if (i != 1){
            resBody.setCode(500);
            resBody.setMsg("修改失败，后台出错");
        }else {
            session.setAttribute("user",user);
            resBody.setCode(200);
            resBody.setMsg("修改成功");
        }
        return resBody;
    }

    @GetMapping("/ajax/getUser")
    public ResBody getUser(@RequestParam int id) {
        ResBody resBody = new ResBody();
        User user = service.findById(id);
        resBody.setCode(200);
        resBody.setMsg(user.getUsername());
        return resBody;
    }

    @GetMapping("/api/getAllUsers")
    public ResBody getAllUsers(@RequestParam int page,
                               @RequestParam int limit) {
        ResBody resBody = new ResBody();
        int count = service.getCount();
        List<User> list= service.findAllUsers(page, limit);
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }

    @PostMapping("/api/addUser")
    @RequiresRoles("admin")
    public ResBody addUser(@RequestBody User user) {
        ResBody resBody = new ResBody();
        int i = service.addUser(user);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("添加成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("添加失败");
        }
        return resBody;
    }

    @PostMapping("/api/updateUser")
    @RequiresRoles("admin")
    public ResBody updateUser(@RequestBody User user) {
        ResBody resBody = new ResBody();
        int i = service.updateUser(user);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("修改成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("修改失败");
        }
        return resBody;
    }

    @GetMapping("/api/delUser")
    @RequiresRoles("admin")
    public ResBody delUser(@RequestParam int id) {
        ResBody resBody = new ResBody();
        int i = service.delUser(id);
        if (i == 1){
            resBody.setCode(200);
            resBody.setMsg("删除成功");
        }else{
            resBody.setCode(500);
            resBody.setMsg("删除失败");
        }
        return resBody;
    }

    @GetMapping("/api/findUser")
    public ResBody findUser(@RequestParam int page,
                            @RequestParam int limit,
                            @RequestParam String role) {
        ResBody resBody = new ResBody();
        int count = service.getCount(role);
        List<User> list= new ArrayList<>();
        if (role.isEmpty()){
            list= service.findAllUsers(page, limit);
            count = service.getCount();
        }else {
            list= service.findUser(page, limit,role);
        }
        resBody.setCount(count);
        resBody.setData(list);
        resBody.setCode(0);
        return resBody;
    }

    @GetMapping("/api/resetPass")
    @RequiresRoles("admin")
    public ResBody resetPass(@RequestParam int id) {
        ResBody resBody = new ResBody();
        service.resetPass(id);
        resBody.setCode(0);
        return resBody;
    }


}
