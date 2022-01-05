package com.codeup.springblog.Controller;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
//BLOCKED OUT ONES ARE THE RITE ONES!!!!!!!


    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "Posts index page.";
    }

    @GetMapping("/posts/show")
    public String individualPost(Model viewModel) {
        Post newPost = new Post("Hello Earth", "Welcome to the shack");
        viewModel.addAttribute("post", newPost);
        return "posts/show";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "View the form for creating a post. ";
    }

    @PostMapping("/posts/create/new")
    @ResponseBody
    public String postsCreateNew() {
        return "Create a new post. ";
    }

}


//        POST	/posts/create	create a new post

