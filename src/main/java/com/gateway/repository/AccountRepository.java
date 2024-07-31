package com.gateway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gateway.model.Account;


public interface AccountRepository extends JpaRepository<Account,String> {

	Optional<Account> findByUsername(String username);
}
