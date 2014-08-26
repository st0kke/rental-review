package com.st0kke.rentalreview.restservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET) 
	public @ResponseBody String sayHello(){
		return "hello";
	}
}
