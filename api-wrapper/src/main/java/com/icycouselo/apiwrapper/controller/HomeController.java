package com.icycouselo.apiwrapper.controller;

import com.icycouselo.apiwrapper.config.ApiWrapperConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private ApiWrapperConfig config;

    @GetMapping(value = "/",
            produces = {"text/plain;charset=utf-8"}, headers = {"Accept=text/plain", "Accept=application/json"})
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Foody REST API. Get the best out of your recipes.", HttpStatus.OK);
    }

}
