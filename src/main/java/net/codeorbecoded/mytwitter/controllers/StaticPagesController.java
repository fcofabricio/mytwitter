package net.codeorbecoded.mytwitter.controllers;

import net.codeorbecoded.mytwitter.utils.RequestMappingUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticPagesController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		RequestMappingUtils.getInstance();
		return "static-pages/home";
	}
	
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help() {
		return "static-pages/help";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "static-pages/about";
	}	
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "static-pages/contact";
	}	

}
