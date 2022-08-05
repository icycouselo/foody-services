package com.icycouselo.apiwrapper.controller;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.entity.extractedrecipe.ExtractedRecipe;
import com.icycouselo.apiwrapper.exception.NoDataFoundException;
import com.icycouselo.apiwrapper.exception.NotRecipeInstanceException;
import com.icycouselo.apiwrapper.model.RecipeUrl;
import com.icycouselo.apiwrapper.service.ExtractedRecipeService;
import com.icycouselo.apiwrapper.service.RfnApiService;
import com.icycouselo.apiwrapper.util.EntityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RolesAllowed({"STANDARD_USER"})
@RequestMapping(value = "/recipes", consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE}, headers = {"Accept=application/json"})
public class ExtractedRecipeController {
    private final RfnApiService rfnApiService;
    private final ExtractedRecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<ExtractedRecipe>> getAllRecipes() {
        recipeService.findAll();
        return new ResponseEntity<>(recipeService.findAll(), HttpStatus.OK);
    }

    @RolesAllowed({"STANDARD_USER"})
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> extractRecipe(RecipeUrl url) {
        if (url.getUrl() == null || url.getUrl().isEmpty() || !rfnApiService.isDomainValid(url.getUrl())) {
            log.error("{}: Invalid domain.", url);
            throw new NoDataFoundException("Invalid domain.");
        }
        String encodedUrl = URLEncoder.encode(url.getUrl(), StandardCharsets.UTF_8);
        log.info("Extracting recipe for: {}", encodedUrl);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
