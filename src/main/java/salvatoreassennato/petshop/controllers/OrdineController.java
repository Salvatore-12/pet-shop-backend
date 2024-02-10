package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import salvatoreassennato.petshop.entities.Ordine;
import salvatoreassennato.petshop.service.OrdineService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/ordine")
public class OrdineController {
    @Autowired
    private OrdineService ordineService;

    @PostMapping("/crea-ordine")
    public Ordine creaOrdine(@RequestParam UUID idUtente, @RequestParam UUID idCarrello) {
        return ordineService.creaOrdine(idUtente, idCarrello);
    }
}
