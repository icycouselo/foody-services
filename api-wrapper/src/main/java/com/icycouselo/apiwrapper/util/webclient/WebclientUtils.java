package com.icycouselo.apiwrapper.util.webclient;

import com.icycouselo.apiwrapper.exception.ApiServiceException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@UtilityClass
@Slf4j
public class WebclientUtils {
    public static ExchangeFilterFunction handleError() {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            if (response.statusCode() != null && (response.statusCode().is4xxClientError() || response.statusCode().is5xxServerError())) {
                return response.bodyToMono(String.class)
                        .defaultIfEmpty(response.statusCode().getReasonPhrase())
                        .flatMap(body -> {
                            log.debug("Body is {}", body);
                            return Mono.error(new ApiServiceException(body, response.rawStatusCode()));
                        });
            } else {
                return Mono.just(response);
            }
        });
    }
}