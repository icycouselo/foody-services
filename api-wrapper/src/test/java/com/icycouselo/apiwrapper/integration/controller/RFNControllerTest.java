package com.icycouselo.apiwrapper.integration.controller;

import com.icycouselo.apiwrapper.controller.RFNController;
import com.icycouselo.apiwrapper.service.RFNService;
import com.icycouselo.apiwrapper.util.TestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RFNController.class)
class RFNControllerTest extends TestUtils {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RFNService rfnServices;

    @DisplayName("Return extracted json object when calling controller")
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        String urlParam = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
        String json = TestUtils.getFileContent("/responses/extract-from-url.json");
        mockMvc.perform(get("/api/v1/foody-services/extract").content(json)
                        .param("url", urlParam))
                .andExpect(status().isOk());
    }

}