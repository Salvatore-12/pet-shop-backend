package salvatoreassennato.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.Enum.Ruolo;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.exceptions.BadRequestException;
import salvatoreassennato.petshop.exceptions.UnauthorizedException;
import salvatoreassennato.petshop.payloads.UtenteDTO;
import salvatoreassennato.petshop.payloads.UtenteLoginDTO;
import salvatoreassennato.petshop.repositories.UtenteDAO;
import salvatoreassennato.petshop.security.JWTTools;

@Service
public class AuthService {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UtenteDAO utenteDao;
    @Autowired
    private PasswordEncoder bcrypt;

    public String authenticator(UtenteLoginDTO body)
    {
        Utente utente= utenteService.findByEmail(body.email());
        if(bcrypt.matches(body.password(),utente.getPassword()))
        {
            return jwtTools.createToken(utente);
        }
        else
        {
            throw new UnauthorizedException("password errata");
        }
    }
    public Utente save(UtenteDTO body)
    {
        utenteDao.findByEmail(body.email()).ifPresent(user ->
        {
            throw new BadRequestException("L'email "+ user.getEmail() + " è già in uso");
        });
        Utente newuser=new Utente();
        newuser.setNome(body.nome());
        newuser.setCognome(body.cognome());
        newuser.setPassword(bcrypt.encode(body.password()));
        newuser.setEmail(body.email());
        newuser.setAvatar("ifhewiofofnewofbewofeowbfoiewbf");
        newuser.setRuolo(Ruolo.Utente);
        return utenteDao.save(newuser);
    }
}
