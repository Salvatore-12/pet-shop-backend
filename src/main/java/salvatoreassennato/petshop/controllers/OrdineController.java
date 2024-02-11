package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.petshop.entities.Ordine;
import salvatoreassennato.petshop.payloads.OrdineDTO;
import salvatoreassennato.petshop.payloads.OrdineResponseDTO;
import salvatoreassennato.petshop.service.OrdineService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/ordine")
public class OrdineController {
    @Autowired
    private OrdineService ordineService;

    @PostMapping("/crea-ordine")
    public OrdineResponseDTO creaOrdine(@RequestBody OrdineDTO ordineDTO) {
        return ordineService.creaOrdine(ordineDTO);
    }
}
