package com.bootrest.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Value("${omvts.auth.username}")
	private String authUsername;

	@Value("${omvts.auth.password}")
	private String authPassword;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (authUsername.equals(username)) {
			// Password static by Bcrypt
			// return new User("msrtcvaahan",
			// "$2a$10$Rcf9BpKY/omUGiU9iXYwyOv85CxMmktN6/cD6/rm0CSHQInL85ELi",
			// new ArrayList<>());

			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			// outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
			String password = encoder.encode(authPassword).replace("{bcrypt}", "");
			return new User(authUsername, password, new ArrayList<>());

		} else {
			System.out.println("User not found with username: " + username);
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}