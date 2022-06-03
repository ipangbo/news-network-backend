package cn.ipangbo.news.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

public class JwtUtilsTest {

    private final String signature = "admin";
    private final String secretString = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
    private final SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));

    @Test
    public void jwt() {
        long time = 10000 * 60 * 60 * 24;

        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ", "JWT")
                // payload
                .claim("username", "ipangbo")
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(key)
                .compact();
        System.out.println(jwtToken);
    }

    @Test
    public void parseJwt() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImlwYW5nYm8iLCJyb2xlIjoiYWRtaW4iLCJzdWIiOiJhZG1pbi10ZXN0IiwiZXhwIjoxNjUyNzA2NjM2LCJqdGkiOiIyMjVlOTlkNS0wYjE0LTRjY2UtOGMyZS1iZDA0OWNkNTdlYzAifQ.pKxT14d6WKrT2j04uoumZdq9KGM-wQIUnSJR_uL-H1jFcuvtDEVtvvIgoCb8AxDarrpBSa6fLJiSQKWev8O5AA";
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        System.out.println(claimsJws);
        Claims claims = claimsJws.getBody();
        System.out.println(claims.get("username"));
        System.out.println(claims.get("role"));
        System.out.println(claims.getExpiration());
        System.out.println(claims.getId());
    }
}
