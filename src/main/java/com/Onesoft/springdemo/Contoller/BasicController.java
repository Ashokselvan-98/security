package com.Onesoft.springdemo.Contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
public class BasicController {

	@GetMapping("public")
	public String hello() {
		return "this is public application";
	}

	@GetMapping("user")
	public String user() {
		return "this is user application";
	}

	@GetMapping("admin")
	public String admin() {
		return "this is admin application";
	}
	
}
