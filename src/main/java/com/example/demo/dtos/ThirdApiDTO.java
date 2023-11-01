package com.example.demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ThirdApiDTO {
    private int count;
    private String name;
    private List<CountryDTO> country;

    @Override
    public String toString() {
        return "ThirdApiDTO{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
