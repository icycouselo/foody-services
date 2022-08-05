package com.icycouselo.apiwrapper.integration.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HomeControllerIT extends BaseIT {

    @DisplayName("Return application string")
    @Test
    void given_request_return_application_string() throws Exception {
        mockMvc
                .perform(
                        MockMvcRequestBuilders.get("/")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON_VALUE))

                .andExpect(status().is2xxSuccessful());
    }
}