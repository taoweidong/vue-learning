package com.taowd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taowd
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@ResponseBody
	@RequestMapping("/getMsg")
	public String sayHello() {

		return "Hello World!!!";
	}
}
