package com.gateway.vo;

import com.gateway.model.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginVO {
	
	private Account account;
	private String jwt;

}
