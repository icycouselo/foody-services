package com.icycouselo.apiwrapper.controller;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.RFNException;
import com.icycouselo.apiwrapper.service.RFNService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/v1/foody-services")
@RequiredArgsConstructor
@Slf4j
public class RFNController {
  private final RFNService rfnService;

  @GetMapping("/extract")
  public Mono<ExractedRecipeDTO> getExtractedRecipe(@RequestParam String url) {
    if (!rfnService.isDomainValid(url)) {
      log.error("{}: Invalid domain.",url);
      throw new RFNException("Invalid domain.");
    }
    String encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8);
    log.info("Extracting recipe for: {}", encodedUrl);
    return rfnService.getExtractedRecipe(encodedUrl);
  }
}
