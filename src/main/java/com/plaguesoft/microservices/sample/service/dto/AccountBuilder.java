package com.plaguesoft.microservices.sample.service.dto;

import com.plaguesoft.microservices.sample.service.domain.Account;

public class AccountBuilder {
    private Long id;
    private String name;
    private String email;
    private int age;

    public Long getId() {
        return id;
    }

    public AccountBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccountBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AccountBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public AccountBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public Account build() {
        return new Account(this);
    }
}
