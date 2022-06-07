package com.icycouselo.apiwrapper.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icycouselo.apiwrapper.dto.extractedrecipe.ExractedRecipeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class RFNService {
    private final WebClient webClient;

    public ExractedRecipeDTO getExtractedRecipe(String encodedUrl) {
        String decodedUrl = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8);
        //todo: validate url to prevent SSRF
        ExractedRecipeDTO exractedRecipeDTO = webClient.get().uri(uriBuilder ->
                        uriBuilder.path("/extract")
                                .queryParam("url", decodedUrl).build())
                .retrieve().bodyToMono(ExractedRecipeDTO.class).block();
        return  exractedRecipeDTO;
    }
}
