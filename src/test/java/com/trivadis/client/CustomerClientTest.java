package com.trivadis.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureWireMock
@AutoConfigureJson
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void clientShouldReturnAllCustomers() throws JsonProcessingException {

        String json = objectMapper.writeValueAsString(Arrays.asList(new Customer(), new Customer()));

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/customers"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(json)));

        BDDAssertions.then(this.customerClient.getAllCustomers()).size().isEqualTo(2);
    }
}