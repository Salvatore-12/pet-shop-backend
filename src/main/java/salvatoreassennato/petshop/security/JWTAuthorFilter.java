package salvatoreassennato.petshop.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.exceptions.UnauthorizedException;
import salvatoreassennato.petshop.service.UtenteService;

import java.io.IOException;
import java.util.UUID;

@Component
public class JWTAuthorFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JWTAuthorFilter.class);
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UtenteService utenteService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // Se l'header Authorization non è presente o non ha il formato corretto
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Per favore metti il token JWT nell'header Authorization con il formato corretto: Bearer <token>");
            return;
        }

        // Esegue la verifica e l'estrazione del token solo se l'header Authorization è presente e corretto
        String accessToken = authHeader.substring(7);
        try {
            jwtTools.verifyToken(accessToken);
            String id = jwtTools.extractIdFromToken(accessToken);
            Utente utente = utenteService.findById(UUID.fromString(id));
            Authentication authentication = new UsernamePasswordAuthenticationToken(utente, null, utente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        } catch (UnauthorizedException e) {
            // Se il token non è valido o non può essere verificato
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token JWT non valido o scaduto. Effettua il login.");
        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return new AntPathMatcher().match("/auth/**",request.getServletPath());
    }
}
