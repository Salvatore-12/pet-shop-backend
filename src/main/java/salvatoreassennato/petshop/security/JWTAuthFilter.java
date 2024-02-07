package salvatoreassennato.petshop.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
import java.util.stream.Stream;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JWTTools jwTTools;
    @Autowired
    private UtenteService utenteService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Per favore metti il token nell'Authorization header");
        } else {
            String accessToken = authHeader.substring(7);
            jwTTools.verifyToken(accessToken);
            String id = JWTTools.extractIdFromToken(accessToken);
            Utente utente = utenteService.findById(UUID.fromString(id));

            Authentication authentication = new UsernamePasswordAuthenticationToken(utente, null, utente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
    }
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        AntPathMatcher pathMatcher = new AntPathMatcher();
        return pathMatcher.match("/auth/**", request.getServletPath());
    }

}
