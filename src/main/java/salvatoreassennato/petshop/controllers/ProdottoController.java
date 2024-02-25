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
//    @Value("${SECRET_STRIPE_KEY}")
//    private String secretStripeKey;

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
    //3)GIOCHI PER GATTO
    @GetMapping("/giochi-gatto")
    public List<Prodotto> getProdottiPerGattoGiochi() {
        return prodottoService.getProdottiPerGattoGiochi();
    }
    //4)CROCCHETTE GATTO
    @GetMapping("/crocchette-gatto")
    public List<Prodotto> getProdottiPerGattoCrocchette() {
        return prodottoService.getProdottiPerGattoCrocchette();
    }
    //5)CIBO UMIDO GATTO
    @GetMapping("/cibo-umido-gatto")
    public List<Prodotto> getProdottiPerGattoCiboUmido() {
        return prodottoService.getProdottiPerGattoCiboUmido();
    }
    //6)CIOTOLE PER GATTO
    @GetMapping("/ciotole-gatto")
    public List<Prodotto> getProdottiPerGattoCiotole() {
        return prodottoService.getProdottiPerGattoCiotole();
    }

    //2)VARI ENDPOINT PER I PRODOTTI PER IL CANE
    @GetMapping("/prodotti-cane-guinzagli")
    public List<Prodotto> getProdottiPerIlCaneEIlGuinzaglio() {
        return prodottoService.getProdottiPerCaneEGuinzaglio();
    }
    @GetMapping("/ciotole_per-cane")
    public List<Prodotto> getProdottiPerIlCaneCiotola() {
        return prodottoService.getProdottiPerCaneECiotole();
    }
    @GetMapping("/crocchette_cane")
    public List<Prodotto> getProdottiPerIlCaneCrocchette() {
        return prodottoService.getProdottiPerCaneCrocchette();
    }
    @GetMapping("/cibo_umido-cane")
    public List<Prodotto> getProdottiPerIlCaneCiboUmido() {
        return prodottoService.getProdottiPerCaneCiboUmido();
    }
    @GetMapping("/giochi-per-cane")
    public List<Prodotto> getProdottiPerIlCaneGiochi() {
        return prodottoService.getProdottiPerCaneEGiochi();
    }
    @GetMapping("/cuccie-lettini-cane")
    public List<Prodotto> getProdottiPerIlCaneCuccieLettini() {
        return prodottoService.getProdottiPerCaneCuccieELettini();
    }
    @GetMapping("/abbigliamento-cane")
    public List<Prodotto> getProdottiPerIlCaneAbbigliamento() {
        return prodottoService.getProdottiPerCaneAbbigliamento();
    }

    //3)VARI ENDPOINT PER I PRODOTTI PER UCCELLO
    @GetMapping("/mangime-uccelli")
    public List<Prodotto> getProdottiPerUccelliConMangime() {
        return prodottoService.getProdottiPerUccelloMangime();
    }
    @GetMapping("/prodotti-gabbie-uccelli")
    public List<Prodotto> getProdottiPerUccelliConGabbie() {
        return prodottoService.getProdottiPerUccelloGabbie();
    }
    @GetMapping("/Accessori-gabbie-uccelli")
    public List<Prodotto> getProdottiPerUccelliAccessoriGabbie() {
        return prodottoService.getProdottiPerUccelloAccessoriPerGabbie();
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
    @GetMapping("/{id}")
    public ProdottoDTO getProdottoById(@PathVariable UUID id) {
        return prodottoService.getProdottoById(id);
    }

//    @PostMapping("/create-checkout-session")
//    public String createCheckoutSession(@RequestBody List<Map<String, Object>> cartItems, @RequestHeader("Authorization") String token) {
//        try {
//            // Stampa di debug per verificare il contenuto di cartItems
//            System.out.println("Contenuto del carrello: " + cartItems);
//
//            // Inizializza Stripe con la tua chiave segreta
//            Stripe.apiKey = secretStripeKey; // Sostituisci con la tua chiave segreta Stripe
//
//            // Creazione del body per la richiesta di creazione della sessione di checkout con Stripe
//            Map<String, Object> params = new HashMap<>();
//            params.put("payment_method_types", List.of("card"));
//            params.put("line_items", generateLineItems(cartItems)); // Genera gli oggetti line_items basati sul carrello
//
//            // Creazione della sessione di checkout con Stripe
//            Session session = Session.create(params);
//
//            // Ritorna l'ID della sessione di checkout appena creata
//            return session.getId();
//        } catch (StripeException e) {
//            // Gestione delle eccezioni Stripe
//            e.printStackTrace();
//            throw new RuntimeException("Errore nella creazione della sessione di checkout");
//        }
//    }
}
