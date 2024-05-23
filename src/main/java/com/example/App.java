package com.example;

import com.example.generate.GenerateTokenForClames;
import com.example.validate.ValidateToken;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String KEY = "this is my secret key, that no one else know or use";
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // GenerateToken generateToken = new GenerateToken();
        GenerateTokenForClames generateToken = new GenerateTokenForClames();
        ValidateToken validateToken = new ValidateToken();
        String jwt = generateToken.generate(KEY, generateToken.getClames());
        validateToken.validate(jwt, KEY);
    }
}
