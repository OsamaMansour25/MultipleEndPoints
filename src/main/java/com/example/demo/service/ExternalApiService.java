package com.example.demo.service;

import com.example.demo.dtos.FirstApiDTO;
import com.example.demo.dtos.SecondApiDTO;
import com.example.demo.dtos.ThirdApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {

    private WebClient webClient = WebClient.create();

    public Mono<FirstApiDTO> callFirstApi(String name) {
        return webClient.get()
                .uri("https://api.agify.io/?name=" + name)
                .retrieve()
                .bodyToMono(FirstApiDTO.class);
    }


    public Mono<SecondApiDTO> callSecondApi(String name) {
        return webClient.get()
                .uri("https://api.genderize.io/?name=" + name)
                .retrieve()
                .bodyToMono(SecondApiDTO.class);
    }

    public Mono<ThirdApiDTO> callThirdApi(String name) {
        return webClient.get()
                .uri("https://api.nationalize.io/?name=" + name)
                .retrieve()
                .bodyToMono(ThirdApiDTO.class);
    }
}

