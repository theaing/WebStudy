package com.theaking.controller.portal;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main/")
public class MainController {
    @RequestMapping("index.do")
    public ModelAndView index(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("main.jsp");
        System.out.println(12);
        return  modelAndView;
    }
}
