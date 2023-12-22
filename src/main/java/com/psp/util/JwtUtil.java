package com.psp.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	static String JWT_KEY="thisissecretkeydfsdffsdfsdfsdfdf";

	public static void main(String[] args) {
		System.out.println("Hello World");

		String token = Jwts.builder().setId("A123") // Id
				.setSubject("psp")// Subject
				.setIssuer("psptech")// Provider
				.setIssuedAt(new Date(System.currentTimeMillis()))// Token generation Date
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1)))// Expiration token
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(JWT_KEY.getBytes()))// SignKey
				.compact();// String

		System.out.println(token);

		// Read or parsing the token by providing two inputs
		// Secret key, token

		Claims c = Jwts.parser().setSigningKey(Base64.getEncoder().encode(JWT_KEY.getBytes())).build()
				.parseClaimsJws(token).getBody();

	}

}
