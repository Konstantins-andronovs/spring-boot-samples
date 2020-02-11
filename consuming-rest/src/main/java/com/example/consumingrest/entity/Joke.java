package com.example.consumingrest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Joke {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String setup;
    @Getter
    @Setter
    private String punchline;

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                '}';
    }

}

