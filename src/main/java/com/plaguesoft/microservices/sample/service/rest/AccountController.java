package com.plaguesoft.microservices.sample.service.rest;

import com.plaguesoft.microservices.sample.service.domain.Account;
import com.plaguesoft.microservices.sample.service.dto.AccountBuilder;
import com.plaguesoft.microservices.sample.service.dto.AccountRequest;
import com.plaguesoft.microservices.sample.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RefreshScope
@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Value("${prop.name:default}")
    private String name;

    @Value("${password.encrypted:dummyPass}")
    private String pass;

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public Resource<Account> create(@RequestBody AccountRequest account) {

        AccountBuilder builder = new AccountBuilder().setAge(account.getAge())
                .setEmail(account.getEmail())
                .setName(account.getName());
        Account acc = accountService.createAccount(builder.build());
        Resource<Account> resource = getAccountResource(acc);
        return resource;
    }

    private Resource<Account> getAccountResource(Account acc) {
        Resource<Account> resource = new Resource<>(acc);
        resource.add(linkTo(methodOn(AccountController.class).get(acc.getId())).withSelfRel());
        return resource;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Resource<Account> get(@PathVariable Long id) {
        Account account = accountService.getAccount(id);
        Resource<Account> resource = new Resource<>(account);
        return resource;
    }

    @GetMapping()
    public List<Resource<Account>> getAll() {
        List<Resource<Account>> resources = new ArrayList<Resource<Account>>();
        accountService.getAll().stream().forEach(a -> resources.add(getAccountResource(a)));
        return resources;
    }

    @GetMapping("/test")
    public Creds getName() {
        return new Creds(name, pass);
    }

    public class Creds {
        private String name;
        private String pass;

        public Creds(String name, String pass) {
            this.name = name;
            this.pass = pass;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPass() {
            return this.pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

    }
}
