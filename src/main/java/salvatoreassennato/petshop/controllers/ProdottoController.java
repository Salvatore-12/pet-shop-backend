package salvatoreassennato.petshop.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.exceptions.BadRequestException;
import salvatoreassennato.petshop.payloads.ProdottoDTO;
import salvatoreassennato.petshop.service.ProdottoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {
    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    public void setProdottoService(ProdottoService prodottoService) {
        this.prodottoService = prodottoService;
    }
//1)VARI ENDPOINT PER I PRODOTTI PER IL GATTO
    //1)TIRAGRAFFI
    @GetMapping("/prodotti-gatto-tiragraffi")
    public List<Prodotto> getProdottiPerGattoETiragraffi() {
        return prodottoService.getProdottiPerGattoETiragraffi();
    }
    //2)CucciaELettino Gatto
    @GetMapping("/cuccie-lettini-gatto")
    public List<Prodotto> getProdottiPerGattoCuccie() {
        return prodottoService.getProdottiPerGattoCuccie();
    }

    //2)VARI ENDPOINT PER I PRODOTTI PER IL GATTO
    @GetMapping("/prodotti-cane-guinzagli")
    public List<Prodotto> getProdottiPerIlCaneEIlGuinzaglio() {
        return prodottoService.getProdottiPerCaneEGuinzaglio();
    }
    @GetMapping("/prodotti-ciotole")
    public List<Prodotto> getProdottiPerIlCaneCiotola() {
        return prodottoService.getProdottiPerCaneECiotole();
    }

    //3)VARI ENDPOINT PER I PRODOTTI PER IL GATTO
    @GetMapping("/prodotti-mangime-uccelli")
    public List<Prodotto> getProdottiPerUccelliConMangime() {
        return prodottoService.getProdottiPerUccelloMangime();
    }
    @GetMapping("/prodotti-gabbie-uccelli")
    public List<Prodotto> getProdottiPerUccelliConGabbie() {
        return prodottoService.getProdottiPerUccelloGabbie();
    }
    @GetMapping("/prodotti-by-nome")
    public List<Prodotto> getProdottiByNome(@RequestParam String nome) {
        return prodottoService.getProdottiByNome(nome);
    }
    @GetMapping("/prodotti-per-parte-del-nome")
    public List<Prodotto> getProdottiByParteDelNome(@RequestParam String parteDelNome) {
        return prodottoService.getProdottiByParteDelNome(parteDelNome);
    }
    @GetMapping("/prodotto_prezzo_min_max")
    public List<Prodotto> getProdottoFiltrato() {
        double prezzoMinimo = 20.00;
        double prezzoMassimo = 40.00;
        return prodottoService.getProdottoFiltratoPerPrezzo(prezzoMinimo, prezzoMassimo);
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prodotto saveProdotto(@RequestBody ProdottoDTO body, @PathVariable UUID id, BindingResult validation)
    {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }else {
            return prodottoService.save(body,id);
        }
    }

    @PutMapping("/{id}")
    public Prodotto updateProdotto(@ Valid @RequestBody ProdottoDTO body, @PathVariable UUID id, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return prodottoService.update(id, body);
        }
    }

    @PreAuthorize("hasAuthority('Admin')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProdotto(@PathVariable UUID id) {
        prodottoService.delete(id);
    }




}
