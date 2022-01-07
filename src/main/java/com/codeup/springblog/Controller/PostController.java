package com.codeup.springblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String indexPosts(Model model) {
//        Post newPostOne = new Post("Post 1", "Yo!");
//        Post newPostTwo = new Post("Post 2", "Yolo!");
//
//        List<Post> posts = new ArrayList<>();
//        posts.add(newPostOne);
//        posts.add(newPostTwo);

        model.addAttribute("allPosts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String editPost(@PathVariable int id) {
        return "posts/show";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model) {
        Post editPost = postDao.getById(id);

        model.addAttribute("postToEdit", editPost);

        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String saveEditPost(@RequestParam(name = "postTitle") String postTitle, @RequestParam(name = "postCohort") String postCohort, @RequestParam(name = "postBody") String postBody, @RequestParam(name = "postId") long id) {

        Post postToEdit = postDao.getById(id);

        postToEdit.setTitle(postTitle);
        postToEdit.setCohort(postCohort);
        postToEdit.setBody(postBody);

        postDao.save(postToEdit);

        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        long deletePostId = id;
        postDao.deleteById(deletePostId);

        return "redirect:/posts";
    }

    //    @GetMapping("/posts/show")
//    public String individualPost(Model model) {
//        Post newPost = new Post("Hello Earth", "Welcome to the shack");
//        model.addAttribute("post", newPost);
//        return "posts/show";
//    }

//    @GetMapping("/posts/{id}")
//    public String createPost(@PathVariable int id) {
//        return "posts/create";
//    }

    @GetMapping("/posts/create")
//    public String displayCreate(@PathVariable Model model){
    public String displayCreate(Model model){
        model.addAttribute("post", new Post());

//        Post createPost = postDao.getById(id);

//        model.addAttribute("post", new Post());
//        model.addAttribute("postToCreate", createPost);

        return "posts/create";
    }
//IF I CAN SEND EMPTY OBJECT HOW WOULD I SEND AN UN-EMPTY OBJECT


//    @PostMapping("/posts/create")
//    public String createPost(@ModelAttribute Post post) {
//        User user = usersDao.getOne(1L);
//        post.setUser(user);
//        postDao.save(post);
//        return "redirect:/posts";
//    }


//    @PostMapping("/posts/create")
//    public String createPost(@RequestParam(name="postTitle") String postTitle, @RequestParam(name="postCohort") String postCohort, @RequestParam(name="postBody") String postBody) {
//
////        Post postToCreate = postDao.getById(id);
//
//        Post postToCreate = new Post();
//
//        postToCreate.setTitle(postTitle);
//        postToCreate.setCohort(postCohort);
//        postToCreate.setBody(postBody);
//        postToCreate.setUsername(usersDao.getById(1L));
//
//
//        postDao.save(postToCreate);
//
//        return "redirect:/posts";
//    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        post.setUser(userDao.getById(1L));

        postDao.save(post);

        return "redirect:/posts";
    }
}



