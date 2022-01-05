//this creates a table, without us having to do a migration/seeder file

package com.codeup.springblog.Controller;

import javax.persistence.*;

@Entity
//@Table(name="cars") <-- This will change the table name from "car" to "cars"
//to delete a row from table in mysql you'd type "delete from where id = X;"
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false) <--this was created automatically
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(nullable = false, length = 50)
    private String make;

    @Column(nullable = false, length = 50)
    private String model;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

