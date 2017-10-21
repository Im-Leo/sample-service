package com.plaguesoft.microservices.sample.service.repo;

import com.plaguesoft.microservices.sample.service.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Collection<Account> findByName(String name);
}
