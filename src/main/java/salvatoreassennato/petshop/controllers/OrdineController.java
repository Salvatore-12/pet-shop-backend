package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.petshop.entities.Ordine;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.payloads.OrdineDTO;
import salvatoreassennato.petshop.service.OrdineService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ordine")
public class OrdineController {
    @Autowired
    private OrdineService ordineService;
    @PostMapping("/crea-ordine")
    public Ordine creaOrdine(@RequestBody OrdineDTO ordineDTO, @AuthenticationPrincipal Utente utente) {
        return ordineService.creaOrdine(ordineDTO,utente);
    }
    @GetMapping("/utente")
    public List<Ordine> getOrdiniUtente(@AuthenticationPrincipal Utente utente) {
        return ordineService.getOrdiniUtente(utente);
    }
    @GetMapping("/{id}")
    public Ordine findById(@PathVariable UUID id ){
        return ordineService.findById(id);
    }
}
