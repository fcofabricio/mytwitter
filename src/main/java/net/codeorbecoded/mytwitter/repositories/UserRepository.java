package net.codeorbecoded.mytwitter.repositories;

import java.util.List;

import net.codeorbecoded.mytwitter.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByEmail(String email);
	
}
