package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String landing() {
        return "This is the landing page!";
    }


    @GetMapping("/home") //this could be changed to any name, but to access home.html the return has to be correct
    public String welcome() {
        return "home"; //this is returning the name of the html, which is home.html that you created
    }

}
//Create a MathController class.
//This controller should listen for requests for several routes that correspond to basic arithmetic operations and produce the result of the arithmetic.