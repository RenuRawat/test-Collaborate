package com.niit.collaborate.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForumController {

	
	@GetMapping("/forum")
	public ResponseEntity<String>testMathod()
	{
		return new ResponseEntity<String>("TestController", HttpStatus.OK);
	}
	
}
