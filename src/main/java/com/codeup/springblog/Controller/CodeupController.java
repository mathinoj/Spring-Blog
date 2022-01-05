package com.codeup.springblog.Controller;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CodeupController {
    private final PostRepository codeupDao;

    public CodeupController(PostRepository codeupDao) {
        this.codeupDao = codeupDao;
    }

    @GetMapping("/codeup")
//    @ResponseBody
    public String codeupIndex(Model model) {
        model.addAttribute("allCodeup", codeupDao.findAllByName(""));
//        model.addAttribute("allCodeup", codeupDao.findAll());
//        model.addAttribute("allCodeup", codeupDao.findAll());

//        model.addAttribute("name", codeupDao.findByName("Matthias"));
//        model.addAttribute("cohort", codeupDao.findByCohort("Quasar"));
//        model.addAttribute("body", codeupDao.findByBody(""));

        return "codeup";
    }
}



