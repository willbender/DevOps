package com.wb3.springbootdocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller to handle the request path.
 */
@Controller
public class RoutingController {

	/**
	 * Default path.
	 * 
	 * @return File name of a web page corresponding to the path.
	 */
	@GetMapping("/")
	public String home() {
		return "index.xhtml";
	}

}
