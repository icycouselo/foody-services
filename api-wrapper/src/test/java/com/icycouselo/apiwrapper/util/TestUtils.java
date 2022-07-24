package com.icycouselo.apiwrapper.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.respository.entity.extractedrecipe.ExtractedRecipe;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@ActiveProfiles("dev")
public class TestUtils {

  public static String getFileContent(String uri) {
    Path filePath = Path.of(getAbsolutePath() + uri);
    Path path = filePath.normalize();
    try {
      return Files.readString(path);
    } catch (IOException e) {
      log.error("Can't read file: " + path);
      throw new RuntimeException(e);
    }
  }

  private static String getAbsolutePath() {
    Path resourceDirectory = Paths.get("src", "test", "resources");
    return resourceDirectory.toFile().getAbsolutePath();
  }

  public static ExtractedRecipe convertToEntity(ExtractedRecipeDTO extractedRecipeDTO) {
    ModelMapper modelmapper = new ModelMapper();
    return modelmapper.map(extractedRecipeDTO, ExtractedRecipe.class);
  }

  public static ExtractedRecipeDTO getExtractedRecipeDTO(String json)
      throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(json, ExtractedRecipeDTO.class);
  }
}
