package com.icycouselo.apiwrapper.service;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.ApiServiceException;
import com.icycouselo.apiwrapper.exception.RFNException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.DomainValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class RFNService {
  private final WebClient client;

  public Mono<ExtractedRecipeDTO> getExtractedRecipe(String encodedUrl) {
    String decodedUrl = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8);
    return client
        .get()
        .uri(uriBuilder -> uriBuilder.path("/extract").queryParam("url", decodedUrl).build())
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .onStatus(
            HttpStatus::is4xxClientError,
            error -> {
              String errMsg = "Error service response status code: ";
              log.error(errMsg + error.rawStatusCode());
              return Mono.error(
                  new ApiServiceException(errMsg + error.rawStatusCode(), error.rawStatusCode()));
            })
        .onStatus(
            HttpStatus::is5xxServerError,
            error -> {
              String errMsg = "Error service response status code: ";
              log.error(errMsg + error.rawStatusCode());
              return Mono.error(
                  new ApiServiceException(errMsg + error.rawStatusCode(), error.rawStatusCode()));
            })
        .bodyToMono(ExtractedRecipeDTO.class);
  }

  public boolean isDomainValid(String url) {
    try {
      URI uri = new URI(url);
      String host = uri.getHost();
      if (!DomainValidator.getInstance(false).isValid(host)) {
        throw new RFNException("Invalid Domain.");
      }
      return true;
    } catch (URISyntaxException e) {
      log.error(": {} is an invalid URI.", url);
      throw new RFNException(e.getMessage());
    }
  }
}
