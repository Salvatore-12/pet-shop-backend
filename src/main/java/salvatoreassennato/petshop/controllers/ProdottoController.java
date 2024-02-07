package salvatoreassennato.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.entities.Cane;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.exceptions.BadRequestException;
import salvatoreassennato.petshop.exceptions.NotFoundException;
import salvatoreassennato.petshop.payloads.ProdottoDTO;
import salvatoreassennato.petshop.repositories.CaneDAO;
import salvatoreassennato.petshop.service.ProdottoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private CaneDAO caneDAO;
    @PostMapping("/creaProdottoGiochiPerCane/{caneId}")
    public ResponseEntity<String> creaProdottoGiochiPerCane(@PathVariable UUID caneId) {
        Cane cane = caneDAO.findById(caneId)
                .orElseThrow(() -> new NotFoundException("Cane non trovato con ID: " + caneId));

        prodottoService.creaProdottiGiochiPerCane(cane);

        return ResponseEntity.ok("Prodotto giochi per cane creato con successo.");
    }

    // Altri metodi del controller per gestire altre operazioni sui prodotti


    @GetMapping("/cerca-per-animale")
    public List<Prodotto>getProdottiByAnimaleAndCategoriaAndNome(
            @RequestParam UUID animaleId,
            @RequestParam Categoria categoria,
            @RequestParam String nome
            ){
        return prodottoService.getProdottiByAnimaleAndCategoriaAndNome(animaleId, categoria, nome);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prodotto saveBill(@RequestBody ProdottoDTO body, @PathVariable UUID id, BindingResult validation)
    {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }else {
            return prodottoService.save(body,id);
        }
    }
}
