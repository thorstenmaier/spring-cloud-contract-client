package com.trivadis.client;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    public void clientShouldReturnAllCustomers() {
        BDDAssertions.then(this.customerClient.getAllCustomers()).size().isEqualTo(2);
    }
}