package com.example.demo.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {
    private String country_id;
    private double probability;

    // Getters and setters

    @Override
    public String toString() {
        return "CountryDTO{" +
                "country_id='" + country_id + '\'' +
                ", probability=" + probability +
                '}';
    }
}
