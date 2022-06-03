package cn.ipangbo.news.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

public class JwtUtils {
    private static final String secretString = "secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
    private static final SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
    private static final long time = 10000 * 60 * 60 * 24;

    public static String creatToken() {
        JwtBuilder jwtBuilder = Jwts.builder();
        return jwtBuilder
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
    }

    public static boolean validateToken(String token) {
        if (token == null || "".equals(token)) {
            return false;
        } else {
            try {
                Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token);
            } catch (ExpiredJwtException | IllegalArgumentException | SignatureException | MalformedJwtException |
                     UnsupportedJwtException e) {
                return false;
            }
        }
        return true;
    }
}
