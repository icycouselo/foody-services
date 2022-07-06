package com.icycouselo.apiwrapper.service;

import com.icycouselo.apiwrapper.exception.RFNException;
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
class RFNServiceTest {

  @Mock
  private RFNService rfnService;

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
    when(rfnService.isDomainValid(url)).thenCallRealMethod();
    boolean domainValid = rfnService.isDomainValid(url);

    assertEquals("plantbasedrdblog.com", host);
    assertTrue(domainValid);
    verify(rfnService, times(1)).isDomainValid(url);
  }

  @Test
  @DisplayName("Test if domainname is invalid. Should throw RFN exception")
  void isDomainInvalid() throws URISyntaxException {
    String url = "https://localhost:8080/";
    URI uri = new URI(url);
    String host = uri.getHost();
    when(rfnService.isDomainValid(url)).thenCallRealMethod();

    assertEquals("localhost", host);
    assertThrows(RFNException.class, ()->  rfnService.isDomainValid(url));
    verify(rfnService, times(1)).isDomainValid(url);
  }

  @Test
  @DisplayName("Test if domain name is invalid. Should throw URISyntax exception")
  void shouldThrowURISyntaxException() {
    String url = "http://www. test.com/";
    when(rfnService.isDomainValid(url)).thenCallRealMethod();

    RFNException thrown = assertThrows(RFNException.class, () -> rfnService.isDomainValid(url));
    assertTrue(thrown.getMessage().contains("Illegal character in authority"));
    verify(rfnService, times(1)).isDomainValid(url);
  }
}
