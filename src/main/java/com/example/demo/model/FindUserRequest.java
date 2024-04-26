package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindUserRequest {

    @JsonProperty("email")
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
