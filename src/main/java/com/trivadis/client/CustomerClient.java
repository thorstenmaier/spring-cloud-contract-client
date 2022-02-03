package com.trivadis.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomerClient {
    public Collection<Customer> getAllCustomers() {
        return new ArrayList<>();
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
