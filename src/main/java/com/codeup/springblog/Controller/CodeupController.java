package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CodeupController {
    private final PostRepository codeupDao;

    public CodeupController(PostRepository codeupDao) {
        this.codeupDao = codeupDao;
    }

    @GetMapping("/codeup")
//    @ResponseBody
    public String postIndex(Model model) {
        model.addAttribute("name", codeupDao.findAll());
//        model.addAttribute("title", codeupDao.findAll());

        model.addAttribute("groups", codeupDao.findAllByName("quasar"));

        return "Codeup";
    }
}



