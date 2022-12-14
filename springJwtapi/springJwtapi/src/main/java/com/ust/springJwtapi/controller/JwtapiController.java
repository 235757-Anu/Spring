package com.ust.springJwtapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.springJwtapi.model.JwtRequest;
import com.ust.springJwtapi.model.JwtResponse;
import com.ust.springJwtapi.service.Userservice;
import com.ust.springJwtapi.utility.JwtUtility;

@RestController

public class JwtapiController {
	
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private Userservice userService;
	
	@GetMapping("/")
	public String home()
	{
		return "Welcome to Daily Code Buffer!!";
	}
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest)throws Exception
	{
		try {
			authenticationmanager.authenticate(
					new UsernamePasswordAuthenticationToken(
							jwtRequest.getUsername(),
							jwtRequest.getPassword()
							)
					);
		}catch(BadCredentialsException e)
		{
			throw new Exception("INVALID_CREDENTIALS",e);
		}
		
		final UserDetails userDetails=
				userService.loadUserByUsername(jwtRequest.getUsername());
		final String token=
				jwtUtility.generateToken(userDetails);
		return new JwtResponse();
	}
	

}
