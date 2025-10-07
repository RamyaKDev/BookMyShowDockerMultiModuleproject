package com.userapp.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.userapp.service.JwtUserServiceImpl;
import com.userapp.util.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserServiceImpl jwtUserServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwtToken = null;
		String username = null;
		// get the header from the request
		String header = request.getHeader("Authorization");
		System.out.println(header);
		// check if header value starts with bearer
		// This will be true for other urls - /book-api/books, /bookid
		// Bearer asjsdfq323asdada
		if (header != null && header.startsWith("Bearer ")) {
			// get the token by striping the Bearer
			jwtToken = header.substring(7);
			try {
				// get the username using JwtTokenUtil class
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("cannot get name");
			} catch (ExpiredJwtException e) {
				System.out.println("Token has expired");
			}
		} else {
			logger.warn("invalid token");
		}
		// if username is not null, check in db &&
		// get the context from SecurityContextHolder and check if it is null
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			// check in db call the service method
			System.out.println(username);
			UserDetails userDetails = jwtUserServiceImpl.loadUserByUsername(username);
			// after getting all the details of the user validate the token for signature
			// if the token is a valid token - then configure security
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				System.out.println(userDetails);
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				// set the authentication type to the context
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		System.out.println("call filterchain do filter");
		// this will be called first - for /register and /authenticate
		filterChain.doFilter(request, response);

	}
}
