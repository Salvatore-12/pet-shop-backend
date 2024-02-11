package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.petshop.entities.CarrelloProdotto;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.service.CarrelloProdottoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrello")
public class CarrelloProdottoController {
    @Autowired
    private CarrelloProdottoService carrelloProdottoService;

    @PostMapping("/crea")
    public CarrelloProdotto creaCarrello() {
        return carrelloProdottoService.createCarrelloProdotto();
    }


    @PostMapping("/{carrelloId}/aggiungi-prodotti")
    public CarrelloProdotto aggiungiProdottiACarrello(@PathVariable UUID carrelloId, @RequestBody List<UUID> idProdotti) {
    return carrelloProdottoService.aggiungiProdottiACarrelloVuoto(carrelloId,idProdotti);
    }
}
