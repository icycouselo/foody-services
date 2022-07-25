package com.icycouselo.apiwrapper.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.RFNApiException;
import com.icycouselo.apiwrapper.respository.entity.extractedrecipe.ExtractedRecipe;
import com.icycouselo.apiwrapper.service.ExtractedRecipeService;
import com.icycouselo.apiwrapper.service.RfnApiService;
import com.icycouselo.apiwrapper.util.TestUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.icycouselo.apiwrapper.util.TestUtils.createRecipesList;
import static com.icycouselo.apiwrapper.util.TestUtils.getExtractedRecipeDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.4.1")
class ExtractedRecipeControllerIT {

  @Autowired private MockMvc mockMvc;
  @MockBean private RfnApiService rfnApiService;
  @MockBean private ExtractedRecipeService extractedRecipeService;

  @DisplayName("GET - Show all recipes")
  @Test
  void when_no_path_get_all_recipes_DB() throws Exception {
    List<ExtractedRecipe> recipesList = createRecipesList();

    Mockito.when(extractedRecipeService.findAll()).thenReturn(recipesList);
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/recipes")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().is2xxSuccessful());
    assertEquals(4, extractedRecipeService.findAll().size());
  }

  @DisplayName("GET - Client error when invalid media type for all recipes request")
  @Test
  void when_invalid_media_type_then_client_error() throws Exception {
    List<ExtractedRecipe> recipesList = createRecipesList();

    Mockito.when(extractedRecipeService.findAll()).thenReturn(recipesList);
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/recipes")
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .accept(MediaType.APPLICATION_XML_VALUE))
        .andExpect(status().is4xxClientError());
  }

  @DisplayName("POST- Create a recipe")
  @Test
  void whenUrl_then_save_in_DB() throws Exception {
    String json = TestUtils.getFileContent("/responses/extract-from-url.json");
    String url = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";

    Mono<ExtractedRecipeDTO> recipeDTOMono = getExtractedRecipeDTOMono(json);
    doMockMethods(url, recipeDTOMono);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/recipes/extract")
                .content(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().is2xxSuccessful());
  }

  @DisplayName("POST- Bad request when empty URL to create a recipe")
  @Test
  void when_Empty_Url_Then_Bad_Request() throws Exception {
    String json = TestUtils.getFileContent("/responses/extract-from-url.json");
    String url = "";
    Mono<ExtractedRecipeDTO> recipeDTOMono = getExtractedRecipeDTOMono(json);
    doMockMethods(url, recipeDTOMono);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/recipes/extract")
                .content(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().is4xxClientError());
  }

  @DisplayName("POST- Throw exception when local URI to create a recipe")
  @Test
  void when_Local_Uri_Then_Exception() {
    String url = "http://10.10.10";
    Mockito.when(rfnApiService.isDomainValid(url)).thenCallRealMethod();

    RFNApiException thrown =
        assertThrows(
            RFNApiException.class,
            () -> rfnApiService.isDomainValid(url),
            "Expected to retrieve recipe with invalid URL, but excpeption thrown.");

    assertTrue(thrown.getMessage().contains("Invalid Domain."));
  }

  private void doMockMethods(String url, Mono<ExtractedRecipeDTO> recipeDTOMono) {
    Mockito.when(rfnApiService.isDomainValid(url)).thenCallRealMethod();
    Mockito.when(rfnApiService.getExtractedRecipe(URLEncoder.encode(url, StandardCharsets.UTF_8)))
        .thenReturn(recipeDTOMono);
  }

  @NotNull
  private Mono<ExtractedRecipeDTO> getExtractedRecipeDTOMono(String json)
      throws JsonProcessingException {
    ExtractedRecipeDTO recipeDTO = getExtractedRecipeDTO(json);
    return Mono.just(recipeDTO);
  }
}
