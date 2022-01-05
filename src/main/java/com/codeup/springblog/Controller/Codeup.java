package com.codeup.springblog.Controller;

import javax.persistence.*;

@Entity
public class Codeup {
    @Id
    @GeneratedValue()

    private long id;

    public long getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    @Column(nullable = false, length = 50)
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
