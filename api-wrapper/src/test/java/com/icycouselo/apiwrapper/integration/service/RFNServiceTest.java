package com.icycouselo.apiwrapper.integration.service;

import com.icycouselo.apiwrapper.dto.extractedrecipe.ExractedRecipeDTO;
import com.icycouselo.apiwrapper.exception.ApiServiceException;
import com.icycouselo.apiwrapper.service.RFNService;
import com.icycouselo.apiwrapper.util.TestUtils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RFNServiceTest {
    private static final String HOST_HEADER_KEY = "X-RapidAPI-Host";
    private final MockWebServer mockWebServer = new MockWebServer();
    private final RFNService rfnService = new RFNService(WebClient.create(mockWebServer.url("/").toString()));

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @DisplayName("Return extracted recipe json object from service when given url")
    @Test
    void shouldExtractRecipe() {
        String urlParam = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
        String json = TestUtils.getFileContent("/responses/extract-from-url.json");
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setHeader(HOST_HEADER_KEY, "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .setBody(json));

        ExractedRecipeDTO response = rfnService.getExtractedRecipe(urlParam).block();
        assertNotNull(response);
        assertThat(response.getVegan(), is(false));
    }

    @DisplayName("Return exception from service when given url is of wrong format")
    @Test
    void shouldThrowApiServiceException() {
        String urlParam = "htt://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
        enqueueMockserverWithResponse();
        Mono<ExractedRecipeDTO> extractedRecipeMono = rfnService.getExtractedRecipe(urlParam);
        Exception exception = assertThrows(ApiServiceException.class, extractedRecipeMono::block);
        String expectedMessage = "Error service response status code: 500";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    private void enqueueMockserverWithResponse() {
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(500));
    }

    @DisplayName("Return exception from service when given status code is of 4xx")
    @Test
    void shouldThrowApiServiceExceptionFrom4xxStatusCode() {
        String urlParam = "http://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(401));
        Mono<ExractedRecipeDTO> extractedRecipeMono = rfnService.getExtractedRecipe(urlParam);
        Exception exception = assertThrows(ApiServiceException.class, extractedRecipeMono::block);

        String expectedMessage = "Error service response status code: 401";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage,expectedMessage);

    }

    @DisplayName("Return exception from service when given status code is of 5xx")
    @Test
    void shouldThrowApiServiceExceptionFrom5xxStatusCode() {
        String urlParam = "http://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(500));
        Mono<ExractedRecipeDTO> extractedRecipeMono = rfnService.getExtractedRecipe(urlParam);

        Exception exception = assertThrows(ApiServiceException.class, extractedRecipeMono::block);
        String expectedMessage = "Error service response status code: 500";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage,expectedMessage);

    }


}