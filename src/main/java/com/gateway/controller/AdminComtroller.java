package com.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/admin")
public class AdminComtroller {

	@PostMapping
	public ResponseEntity<?> save() {
		return ResponseEntity.ok().build();
	}
}
