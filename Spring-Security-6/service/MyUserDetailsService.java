package com.security.springsec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.springsec.model.User;
import com.security.springsec.model.UserPrincipal;
import com.security.springsec.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = repo.findByUsername(username);
		
		if(user == null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		
		return new UserPrincipal(user);
	}

}
