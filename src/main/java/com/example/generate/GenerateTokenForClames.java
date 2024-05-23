package com.example.generate;

import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class GenerateTokenForClames {
  public String generate (String key, Map<String,?> clames) {
    System.out.println("GenerateToken for Clames:" + clames);
    JwtBuilder builder = Jwts.builder()
      .subject("myTestUserId");
    
    for (Map.Entry<String,?> entry : clames.entrySet()) {  
      builder.claim(entry.getKey(), entry.getValue());
      System.out.println("Key = " + entry.getKey() + 
                       ", Value = " + entry.getValue());  
    }
    
    String jwt = builder
      .signWith(Keys.hmacShaKeyFor(key.getBytes()), Jwts.SIG.HS256)
      .compact();
      System.out.println("JWT:\n" + jwt);
    return jwt;
  }

  public Map<String,?> getClames() {
    Map<String,Object> clames = new HashMap<String,Object>(); 
    clames.put("aud", "https://graph.microfoft.com");
    clames.put("iss", "https://sts.windows.net/123456");
    clames.put("iat", "1716476670");
    clames.put("nbf", "1716476670");
    clames.put("acct", 0);
    clames.put("acr", "1");
    clames.put("acrs", new String[]{"urn:user:reg"});
    clames.put("aio", "AVQAq");
    clames.put("amr", new String[]{"pwd", "rsa", "mfa"});
    return clames;
  }
}
