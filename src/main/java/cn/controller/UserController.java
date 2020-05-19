package cn.controller;

import cn.entity.User;
import cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("/user/hello")
    public ModelAndView getAll(){
        ModelAndView modelAndView=new ModelAndView();
        List<User> users=userService.getAll();
        modelAndView.addObject("user",users);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("/user/sel")
    public ModelAndView getAll(String username,Integer enabled){
        ModelAndView modelAndView=new ModelAndView();
        List<User> userList=userService.getUserName(username,enabled);
        modelAndView.addObject("users",userList);
        modelAndView.setViewName("sel");
        return modelAndView;
    }
    @GetMapping("/user/delete")
    public int delete(Integer uid){
        return userService.delete(uid);
    }
    @GetMapping("/admin/hello")
    public String hello(){
        return "helloadmin";
    }
    @GetMapping("/root/hello")
    public String helloroot(){
        return "helloroot";
    }
}
