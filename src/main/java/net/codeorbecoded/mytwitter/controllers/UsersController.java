package net.codeorbecoded.mytwitter.controllers;

import net.codeorbecoded.mytwitter.annotations.RequestMappingName;
import net.codeorbecoded.mytwitter.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	@RequestMappingName("signup")
	public String create() {
		return "users/create";
	}

}
