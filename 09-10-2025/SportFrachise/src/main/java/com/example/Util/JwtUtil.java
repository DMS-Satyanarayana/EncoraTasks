package com.example.Util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.Model.CricketPlayer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	@Autowired
	public static CricketPlayer cp;
	 final static String SECRET="my-secret-super-key-for-enough-@#1233484585844994";
	  final static SecretKey key=Keys.hmacShaKeyFor(SECRET.getBytes());
	  final long ExpirationTime=1000*60*60;
  public String generateToken(String username)
  {
	 
	 return Jwts.builder()
	         .setSubject(username)
	         .setIssuedAt(new Date())
	         .setExpiration(new Date(System.currentTimeMillis()+ExpirationTime))
	         .signWith(key,SignatureAlgorithm.HS256)
	         .compact();
  }
  public String extractUsername(String token)
  {
	  Claims body=extractClaims(token);
	  return body.getSubject();
  }
  public static Claims extractClaims(String token)
  {
	  return Jwts.parserBuilder()
		         .setSigningKey(key)
		         .build()
		         .parseClaimsJws(token)
		         .getBody();
  }
  public static boolean validateToken(UserDetails userDetails, String username, String token) {
	    return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

  private  static boolean isTokenExpired(String token) {
	// TODO Auto-generated method stub
	return extractClaims(token).getExpiration().before(new Date());
  }
}
