package com.icycouselo.apiwrapper.config.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api-wrapper-config")
@RequiredArgsConstructor
public class ApiWrapperConfigProperties {

    @Getter
    @Setter
    private String apiWrapperBaseUrl;
    @Getter
    @Setter
    private String foodyApiBaseUrl;
    @Getter
    @Setter
    private String host;
    @Getter
    @Setter
    private String apiKey;
}
