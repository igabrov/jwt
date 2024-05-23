package com.example.generate;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class GenerateToken {
  public String generate (String key) {
    System.out.println("GenerateToken:");
    String jwt = Jwts.builder()
        .subject("myTestUserId")
        .claim("roles", "admin")
        .signWith(Keys.hmacShaKeyFor(key.getBytes()), Jwts.SIG.HS256)
        .compact();
        System.out.println("JWT:\n" + jwt);
        return jwt;
  }
}
