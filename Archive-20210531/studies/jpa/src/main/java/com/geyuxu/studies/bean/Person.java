package com.geyuxu.studies.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    private Integer id;
    private String name;

    public Person() {}
    public Person(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    // @GeneratedValue (strategy=GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
