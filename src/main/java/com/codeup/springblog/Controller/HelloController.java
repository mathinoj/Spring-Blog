package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello") //this is a getRequest
    @ResponseBody //instead of being an html file it is set as a String
    public String hello(){
        return "Hello welcome back.";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello there " + name + "!";
    } // this code takes from the URI and returns back to us. So if you type the name in the browser it will add (/hello/matt).

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return "Hey, your number plus one is " +(number + 1)+ "!";
    }
}


