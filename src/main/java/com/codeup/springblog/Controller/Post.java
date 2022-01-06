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


//    public Post(String title, String cohort, String body){
//        this.title = title;
//        this.cohort = cohort;
//        this.body = body;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCohort(){
//        return cohort;
//    }
//
//    public void setCohort(String cohort){
//        this.cohort = cohort;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
}
