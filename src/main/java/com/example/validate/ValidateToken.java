package com.example.validate;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class ValidateToken {
  public void validate(String jwt, String key) {
    Jws<Claims> jws = Jwts.parser()
      .setSigningKey(key.getBytes())
      // .verifyWith(key.getBytes())
      .build()
      .parseSignedClaims(jwt);
    System.out.println("JWS:\n" + jws);

    System.out.println("JWS payload:\n" + jws.getPayload().entrySet());
  }
}
