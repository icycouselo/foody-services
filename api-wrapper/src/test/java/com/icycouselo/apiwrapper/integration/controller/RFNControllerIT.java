package com.icycouselo.apiwrapper.integration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icycouselo.apiwrapper.controller.RFNController;
import com.icycouselo.apiwrapper.domain.extractedrecipe.ExractedRecipeDTO;
import com.icycouselo.apiwrapper.service.RFNService;
import com.icycouselo.apiwrapper.util.TestUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = RFNController.class)
class RFNControllerIT extends TestUtils {

  @Autowired private WebTestClient client;
  @MockBean private RFNService rfnService;

  @BeforeEach
  void setUp(ApplicationContext context) {
    client =
        WebTestClient.bindToApplicationContext(context)
            .configureClient()
            .defaultHeader("X-RapidAPI-Key", "TEST_API_KEY")
            .build();
  }

  @DisplayName("Return extracted json object when calling controller")
  @Test
  void shouldReturnDefaultMessage() throws Exception {
    String json = TestUtils.getFileContent("/responses/extract-from-url.json");
    String urlParam = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
    String apiPath = "/api/v1/foody-services/extract";
    ExractedRecipeDTO recipeDTO = getExtractedRecipeDTO(json);
    Mono<ExractedRecipeDTO> recipeDTOMono = Mono.just(recipeDTO);

    when(rfnService.isDomainValid(urlParam)).thenCallRealMethod();
    when(rfnService.getExtractedRecipe(URLEncoder.encode(urlParam, StandardCharsets.UTF_8)))
        .thenReturn(recipeDTOMono);

    getWebTestClientHeaderSpec(urlParam, apiPath)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody(ExractedRecipeDTO.class)
        .value(ExractedRecipeDTO::getPreparationMinutes, equalTo(5));

    verify(rfnService, times(1))
        .getExtractedRecipe(URLEncoder.encode(urlParam, StandardCharsets.UTF_8));
  }

  @NotNull
  private WebTestClient.RequestHeadersSpec<?> getWebTestClientHeaderSpec(
      String urlParam, String apiPath) {

    return client
        .get()
        .uri(uriBuilder -> uriBuilder.path(apiPath).queryParam("url", urlParam).build());
  }

  private ExractedRecipeDTO getExtractedRecipeDTO(String json) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(json, ExractedRecipeDTO.class);
  }
}
