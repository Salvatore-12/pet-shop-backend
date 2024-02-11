package salvatoreassennato.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.entities.CarrelloProdotto;
import salvatoreassennato.petshop.entities.Ordine;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.payloads.DettaglioOrdineDTO;
import salvatoreassennato.petshop.payloads.OrdineDTO;
import salvatoreassennato.petshop.payloads.OrdineResponseDTO;
import salvatoreassennato.petshop.payloads.ProdottoDTO;
import salvatoreassennato.petshop.repositories.CarrelloProdottoDAO;
import salvatoreassennato.petshop.repositories.OrdineDAO;
import salvatoreassennato.petshop.repositories.ProdottoDAO;
import salvatoreassennato.petshop.repositories.UtenteDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrdineService {
    @Autowired
    private OrdineDAO ordineDAO;

    @Autowired
    private UtenteDAO utenteDAO;

    @Autowired
    private ProdottoDAO prodottoDAO;

    @Autowired
    private CarrelloProdottoDAO carrelloProdottoDAO;

    public OrdineResponseDTO creaOrdine(OrdineDTO ordineDTO) {
        // Recupero l'utente dal DB
        Utente utente = utenteDAO.findById(ordineDTO.idUtente())
                .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + ordineDTO.idUtente()));
        // Recupero il carrello dal DB
        CarrelloProdotto carrello = carrelloProdottoDAO.findById(ordineDTO.idCarrello())
                .orElseThrow(() -> new RuntimeException("Carrello non trovato con ID: " + ordineDTO.idCarrello()));
        // Calcolo il totale dell'ordine basato sui prodotti nel carrello
        double totaleDaPagare = calcolaTotale(ordineDTO.dettagliOrdine());
        Ordine ordine = new Ordine();
        ordine.setUtente(utente);
        ordine.setCarrelloProdotti(carrello);
        ordine.setTotaleDaPagare(totaleDaPagare);
        ordine = ordineDAO.save(ordine);
        List<ProdottoDTO> dettagliProdotti = retrieveDettagliProdotti(ordineDTO);
        return new OrdineResponseDTO(
                ordine.getIdOrdine(), // Utilizza getIdOrdine() invece di getId()
                dettagliProdotti, // Aggiungi qui i dettagli dei prodotti
                utente.getId(),
                utente.getNome(),
                utente.getCognome(),
                utente.getEmail(),
                totaleDaPagare
        );
    }
    //Con questo metodo recupero i dettagli dei prodotti associati a un ordine,
    //a partire dai dettagli presenti nell'oggetto OrdineDTO
    private List<ProdottoDTO> retrieveDettagliProdotti(OrdineDTO ordineDTO) {
        List<ProdottoDTO> dettagliProdotti = new ArrayList<>();
        for (DettaglioOrdineDTO dettaglio : ordineDTO.dettagliOrdine()) {
            Prodotto prodotto = prodottoDAO.findById(dettaglio.idProdotto())
                    .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID: " + dettaglio.idProdotto()));
            dettagliProdotti.add(new ProdottoDTO(
                    prodotto.getIdProdotto(),
                    prodotto.getImmagine(),
                    prodotto.getNome(),
                    prodotto.getDescrizione(),
                    prodotto.getPrezzo(),
                    prodotto.getCategoria(),
                    prodotto.getTipoAnimale()
            ));
        }
        return dettagliProdotti;
    }

    private double calcolaTotale(List<DettaglioOrdineDTO> dettagliOrdine) {
        if (dettagliOrdine == null) {
            return 0.0;
        }
        return dettagliOrdine.stream()
                .mapToDouble(dettaglio -> {
                    // mi calcolo il prezzo del prodotto moltiplicato per la quantità
                    // ed mi sommo i totali di tutti i dettagli
                    return dettaglio.quantità() * retrievePrezzoProdotto(dettaglio.idProdotto());
                })
                .sum();
    }

    private double retrievePrezzoProdotto(UUID idProdotto) {
        Prodotto prodotto = prodottoDAO.findById(idProdotto)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID: " + idProdotto));
        // mi  Restituisce il prezzo di un prodotto recuperato dal DB
        return prodotto.getPrezzo();
    }
}

