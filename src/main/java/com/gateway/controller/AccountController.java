package com.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.model.Account;
import com.gateway.services.AccountService;


@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.loginAccount(account.getUsername(), account.getPassword()));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Account account) {
		accountService.save(account.getUsername(), account.getPassword());
		return ResponseEntity.ok().build();
	}
	
}
