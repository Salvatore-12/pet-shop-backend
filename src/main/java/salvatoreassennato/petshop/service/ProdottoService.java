package salvatoreassennato.petshop.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.Enum.TipoAnimale;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.exceptions.NotFoundException;
import salvatoreassennato.petshop.payloads.ProdottoDTO;
import salvatoreassennato.petshop.repositories.ProdottoDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProdottoService {
    private static final Logger logger = LoggerFactory.getLogger(ProdottoService.class);
    @Autowired
    private ProdottoDAO prodottoDAO;


//    public Page<Prodotto> getProdotto(int page, int size, String orderBy) {
//        if (size >= 100) size = 100;
//        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
//        return prodottoDAO.findAll(pageable);
//
//    }

    public Page<Prodotto> aggiungiProdotto(Page<Prodotto> paginaProdotti, Prodotto prodotto) {
        List<Prodotto> prodotti = new ArrayList<>(paginaProdotti.getContent());
        prodotti.add(prodotto);
        return new PageImpl<>(prodotti, paginaProdotti.getPageable(), paginaProdotti.getTotalElements());
    }

    public Prodotto findById(UUID id) {
        return prodottoDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Prodotto save(ProdottoDTO body, UUID id) {
        Prodotto newprodotto = new Prodotto();
        newprodotto.setImmagine(body.immagine());
        newprodotto.setNome(body.nome());
        newprodotto.setDescrizione(body.descrizione());
        newprodotto.setPrezzo(body.prezzo());
        newprodotto.setCategoria(body.categoria());
        newprodotto.setTipoAnimale(body.tipoAnimale());
        logger.info("Salvataggio del prodotto nel database: {}", newprodotto);
        return prodottoDAO.save(newprodotto);


    }


    public Prodotto findByIdAndUpdate(UUID id, ProdottoDTO body) {
        Prodotto found = this.findById(id);
        found.setImmagine(body.immagine());
        found.setNome(body.nome());
        found.setDescrizione(body.descrizione());
        found.setPrezzo(body.prezzo());
        found.setCategoria(body.categoria());
        found.setTipoAnimale(body.tipoAnimale());
        return prodottoDAO.save(found);
    }

    public void findByIdAndDelete(UUID id) {
        Prodotto found = this.findById(id);
        prodottoDAO.delete(found);
    }

    public Prodotto update(ProdottoDTO body, UUID id) {
        return prodottoDAO.findByIdAndUpdate(id, body);
    }

    public void delete(UUID id) {
        prodottoDAO.findByIdAndDelete(id);
    }
//query che mi ritorna tutti i prodotti del gatto in particolare solo i tirigraffi
    public List<Prodotto> getProdottiPerGattoETiragraffi() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Tiragraffi, TipoAnimale.Gatto);
    }
    //query che mi ritorna tutti i prodotti del cane in particolare solo i guinzagli
    public List<Prodotto> getProdottiPerCaneEGuinzaglio() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Guinzaglio, TipoAnimale.Cane);
    }
    public List<Prodotto> getProdottiByNome(String nome) {
        return prodottoDAO.findByNome(nome);
    }
    public List<Prodotto> getProdottiByParteDelNome(String parteDelNome) {
        return prodottoDAO.findByNomeContaining(parteDelNome);
    }
    public List<Prodotto> getProdottoFiltratoPerPrezzo(double prezzoMinimo,double prezzoMassimo) {
        return prodottoDAO.findByPrezzoBetween(prezzoMinimo,prezzoMassimo);
    }


}
