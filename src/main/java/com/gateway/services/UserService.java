package com.gateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gateway.exception.DataNotFoundException;
import com.gateway.repository.AccountRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username).orElseThrow(() -> new DataNotFoundException("查無此帳號	"));
	}

}
