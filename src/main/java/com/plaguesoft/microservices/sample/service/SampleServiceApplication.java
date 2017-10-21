package com.plaguesoft.microservices.sample.service;

import com.plaguesoft.microservices.sample.service.dto.AccountBuilder;
import com.plaguesoft.microservices.sample.service.repo.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class SampleServiceApplication {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {

        return Strings -> Stream.of("Lex Luthor", "Lionel Luthor", "Lois Lane", "Lana Lang")
                .map(s -> new AccountBuilder()
                        .setAge(35)
                        .setName(s)
                        .setEmail(s.replace(" ", "_").toLowerCase() + "@gmail.com").build())
                .forEach(a -> accountRepository.save(a));
    }


    public static void main(String[] args) {
        SpringApplication.run(SampleServiceApplication.class, args);
    }
}
