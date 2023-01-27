package com.pos.filters;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
//@WebFilter
public class PosInitialFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
			
		System.out.println("ENTRO AL FILTRO " + (new Date()));
		System.out.println(request.getHeader("POS_AUTH"));


		if(request.getHeader("POS_AUTH") == null ||
				!"R00T".equals(request.getHeader("POS_AUTH"))) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			filterChain.doFilter(request, response);
		}		
		
	}

}
