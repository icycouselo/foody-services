package com.icycouselo.apiwrapper.domain.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {
    @Getter
    @Setter
    T response;
}
