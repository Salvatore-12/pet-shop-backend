package salvatoreassennato.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.entities.CarrelloProdotto;
import salvatoreassennato.petshop.entities.Ordine;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.repositories.CarrelloProdottoDAO;
import salvatoreassennato.petshop.repositories.OrdineDAO;
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
    private CarrelloProdottoDAO carrelloProdottoDAO;

    public Ordine creaOrdine(UUID idUtente, UUID idCarrello) {
        // RecuperO l'utente dal DB
        Utente utente = utenteDAO.findById(idUtente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + idUtente));

        // Recupero il carrello dal DB
        CarrelloProdotto carrello = carrelloProdottoDAO.findById(idCarrello)
                .orElseThrow(() -> new RuntimeException("Carrello non trovato con ID: " + idCarrello));

        // Calcola il totale dell'ordine basato sui prodotti nel carrello
        double totale = calcolaTotale(carrello);

        // Creo un nuovo oggetto Ordine e imposta i campi
        Ordine ordine = new Ordine();
        ordine.setUtente(utente);
        ordine.setCarrelloProdotti(carrello);
        ordine.setPagamento(totale);

        // Salva l'ordine nel DB
        return ordineDAO.save(ordine);
    }

    private double calcolaTotale(CarrelloProdotto carrello) {

        return carrello.getProdotti().stream()
                .mapToDouble(Prodotto::getPrezzo)
                .sum();
    }
}

