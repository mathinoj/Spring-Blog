package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NewCodeupController {


    @GetMapping("/codeup/create")
    public String showCreateForm(Model model) {
        model.addAttribute("codeup", new Codeup());
        return "codeup/create";
    }


    @PostMapping("/codeup/create")
    public String create(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "cohort") String cohort
    ) {
        Codeup codeup = new Codeup();
        codeup.setName(name);
        codeup.setCohort(cohort);

        return "codeup/create";
    }

}
