package com.example.demo.dtos;

import com.example.demo.dtos.FirstApiDTO;
import com.example.demo.dtos.SecondApiDTO;
import com.example.demo.dtos.ThirdApiDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CombinedApiResponseDTO {
    private String name;
    private String gender;
    private double genderProbability;
    private int age;
    private int ageCount;
    private String country;
    private double countryProbability;

    public CombinedApiResponseDTO(FirstApiDTO firstApiData, SecondApiDTO secondApiData, ThirdApiDTO thirdApiData) {
        this.name = firstApiData.getName();
        this.gender = secondApiData.getGender();
        this.genderProbability = secondApiData.getProbability() * 100;
        this.age = firstApiData.getAge();
        this.ageCount = firstApiData.getCount();
        this.country = thirdApiData.getCountry().get(0).getCountry_id().toUpperCase();
        this.countryProbability = thirdApiData.getCountry().get(0).getProbability() * 100;
    }
}


