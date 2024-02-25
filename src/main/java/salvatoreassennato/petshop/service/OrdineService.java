package salvatoreassennato.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.entities.Ordine;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.entities.Utente;
import salvatoreassennato.petshop.payloads.OrdineDTO;
import salvatoreassennato.petshop.repositories.OrdineDAO;
import salvatoreassennato.petshop.repositories.ProdottoDAO;
import salvatoreassennato.petshop.repositories.UtenteDAO;

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



    public Ordine creaOrdine(OrdineDTO ordineDTO, Utente utente) {
        List<Prodotto> prodottoList=new ArrayList<>();
        double totale=0.0;
        Utente found = utenteDAO.findById(utente.getId())
        .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + utente.getId()));
     for(UUID idProdotto: ordineDTO.listaProdotti()){
         Prodotto trovato=prodottoDAO.findById(idProdotto)
         .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + idProdotto));
         prodottoList.add(trovato);
          totale += trovato.getPrezzo();
         }
        Ordine ordine = new Ordine();
        ordine.setUtente(utente);
        ordine.setTotaleDaPagare(totale);
        ordine.setDettagliOrdine(prodottoList);
        return ordineDAO.save(ordine);
    }
    public List<Ordine> getOrdiniUtente(Utente utente) {
        return ordineDAO.findByUtente(utente);
    }
public Ordine findById(UUID id){
   return ordineDAO.findById(id).orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + id));
}

}



