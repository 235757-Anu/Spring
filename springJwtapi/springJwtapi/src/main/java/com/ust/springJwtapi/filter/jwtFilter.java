package com.ust.springJwtapi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ust.springJwtapi.service.Userservice;
import com.ust.springJwtapi.utility.JwtUtility;

@Component

public class jwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private Userservice userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,FilterChain filterChain) throws ServletException,IOException
	{
		String authorization=httpServletRequest.getHeader("Authorization");
		String token=null;
		String UserName=null;
		
		if(null!=authorization && authorization.startsWith("Bearer "))
		{
			token=authorization.substring(7);
			UserName=jwtUtility.getUsernameFromToken(token);
		}
		
		if(null!=UserName && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=
					userService.loadUserByUsername(UserName);
			
			if(jwtUtility.validateToken(token, userDetails))
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
						new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
