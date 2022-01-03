package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
//BLOCKED OUT ONES ARE THE RITE ONES!!!!!!!


    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "Posts index page.";
    }

        @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable int id){
        return "View an individual post. " +id;
    }


        @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "View the form for creating a post. ";
    }

        @PostMapping("/posts/create")
        @ResponseBody
        public String postsCreateNew () {
            return "Create a new post. ";
        }

}


//        POST	/posts/create	create a new post

