package com.tw.jwt.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	//Generate Token
	public String getTokens(
			String id,
			String subject,
			String key
			) {
		return Jwts.builder()
				.setId(id)			//id
				.setSubject(subject)		//subject
				.setIssuer("techwish")		//provider
				.setIssuedAt(new Date(System.currentTimeMillis()))//token generate date
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))//valid until
				.signWith(SignatureAlgorithm.HS256, 					//sign algorithm
						Base64.getEncoder().encode(key.getBytes()))		//secret key
				.compact();					//String	;
	}
	//Get claims
	public Claims getClaims(String key, String token) {
		return Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(key.getBytes()))
				.parseClaimsJws(token)
				.getBody();
	}
	public String getSubject(String key, String token) {
		return getClaims(key, token).getSubject();
	}
	public boolean isValidToken(String key, String token) {
		return getClaims(key, token)
				.getExpiration()
				.after(new Date(System.currentTimeMillis()));
	}
}
