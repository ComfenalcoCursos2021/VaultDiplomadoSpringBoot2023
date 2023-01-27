package com.pos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.pos.repository.IUserRepository;

@Component
public class PosUserDetailsService implements UserDetailsService{

	
	@Autowired
	private IUserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
		
		var usuario = userRepository.findOneByNickname(nickname)
				.orElseThrow(() -> 
				new UsernameNotFoundException("El usuario con ese nickname no existe"));
		
		return new PosUserDetailsImpl(usuario);
		/*	
		return User.builder()
				.username(username)
				.password(myPassEncoder().encode("root"))
				.roles()
				.build();*/
	}
	
	
	/*
	
	public PasswordEncoder myPassEncoder() {
		return new BCryptPasswordEncoder();
	}
	public static void main (String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("diplomadospring2023"));
	}*/

}
