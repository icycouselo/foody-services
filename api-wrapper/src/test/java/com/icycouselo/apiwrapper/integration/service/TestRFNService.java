package com.icycouselo.apiwrapper.integration.service;

import com.icycouselo.apiwrapper.controller.RFNController;
import com.icycouselo.apiwrapper.dto.extractedrecipe.ExractedRecipeDTO;
import com.icycouselo.apiwrapper.service.RFNService;
import com.icycouselo.apiwrapper.util.TestUtils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestRFNService extends TestUtils {
    private static final String HOST_HEADER_KEY = "X-RapidAPI-Host";
    private final MockWebServer mockWebServer = new MockWebServer();
    private final RFNService rfnService = new RFNService(WebClient.create(mockWebServer.url("/").toString()));


    private RFNController controller;

    @BeforeEach
    void setUp() {
        controller = new RFNController(rfnService);
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @DisplayName("Return extracted recipe json object from service when given url")
    @Test
    void getExtractedRecipe() {
        String urlParam = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
        String json = TestUtils.getFileContent("/responses/extract-from-url.json");
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setHeader(HOST_HEADER_KEY, "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .setBody(json));

        ExractedRecipeDTO response = rfnService.getExtractedRecipe(urlParam);
        assertNotNull(response);
        assertThat(response.getVegan(), is(false));
    }

    //todo: add error tests
    //todo: edit .gitignore to prevent uploading .class files
}
