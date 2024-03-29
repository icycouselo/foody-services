package com.icycouselo.apiwrapper.config;

import com.icycouselo.apiwrapper.config.model.ApiWrapperConfigProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
public class ApiWrapperConfig {
    @Getter
    private final ApiWrapperConfigProperties configProperties;
    private static final String HOST_HEADER_KEY = "X-RapidAPI-Host";
    private static final String API_KEY_HEADER_KEY = "X-RapidAPI-Key";

    private HttpClient getHttpClient() {
        return HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(
                        conn ->
                                conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                        .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
    }

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(getHttpClient()))
                .baseUrl(configProperties.getFoodyApiBaseUrl())
                .defaultHeader(HOST_HEADER_KEY, configProperties.getHost())
                .defaultHeader(API_KEY_HEADER_KEY, configProperties.getApiKey())
                .build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
