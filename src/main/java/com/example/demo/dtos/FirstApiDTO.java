package com.example.demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FirstApiDTO {
    private int count;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "FirstApiDTO{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

