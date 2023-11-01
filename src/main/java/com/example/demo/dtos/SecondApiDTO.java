package com.example.demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SecondApiDTO {
    private int count;
    private String name;
    private String gender;
    private double probability;

    @Override
    public String toString() {
        return "SecondApiDTO{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", probability=" + probability +
                '}';
    }
// Getters and setters
}

