package com.icycouselo.apiwrapper.controller;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.NotRecipeInstanceException;
import com.icycouselo.apiwrapper.exception.RFNApiException;
import com.icycouselo.apiwrapper.respository.entity.extractedrecipe.ExtractedRecipe;
import com.icycouselo.apiwrapper.service.ExtractedRecipeService;
import com.icycouselo.apiwrapper.service.RfnApiService;
import com.icycouselo.apiwrapper.util.EntityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Preconditions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/recipes")
public class ExtractedRecipeController {
  private final RfnApiService rfnApiService;
  private final ExtractedRecipeService recipeService;

  @GetMapping(
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<ExtractedRecipe>> getAllRecipes() {
    recipeService.findAll();
    return new ResponseEntity<>(recipeService.findAll(), HttpStatus.OK);
  }

  @PostMapping(
      value = "/create",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ExtractedRecipe> createRecipe(@RequestBody ExtractedRecipeDTO recipe) {
    if (recipe == null) {
      throw new NotRecipeInstanceException("Invalid recipe");
    }
    ExtractedRecipe extractedRecipe = EntityUtils.convertToEntity(recipe);

    return new ResponseEntity<>(recipeService.create(extractedRecipe), HttpStatus.CREATED);
  }

  @PostMapping(
      value = "/extract",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ExtractedRecipe> extractRecipe(@RequestBody String url) {
    Preconditions.checkNotNullOrEmpty(url);
    if (!rfnApiService.isDomainValid(url)) {
      log.error("{}: Invalid domain.", url);
      throw new RFNApiException("Invalid domain.");
    }
    String encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8);
    log.info("Extracting recipe for: {}", encodedUrl);

    ExtractedRecipeDTO extractedRecipeDTO = rfnApiService.getExtractedRecipe(encodedUrl).block();
    ExtractedRecipe extractedRecipe = recipeService.dtoToEntity(extractedRecipeDTO);

    return new ResponseEntity<>(extractedRecipe, HttpStatus.OK);
  }
}
