package com.codeup.springblog.Controller;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String indexPosts(Model model){
        model.addAttribute("allPosts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post individualPost = postDao.getById(id);
        model.addAttribute("individualPost", individualPost);
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

    @GetMapping("/posts/create")
//    public String displayCreatePost(@PathVariable Model model){
    public String displayCreatePost(Model model){
        model.addAttribute("post", new Post());

        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){


        User postCreator = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUser(userDao.getById(2L));
        post.setUser(postCreator);


        String emailSubject = post.getUser().getUsername() + ", your post has been created!";


//        String emailCohort = post.getUsername().getUsername() + ", your cohort is listed as: ";

        String emailBody = "Congrats your latest post is up: " + post.getBody();

        emailService.prepareAndSend(post, emailSubject, emailBody);
        postDao.save(post);

        return "redirect:/posts";
    }
}



//    @GetMapping("/posts/create/{id}")
////    public String displayCreate(@PathVariable Model model){
//    public String displayCreateId(@PathVariable long id, Model model){
////        model.addAttribute("post", new Post());
//        Post postId = postDao.getById(id);
//        model.addAttribute("post", postId);
////        postDao.getById(postId);
//
//        return "posts/show";
//    }

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
