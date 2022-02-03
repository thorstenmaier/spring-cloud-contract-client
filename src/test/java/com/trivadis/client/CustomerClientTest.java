package com.trivadis.client;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

@SpringBootTest
@AutoConfigureStubRunner(ids = "com.trivadis:spring-cloud-contract-service:+:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    public void clientShouldReturnAllCustomers() {
        BDDAssertions.then(this.customerClient.getAllCustomers()).size().isEqualTo(1);
    }
}