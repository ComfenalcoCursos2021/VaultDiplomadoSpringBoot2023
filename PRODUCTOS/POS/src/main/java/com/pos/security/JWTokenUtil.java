package com.pos.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTokenUtil {

	private static String SECRET_KEY = "jJG98CN5j5M5%zLG*SR*I2Kfbrl1yBdN";
	public static String createToken(String nickname, String nombre) {
		long expirationTime = 1000 * 60*60*24;
		Date expDate = new Date(System.currentTimeMillis()+expirationTime);
		Map<String,Object> extraData = new HashMap<String,Object>();
		extraData.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(nickname)
				.setExpiration(expDate)
				.addClaims(extraData)
				.signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
				.compact();
	}
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		
		try {
			
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(SECRET_KEY.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();
			String nickname = claims.getSubject(); 
			
			return new UsernamePasswordAuthenticationToken(nickname,null,Collections.emptyList());
		} catch (Exception e) {
			return null;
		}
	}
}
