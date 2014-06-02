package net.codeorbecoded.mytwitter.repositories;

import net.codeorbecoded.mytwitter.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
