package com.example.restapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String breed;
    @Getter
    @Setter
    private String origin;

    public Dog(Long id, String name, String breed, String origin) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    public Dog(String name, String breed, String origin) {
        this.name = name;
        this.breed = breed;
    }

    public Dog() {
    }


}
