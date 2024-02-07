package salvatoreassennato.petshop.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.exceptions.NotFoundException;
import salvatoreassennato.petshop.repositories.UtenteDAO;

import java.io.IOException;
import java.util.UUID;
@Service
public class UtenteService {
    @Autowired
    UtenteDAO utenteDAO;
    @Autowired
    Cloudinary cloudinary;

    public Page<Utente> findAll(int size, int page, String order){
        Pageable pageable= PageRequest.of(size,page, Sort.by(order));
        return utenteDAO.findAll(pageable);
    }

    public  Utente findById(UUID userId){
        return utenteDAO.findById(userId).orElseThrow(()->new NotFoundException(userId));
    }

    public Utente userUpdate(UUID userId,Utente body){
        Utente update=this.findById(userId);
        update.setNome(body.getNome());
        update.setCognome(body.getCognome());
        update.setEmail(body.getEmail());
        update.setPassword(body.getPassword());
        update.setAvatar(body.getAvatar());
        update.setRuolo(body.getRuolo());
        return utenteDAO.save(update);
    }


    public void userDelete(UUID userId){
        Utente delete=this.findById(userId);
        utenteDAO.delete(delete);
    }

    public Utente findByEmail(String email){
        return utenteDAO.findByEmail(email).orElseThrow(()-> new NotFoundException("Utente con email " + email + " non trovato..."));
    }

    public  String uploadImage(MultipartFile file, UUID userId) throws IOException {
        Utente found = this.findById(userId);
        String url = (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        found.setAvatar(url);
        utenteDAO.save(found);
        return url;
    }
}
