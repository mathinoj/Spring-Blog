package com.codeup.springblog.Controller;

import com.codeup.springblog.models.Post;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> userPosts) {
        this.posts = userPosts;
    }

    public User(){} //class 'User' should have [public, protected] no-arg constructor

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }



    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



