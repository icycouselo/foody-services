package com.icycouselo.apiwrapper.service;

import com.icycouselo.apiwrapper.dto.extractedrecipe.ExractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.ApiServiceException;
import com.icycouselo.apiwrapper.exception.RFNException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;

@Service
@Slf4j
@RequiredArgsConstructor
public class RFNService {
    private final WebClient webClient;

    public Mono<ExractedRecipeDTO> getExtractedRecipe(String encodedUrl) {
        String decodedUrl = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8);
        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/extract")
                                .queryParam("url", decodedUrl).build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> {
                            String errMsg = "Error service response status code: ";
                            log.error(errMsg + error.rawStatusCode());
                        return  Mono.error(
                                new ApiServiceException(errMsg + error.rawStatusCode(),error.rawStatusCode()));
                })
                .onStatus(HttpStatus::is5xxServerError,
                        error -> {
                            String errMsg = "Error service response status code: ";
                            log.error(errMsg + error.rawStatusCode());
                            return  Mono.error(
                                    new ApiServiceException(errMsg + error.rawStatusCode(),error.rawStatusCode()));
                        })
                .bodyToMono(ExractedRecipeDTO.class);
    }


}
