package com.codeup.springblog.Controller;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @OneToMany(mappedBy = "user")
    private List<Post> userPosts;

    @Column(nullable = false, length = 100)
    private String username;

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Column(nullable = false, length = 100)
    private String email;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Column(nullable = false, length = 100)
    private String password;

    public String password(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
