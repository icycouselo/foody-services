package com.icycouselo.apiwrapper.integration.controller;

import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.RFNException;
import com.icycouselo.apiwrapper.service.ExtractedRecipeService;
import com.icycouselo.apiwrapper.service.RFNService;
import com.icycouselo.apiwrapper.util.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
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

import static com.icycouselo.apiwrapper.util.TestUtils.getExtractedRecipeDTO;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.4.1")
class ExtractedRecipeControllerIT {

  @Autowired private MockMvc mockMvc;
  @MockBean private RFNService rfnService;
  @MockBean private ExtractedRecipeService extractedRecipeService;

  @DisplayName("POST- Create a recipe")
  @Test
  @Order(1)
  void whenUrl_then_save_in_DB() throws Exception {
    String json = TestUtils.getFileContent("/responses/extract-from-url.json");
    String url = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";

    ExtractedRecipeDTO recipeDTO = getExtractedRecipeDTO(json);
    Mono<ExtractedRecipeDTO> recipeDTOMono = Mono.just(recipeDTO);

    Mockito.when(rfnService.isDomainValid(url)).thenCallRealMethod();
    Mockito.when(rfnService.getExtractedRecipe(URLEncoder.encode(url, StandardCharsets.UTF_8)))
        .thenReturn(recipeDTOMono);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/foody-services/recipes/create")
                .content(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @DisplayName("POST- Bad request when empty URL to create a recipe")
  @Test
  @Order(2)
  void when_Empty_Url_Then_Bad_Request() throws Exception {
    String json = TestUtils.getFileContent("/responses/extract-from-url.json");
    String url = "";

    ExtractedRecipeDTO recipeDTO = getExtractedRecipeDTO(json);
    Mono<ExtractedRecipeDTO> recipeDTOMono = Mono.just(recipeDTO);

    Mockito.when(rfnService.isDomainValid(url)).thenCallRealMethod();
    Mockito.when(rfnService.getExtractedRecipe(URLEncoder.encode(url, StandardCharsets.UTF_8)))
        .thenReturn(recipeDTOMono);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/api/v1/foody-services/recipes/create")
                .content(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError());
  }

  @DisplayName("POST- Throw exception when local URI to create a recipe")
  @Test
  @Order(3)
  void when_Local_Uri_Then_Exception() {
    String url = "http://10.10.10";
    Mockito.when(rfnService.isDomainValid(url)).thenCallRealMethod();

    RFNException thrown =
        assertThrows(
            RFNException.class,
            () -> rfnService.isDomainValid(url),
            "Expected to retrieve recipe with invalid URL, but excpeption thrown.");

    assertTrue(thrown.getMessage().contains("Invalid Domain."));
  }
}
