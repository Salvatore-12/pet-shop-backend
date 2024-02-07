package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.service.UtenteService;

import java.util.UUID;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    UtenteService utenteService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Utente> usersList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "userId") String order) {
        return utenteService.findAll(page, size, order);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Utente uniqueUser(@PathVariable UUID userId) {
        return utenteService.findById(userId);
    }

    @PutMapping("/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Utente userUpdate(@PathVariable UUID userId, @RequestBody Utente body) {
        return utenteService.userUpdate(userId, body);
    }


    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority(ADMIN)")
    public void deleteUser(@PathVariable UUID userId) {
        utenteService.userDelete(userId);
    }


    @GetMapping("/me")
    public Utente profilePage(@AuthenticationPrincipal Utente utente) {
        return utente;
    }


    @PutMapping("/me")
    public Utente updateUser(@AuthenticationPrincipal Utente userId,@RequestBody Utente body){
        return utenteService.userUpdate(userId.getId(),body);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    public void cancellaUtente(@AuthenticationPrincipal Utente userId) {
        utenteService.userDelete(userId.getId());
    }

    @PatchMapping("/{userId}/upload")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String uploadAvatarImg(@RequestParam("image") MultipartFile file, @PathVariable UUID userId) throws Exception {
        return utenteService.uploadImage(file, userId);
    }
}
