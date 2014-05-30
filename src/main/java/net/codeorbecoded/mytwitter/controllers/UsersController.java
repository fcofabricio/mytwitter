package net.codeorbecoded.mytwitter.controllers;

import net.codeorbecoded.mytwitter.annotations.RequestMappingName;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	@RequestMappingName("signup")
	public String create() {
		return "users/create";
	}

}
