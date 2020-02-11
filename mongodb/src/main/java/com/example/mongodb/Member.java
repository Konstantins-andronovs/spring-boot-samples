package com.example.mongodb;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("members")
public class Member {
    @Id
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private String gender;

}
