package com.icycouselo.apiwrapper.service;

import com.icycouselo.apiwrapper.exception.RFNApiException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RfnApiServiceTest {

  @Mock private RfnApiService rfnApiService;

  @BeforeEach
  void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Test if domainname is valid")
  void isDomainValid() throws URISyntaxException {
    String url = "https://plantbasedrdblog.com/2022/06/red-pesto-pasta/";
    URI uri = new URI(url);
    String host = uri.getHost();
    when(rfnApiService.isDomainValid(url)).thenCallRealMethod();
    boolean domainValid = rfnApiService.isDomainValid(url);

    assertEquals("plantbasedrdblog.com", host);
    assertTrue(domainValid);
    verify(rfnApiService, times(1)).isDomainValid(url);
  }

  @Test
  @DisplayName("Test if domainname is invalid. Should throw RFN exception")
  void isDomainInvalid() throws URISyntaxException {
    String url = "https://localhost:8080/";
    URI uri = new URI(url);
    String host = uri.getHost();
    when(rfnApiService.isDomainValid(url)).thenCallRealMethod();

    assertEquals("localhost", host);
    assertThrows(RFNApiException.class, () -> rfnApiService.isDomainValid(url));
    verify(rfnApiService, times(1)).isDomainValid(url);
  }

  @Test
  @DisplayName("Test if domain name is invalid. Should throw URISyntax exception")
  void shouldThrowURISyntaxException() {
    String url = "http://www. test.com/";
    when(rfnApiService.isDomainValid(url)).thenCallRealMethod();

    RFNApiException thrown =
        assertThrows(RFNApiException.class, () -> rfnApiService.isDomainValid(url));
    assertTrue(thrown.getMessage().contains("Illegal character in authority"));
    verify(rfnApiService, times(1)).isDomainValid(url);
  }
}
