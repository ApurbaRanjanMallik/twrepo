package com.tw.jwt;

import com.tw.jwt.util.JWTUtil;

import io.jsonwebtoken.Claims;

public class Test {

	public static void main(String[] args) {

		/*
		 * String key="tw"; //token generation String token= Jwts.builder()
		 * .setId("Apurba18") //id .setSubject("Apurba") //subject
		 * .setIssuer("techwish") //provider .setIssuedAt(new
		 * Date(System.currentTimeMillis()))//token generate date .setExpiration(new
		 * Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))//valid
		 * until .signWith(SignatureAlgorithm.HS256, //sign algorithm
		 * Base64.getEncoder().encode(key.getBytes())) //secret key .compact(); //String
		 * System.out.println(token); //eyJhbGciOiJIUzI1NiJ9. //
		 * eyJqdGkiOiJBcHVyYmExOCIsInN1YiI6IkFwdXJiYSIsImlzcyI6InRlY2h3aXNoIiwiaWF0IjoxNjc5ODU4MTc5LCJleHAiOjE2Nzk4NTg3Nzl9.
		 * //Q479kZTp27rsS7WmDjAb7tXdt4ZYV0Ivqr6lc9xDUlM
		 * 
		 * //Reading Token/Parsing Token Claims c= Jwts.parser()
		 * .setSigningKey(Base64.getEncoder().encode(key.getBytes()))
		 * .parseClaimsJws(token) .getBody();
		 */
		JWTUtil util=new JWTUtil();
		String token=util.getTokens("AA18", "Apurba", "TechWish");
		System.out.println(token);
		Claims c=util.getClaims("TechWish", token);
		System.out.println(c.getSubject());
		System.out.println(c.getId());
		System.out.println(c.getIssuer());
		System.out.println(c.getIssuedAt());
		System.out.println(c.getExpiration());
		
	}

}


