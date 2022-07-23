package com.icycouselo.apiwrapper.controller;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.RFNException;
import com.icycouselo.apiwrapper.respository.entity.extractedrecipe.ExtractedRecipe;
import com.icycouselo.apiwrapper.service.ExtractedRecipeService;
import com.icycouselo.apiwrapper.service.RFNService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Preconditions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/foody-services/recipes")
public class ExtractedRecipeController {
  private final RFNService rfnService;
  private final ExtractedRecipeService extractedRecipeService;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public ExtractedRecipe createRecipe(@RequestBody String url) {
    Preconditions.checkNotNullOrEmpty(url);
    if (!rfnService.isDomainValid(url)) {
      log.error("{}: Invalid domain.", url);
      throw new RFNException("Invalid domain.");
    }
    String encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8);
    log.info("Extracting recipe for: {}", encodedUrl);

    ExtractedRecipeDTO extractedRecipeDTO = rfnService.getExtractedRecipe(encodedUrl).block();
    ExtractedRecipe extractedRecipe = extractedRecipeService.dtoToEntity(extractedRecipeDTO);
    return extractedRecipeService.create(extractedRecipe);
  }
}
