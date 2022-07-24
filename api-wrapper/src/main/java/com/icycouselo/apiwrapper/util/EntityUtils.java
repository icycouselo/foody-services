package com.icycouselo.apiwrapper.util;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.respository.entity.extractedrecipe.ExtractedRecipe;
import org.modelmapper.ModelMapper;

public class EntityUtils {

  private EntityUtils() {}

  public static ExtractedRecipe convertToEntity(ExtractedRecipeDTO extractedRecipeDTO) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(extractedRecipeDTO, ExtractedRecipe.class);
  }
}
