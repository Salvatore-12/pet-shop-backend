package salvatoreassennato.petshop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.exceptions.UnauthorizedException;

import java.util.Date;

@Component
public class JWTTools {
    @Value("${spring.jwt.secret}")
    private String secret;

    public String createToken(Utente utente)
    {
        return Jwts.builder().subject(String.valueOf(utente.getId()))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*24*7))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
    public void verifyToken(String token)
    {
        try
        {
        Claims claims= Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody();
        }
        catch (ExpiredJwtException ex) {
            throw ex; // Rilancia l'eccezione
        }
        catch (Exception ex)
        {
            throw new UnauthorizedException("Problemi con il token! Effettua il login");
        }
    }
    public String extractIdFromToken(String token)
    {
        return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build()
                .parseSignedClaims(token)
                .getPayload().getSubject();
    }
}
