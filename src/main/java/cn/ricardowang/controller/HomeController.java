package cn.ricardowang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wangqin
 * @Date: 2021/2/8 0008 - 02 -08 -1:06
 * @Description: main.cn.ricardowang.controller
 * @version: 1.0
 */
@Controller
public class HomeController {
    @RequestMapping("/signin")
    public String signIn(HttpServletRequest request, HttpServletResponse response) {
            return "signin";
    }
    @RequestMapping("/404")
    public String error(HttpServletRequest request, HttpServletResponse response) {
        return "404";
    }
    @RequestMapping("/favorites")
    public String favorites(HttpServletRequest request, HttpServletResponse response) {
        return "favorites";
    }
    @RequestMapping("/main")
    public String main(HttpServletRequest request, HttpServletResponse response) {
        return "main";
    }
    @RequestMapping("/profile")
    public String profile(HttpServletRequest request, HttpServletResponse response) {
        return "profile";
    }
    @RequestMapping("/showBook")
    public String showBook(HttpServletRequest request, HttpServletResponse response) {
        return "showBook";
    }
    @RequestMapping("/signup")
    public String signUp(HttpServletRequest request, HttpServletResponse response) {
        return "signup";
    }
    @RequestMapping("/uploadfile")
    public String uploadFile(HttpServletRequest request, HttpServletResponse response) {
        return "uploadfile";
    }
    @RequestMapping("/QQ")
    public String QQ(HttpServletRequest request, HttpServletResponse response) {
        return "QQ";
    }
    @RequestMapping("/Github")
    public String GitHub(HttpServletRequest request, HttpServletResponse response) {
        return "Github";
    }
}
