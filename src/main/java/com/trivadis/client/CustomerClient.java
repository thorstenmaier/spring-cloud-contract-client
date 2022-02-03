package com.trivadis.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Component
public class CustomerClient {
    public Collection<Customer> getAllCustomers() {
        ParameterizedTypeReference<Collection<Customer>> ptr = new ParameterizedTypeReference<>() {};
        return new RestTemplate().exchange("http://localhost:8080/customers", HttpMethod.GET, null, ptr).getBody();
    }
}

class Customer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
