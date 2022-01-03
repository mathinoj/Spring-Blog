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
//        int diceGuess = (int) ((Math.random() * (6 - 1)) + 1);
        String respond;


        int diceGuess = ThreadLocalRandom.current().nextInt(1, 6 + 1);

//        model.addAttribute("cohort", "Welcome to " + number + "?");
//        return "diceRes";

//        model.addAttribute("viewNumber", number);
//        model.addAttribute("viewRoll", roll-dice);
//        return "roll-dice";


        if(diceGuess == n){
            respond = "You guessed correctly!";
        }else{
            respond = "Incorrect. Try again";
        }

        model.addAttribute("number", n);
        model.addAttribute("diceGuess", diceGuess);
        model.addAttribute("respond", respond);

        return "diceRes";
    }




}