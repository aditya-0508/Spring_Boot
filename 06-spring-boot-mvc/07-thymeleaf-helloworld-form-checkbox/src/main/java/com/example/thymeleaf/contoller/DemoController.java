package com.example.thymeleaf.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //create a mapping for "/hello"

    @GetMapping("/hello")
    public String sayHello(Model theModel){//MVC model
        theModel.addAttribute("theDate",java.time.LocalDateTime.now());
        return "helloworld";//the html file
    }//theDate in html file,is taken from here spring mvc helps for that
}
