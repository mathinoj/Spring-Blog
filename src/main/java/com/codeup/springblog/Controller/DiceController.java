package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String viewRollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String dice(@PathVariable int n, Model model){
        int diceGuess = (int) ((Math.random() * (7 - 1)) + 1);
        String respond;

        if(diceGuess == n){
            respond = "You got it, brah!";
        }else{
            respond = "Try again, broseph";
        }

        model.addAttribute("number", n);
        model.addAttribute("diceGuess", diceGuess);
        model.addAttribute("respond", respond);

        return "diceRes";
    }




}