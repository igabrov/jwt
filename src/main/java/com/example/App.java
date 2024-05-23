package com.example;

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
        GenerateToken generateToken = new GenerateToken();
        ValidateToken validateToken = new ValidateToken();
        String jwt = generateToken.generate(KEY);
        validateToken.validate(jwt, KEY);
    }
}
