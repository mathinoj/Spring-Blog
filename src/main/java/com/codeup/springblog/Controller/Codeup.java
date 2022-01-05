package com.codeup.springblog.Controller;


import javax.persistence.*;

@Entity
@Table(name="codeupTable")
public class Codeup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 150)
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = this.name;
    }

    @Column(nullable = false, length = 250)
    private String cohort;

    public String getCohort(){
        return cohort;
    }

    public void setCohort(String cohort){
        this.cohort = this.cohort;
    }


    @Column(nullable = false, length = 5000)
    private String body;

    public String getBody(){
        return body;
    }

    public void setBody(){
        this.body = body;
    }

}
//    private String name;
//    private String body;
//
//    public Post(String title, String body){
//        this.title = title;
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
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//}