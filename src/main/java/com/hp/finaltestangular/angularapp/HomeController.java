package com.hp.finaltestangular.angularapp;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String home()
    {
        System.out.println("Home Page Requested");
        return "index";
    }
}
