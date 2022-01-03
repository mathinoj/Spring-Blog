package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{numA}/{numB}", method = RequestMethod.GET)
    //ORR    @RequestMapping(path = "/add/{numA}/and/{numB}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int numA, @PathVariable int numB){
        return "your total is " +(numA + numB)+ ".";
    }
    //public int add(@PathVariable int numA, @PathVariable int numB) { return numA + numB; }

    @RequestMapping(path = "/minus/{numA}/{numB}", method = RequestMethod.GET)
    @ResponseBody
    public String minus(@PathVariable int numA, @PathVariable int numB){
        return "your total is " +(numA - numB)+ ".";
    }

    @RequestMapping(path = "/times/{numA}/{numB}", method = RequestMethod.GET)
    @ResponseBody
    public String times(@PathVariable int numA, @PathVariable int numB){
        return "your total is " +(numA * numB)+ ".";
    }

    @RequestMapping(path = "/divide/{numA}/{numB}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int numA, @PathVariable int numB){
        return "your total is " +(numA / numB)+ ".";
    }
}

//Create a MathController class.
//This controller should listen for requests for several routes that correspond to basic arithmetic operations and produce the result of the arithmetic.