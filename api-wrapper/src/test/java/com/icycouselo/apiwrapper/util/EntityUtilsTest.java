package com.icycouselo.apiwrapper.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.entity.extractedrecipe.ExtractedRecipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityUtilsTest extends TestUtils {

    @BeforeEach
    public void init() {
    }

    @Test
    @Order(1)
    @DisplayName("Successfully convert DTO to Entity")
    void convertToEntity() throws JsonProcessingException {
        ModelMapper mapper = new ModelMapper();
        String json = TestUtils.getFileContent("/responses/extract-from-url.json");
        ExtractedRecipeDTO recipeDTO = getExtractedRecipeDTO(json);

        ExtractedRecipe extractedRecipe = mapper.map(recipeDTO, ExtractedRecipe.class);
        assertEquals(recipeDTO.getVegan(), extractedRecipe.getVegan());
        assertEquals(recipeDTO.getTitle(), extractedRecipe.getTitle());
        assertEquals(recipeDTO.getVegetarian(), extractedRecipe.getVegetarian());
    }

    public static ExtractedRecipeDTO getExtractedRecipeDTO(String json)
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, ExtractedRecipeDTO.class);
    }
}
