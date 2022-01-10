package com.codeup.springblog.Controller;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false,length = 100)
    private String cohort;

    @Column(nullable = false, length = 1000)
    private String body;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

//    public Post(){}

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getCohort(){
        return cohort;
    }

    public void setCohort(String cohort){
        this.cohort = cohort;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }


}
