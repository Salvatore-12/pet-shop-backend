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
    private PasswordEncoder bcrypt;
    @Autowired
    private JWTTools jwTTools;
    @Autowired
    private UtenteDAO utenteDao;
    @Autowired
    private UtenteService utenteService;

    public String authenticateUtente(UtenteLoginDTO body) {
        Utente utente = utenteService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), utente.getPassword())) {
            return jwTTools.createToken(utente);
        } else {
            throw new UnauthorizedException("Credenziali non valide!!");
        }
    }

    public Utente save(UtenteDTO body) {
        utenteDao.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("questa email " + user.getEmail() + " è gia in uso");
        });
        utenteDao.findBynome(body.nome()).ifPresent(user -> {
            throw new BadRequestException("questo nome" + user.getNome() + " è gia in uso!");
        });
        Utente newUtente = new Utente();
        newUtente.setNome(body.nome());
        newUtente.setCognome(body.cognome());
        newUtente.setEmail(body.email());
        newUtente.setPassword(bcrypt.encode(body.password()));
        newUtente.setRuolo(Ruolo.Utente);
        newUtente.setAvatar("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        return utenteDao.save(newUtente);
    }
}
