package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.petshop.Enum.Ruolo;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.exceptions.BadRequestException;
import salvatoreassennato.petshop.payloads.UtenteDTO;
import salvatoreassennato.petshop.payloads.UtenteLoginDTO;
import salvatoreassennato.petshop.payloads.UtenteLoginResponseDTO;
import salvatoreassennato.petshop.payloads.UtenteResponseDTO;
import salvatoreassennato.petshop.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UtenteLoginResponseDTO login(@RequestBody UtenteLoginDTO body)
    {
        String accesToken=authService.authenticator(body);
        return new UtenteLoginResponseDTO(accesToken);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UtenteResponseDTO createUser(@RequestBody @Validated UtenteDTO newUserPayload, BindingResult validation)
    {
        if (validation.hasErrors())
        {
            throw new BadRequestException("Ci sono errori nel payload!");
        }
        else
        {
            String nome = newUserPayload.nome();
            String cognome = newUserPayload.cognome();
            String email = newUserPayload.email();
            String indirizzo = newUserPayload.indirizzo();
            String password = newUserPayload.password();
            Ruolo ruolo = newUserPayload.ruolo();
            String avatar = newUserPayload.avatar();

            Utente newUser = new Utente();
            newUser.setNome(nome);
            newUser.setCognome(cognome);
            newUser.setEmail(email);
            newUser.setIndirizzo(indirizzo);
            newUser.setPassword(password);
            newUser.setRuolo(ruolo);
            newUser.setAvatar(avatar);
            Utente utente = authService.save(newUserPayload);
            return new UtenteResponseDTO(utente.getId());
        }
    }
}
