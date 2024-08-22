package com.musichub.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CallController {

	@GetMapping("/getdata")
	public String getData() {
		return "call reached backend";
	}
	
	@PostMapping("/postdata")
	public String postData(@RequestBody String data) {
		System.out.println(data);
		return "Success";
	}
	
	@PostMapping("/postformdata")
	public String postformdata(@RequestBody String data) {
		System.out.println(data);
		return "Success"; 
	}                      
}

