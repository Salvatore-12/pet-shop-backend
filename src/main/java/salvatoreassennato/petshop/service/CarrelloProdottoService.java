package salvatoreassennato.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.entities.CarrelloProdotto;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.exceptions.NotFoundException;
import salvatoreassennato.petshop.payloads.CarrelloProdottoDTO;
import salvatoreassennato.petshop.repositories.CarrelloProdottoDAO;
import salvatoreassennato.petshop.repositories.OrdineDAO;
import salvatoreassennato.petshop.repositories.ProdottoDAO;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CarrelloProdottoService {
    @Autowired
    private CarrelloProdottoDAO carrelloProdottoDAO;
    @Autowired
    private ProdottoDAO prodottoDAO;
    @Autowired
    private OrdineDAO ordineDAO;

    public Page<Prodotto> getProductCart(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return prodottoDAO.findAll(pageable);
    }

    public CarrelloProdotto findById(UUID id) {
        return carrelloProdottoDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public CarrelloProdotto save(UUID idProduct,UUID idOrder, CarrelloProdottoDTO body) {
        CarrelloProdotto newProductCart = new CarrelloProdotto();
        List<Prodotto> prodottoList= new ArrayList<>();
        prodottoList.add(prodottoDAO.findById(idProduct).orElseThrow(() -> new NotFoundException(idProduct)));
        newProductCart.setProdotti(prodottoList);
        newProductCart.setOrdine(ordineDAO.findById(idOrder).orElseThrow(() -> new NotFoundException(idOrder)));
        newProductCart.setDataCreazione(body.dataCreazione());
        return carrelloProdottoDAO.save(newProductCart);
    }
    public CarrelloProdotto findByIdAndUpdate(UUID id, CarrelloProdottoDTO body) {
        CarrelloProdotto found = this.findById(id);
        found.setDataCreazione(body.dataCreazione());
        return carrelloProdottoDAO.save(found);
    }

    public void findByIdAndDelete(UUID id) {
        CarrelloProdotto found = this.findById(id);
        carrelloProdottoDAO.delete(found);
    }


    public CarrelloProdotto createCarrelloProdotto() {
        CarrelloProdotto carrelloProdotto = new CarrelloProdotto();
        carrelloProdotto.setDataCreazione(LocalDateTime.now());
        return carrelloProdottoDAO.save(carrelloProdotto);
    }

    public CarrelloProdotto aggiungiProdottiACarrelloVuoto(UUID carrelloId, List<UUID> idProdotti) {
        // Recupero il carrello
        CarrelloProdotto carrello = carrelloProdottoDAO.findById(carrelloId)
                .orElseThrow(() -> new RuntimeException("Carrello non trovato con ID: " + carrelloId));

        // Verifico se il carrello è vuoto
        if (carrello.getProdotti() == null) {
            carrello.setProdotti(new ArrayList<>());
        }

        // Recupero i prodotti e aggiungo al carrello
        for (UUID idProdotto : idProdotti) {
            Prodotto prodotto = prodottoDAO.findById(idProdotto)
                    .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID: " + idProdotto));
            carrello.getProdotti().add(prodotto);
        }
        carrelloProdottoDAO.save(carrello);
        return carrello;
    }


}


