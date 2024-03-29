package com.greenboard.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Simple controller for building any content required by the Greenboard
 * homepage.
 * 
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact";
	}

}
