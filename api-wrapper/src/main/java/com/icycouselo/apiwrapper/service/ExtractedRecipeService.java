package com.icycouselo.apiwrapper.service;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.respository.ExtractedRecipeRepository;
import com.icycouselo.apiwrapper.respository.entity.extractedrecipe.ExtractedRecipe;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.icycouselo.apiwrapper.util.EntityUtils.convertToEntity;

@Service
@Slf4j
@AllArgsConstructor
public class ExtractedRecipeService {

  private final ExtractedRecipeRepository recipeRepository;

  public ExtractedRecipe create(ExtractedRecipe recipe) {
    return recipeRepository.save(recipe);
  }

  public List<ExtractedRecipe> findAll() {
    return recipeRepository.findAll(Sort.by("title"));
  }

  public ExtractedRecipe dtoToEntity(ExtractedRecipeDTO extractedRecipeDTO) {
    return convertToEntity(extractedRecipeDTO);
  }
}
