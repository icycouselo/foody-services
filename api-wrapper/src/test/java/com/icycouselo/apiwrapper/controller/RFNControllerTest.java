package com.icycouselo.apiwrapper.controller;

import com.icycouselo.apiwrapper.service.RFNService;
import com.icycouselo.apiwrapper.util.TestUtils;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RFNControllerTest {

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

    @Test
    void getExtractedRecipe() {
        String urlParam = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
        String json = TestUtils.getFileContent("/responses/extract-from-url.json");
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody(json));

        String response = controller.getExtractedRecipe(urlParam).block();
        assertNotNull(response);
    }
}