package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.exceptions.BadRequestException;
import salvatoreassennato.petshop.payloads.UtenteDTO;
import salvatoreassennato.petshop.payloads.UtenteLoginDTO;
import salvatoreassennato.petshop.payloads.UtenteLoginResponseDTO;
import salvatoreassennato.petshop.payloads.UtenteResponseDTO;
import salvatoreassennato.petshop.security.JWTTools;
import salvatoreassennato.petshop.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JWTTools jwtTools;

    @PostMapping("/login")
    public UtenteLoginResponseDTO login(@RequestBody UtenteLoginDTO body) {
        String accessToken = authService.authenticateUtente(body);
        return new UtenteLoginResponseDTO(accessToken);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UtenteResponseDTO createUser(@RequestBody @Validated UtenteDTO newUtentePayload, BindingResult validation) {
        if (validation.hasErrors()) {
            System.out.println(validation.hasErrors());
            throw new BadRequestException(validation.getAllErrors());
        } else {
            Utente newUtente = authService.save(newUtentePayload);
            String accessToken = jwtTools.createToken(newUtente);
            return new UtenteResponseDTO(newUtente.getId(),accessToken);
        }
    }



}
