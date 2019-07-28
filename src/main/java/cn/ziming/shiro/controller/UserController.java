package cn.ziming.shiro.controller;

import cn.ziming.shiro.model.User;
import cn.ziming.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("/info")
    @ResponseBody
    public List<User> printUserInfo(){
        return userService.selectAll();
    }

    @RequestMapping("/index")
    // @ResponseBody
    public String ok(){
        return "index.html";
    }

    @RequestMapping("/testThymeleaf")
    // @ResponseBody
    public String testThymeleaf(Model model){

        model.addAttribute("name", "倪子铭");
        return "admin/thymeleaf.html";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", "倪子铭");
        return "user/add.html";
    }

    @RequestMapping("/login")
    public String login(){
        return "/login.html";
    }

    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("name", "倪子铭");
        return "user/update.html";
    }



    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model){
        /*
         * 使用shiro编写认证
         */
        // 1.获取subject
        // Subject subject = SecurityUtils.getSubject();

        // 2.封装用户数据
        // UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        // 3.执行登录操作
        return "testThymeleaf";

        // try {
        //     subject.login(token);
        //     return "testThymeleaf";
        // }catch (UnknownAccountException e){
        //     model.addAttribute("msg", "用户名不存在");
        //     return "login";
        // }catch (IncorrectCredentialsException e){
        //     model.addAttribute("msg", "密码错误");
        //     return "login";
        // }
    }


}
