package com.plaguesoft.microservices.sample.service.domain;

import com.plaguesoft.microservices.sample.service.dto.AccountBuilder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private int age;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account(AccountBuilder builder) {
        this.id = builder.getId();
        this.age = builder.getAge();
        this.name = builder.getName();
        this.email = builder.getEmail();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
