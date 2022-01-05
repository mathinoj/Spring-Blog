package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {
    private final CarRepository carDao;

    public CarController(CarRepository carDao){
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String carIndex(Model model){
        model.addAttribute("cars", carDao.findAll());

        model.addAttribute("toyotas", carDao.findByMake("Toyota")); //to do this you have to make method in carRepository
        return "cars";
    }
}


//to insert manually into terminal just type "INSERT INTO CARS (make, model) VALUES ("Toyota", "Tacoma");
//"INSERT INTO CARS (make, model) VALUES ("Chevy", "Astro");