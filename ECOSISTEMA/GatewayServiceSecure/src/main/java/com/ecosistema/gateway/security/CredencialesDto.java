package com.ecosistema.gateway.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter//@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class CredencialesDto {
	private Long id;	
	private String user;
	private String password;
	private String token;
}
