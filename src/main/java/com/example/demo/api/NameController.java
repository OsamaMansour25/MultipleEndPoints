package com.example.demo.api;

import com.example.demo.dtos.CombinedApiResponseDTO;
import com.example.demo.dtos.FirstApiDTO;
import com.example.demo.dtos.SecondApiDTO;
import com.example.demo.dtos.ThirdApiDTO;
import com.example.demo.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class NameController {
     ExternalApiService externalApiService;
    public NameController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }

    @GetMapping("/endpoint")
    public Mono<CombinedApiResponseDTO> getCombinedData(@RequestParam String name) {
        Mono<FirstApiDTO> firstApiData = externalApiService.callFirstApi(name);
        Mono<SecondApiDTO> secondApiData = externalApiService.callSecondApi(name);
        Mono<ThirdApiDTO> thirdApiData = externalApiService.callThirdApi(name);

        return Mono.zip(firstApiData, secondApiData, thirdApiData)
                .map(tuple -> {
                    FirstApiDTO firstApiDTO = tuple.getT1();
                    SecondApiDTO secondApiDTO = tuple.getT2();
                    ThirdApiDTO thirdApiDTO = tuple.getT3();

                    // Create your custom CombinedApiResponseDTO
                    CombinedApiResponseDTO combinedDTO = new CombinedApiResponseDTO(firstApiDTO, secondApiDTO, thirdApiDTO);
                    return combinedDTO;
                });
    }
}
