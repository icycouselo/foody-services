package com.icycouselo.apiwrapper.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icycouselo.apiwrapper.domain.extractedrecipe.ExtractedRecipeDTO;
import com.icycouselo.apiwrapper.entity.extractedrecipe.ExtractedRecipe;
import com.icycouselo.apiwrapper.exception.RFNApiException;
import com.icycouselo.apiwrapper.model.RecipeUrl;
import com.icycouselo.apiwrapper.service.ExtractedRecipeService;
import com.icycouselo.apiwrapper.service.RfnApiService;
import com.icycouselo.apiwrapper.util.TestUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.icycouselo.apiwrapper.util.TestUtils.createRecipesList;
import static com.icycouselo.apiwrapper.util.TestUtils.getExtractedRecipeDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DisplayName("Extracted Recipes Controller")
class ExtractedRecipeControllerIT extends BaseIT {
    @MockBean
    private RfnApiService rfnApiService;

    @MockBean
    private ExtractedRecipeService extractedRecipeService;

    @Nested
    @Test
    void givenRecipesBaseEndpointThenShowAllRecipes() throws Exception {
        List<ExtractedRecipe> recipesList = createRecipesList();

        Mockito.when(extractedRecipeService.findAll()).thenReturn(recipesList);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/recipes")
                                .with(user("test").password("pass").roles("STANDARD_USER"))
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().is2xxSuccessful());
        assertEquals(4, extractedRecipeService.findAll().size());
    }

    @Test
    void givenInvalidMediaTypeThenClientError() throws Exception {
        List<ExtractedRecipe> recipesList = createRecipesList();

        Mockito.when(extractedRecipeService.findAll()).thenReturn(recipesList);
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/recipes")
                                .with(user("test").password("pass").roles("STANDARD_USER"))
                                .contentType(MediaType.APPLICATION_XML_VALUE)
                                .accept(MediaType.APPLICATION_XML_VALUE))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenValidUrlThenExtractRecipe() throws Exception {
        String json = TestUtils.getFileContent("/responses/extract-from-url.json");
        String url = "";
        RecipeUrl recipeUrl = new RecipeUrl(url);

        Mono<ExtractedRecipeDTO> recipeDTOMono = getExtractedRecipeDTOMono(json);
        doMockMethods(url, recipeDTOMono);

        mockMvc
                .perform(
                        MockMvcRequestBuilders.post("/recipes/extract")
                                .with(user("test").password("pass").roles("STANDARD_USER"))
                                .param("url", recipeUrl.getUrl())
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void givenEmptyUrlThenRfnApiException() {
        String url = "";
        Mockito.when(rfnApiService.isDomainValid(url)).thenCallRealMethod();

        RFNApiException thrown =
                assertThrows(
                        RFNApiException.class,
                        () -> rfnApiService.isDomainValid(url),
                        "Expected to retrieve recipe with invalid URL, but exception thrown.");

        assertTrue(thrown.getMessage().contains("Invalid Domain."));
    }

    @Test
    void givenInvalidUriThenRfnApiException() {
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
