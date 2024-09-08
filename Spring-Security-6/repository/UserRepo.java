package com.security.springsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.springsec.model.User;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	
	User findByUsername(String username);
}
