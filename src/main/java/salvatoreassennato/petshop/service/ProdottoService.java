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

    public ProdottoDTO getProdottoById(UUID id) {
        Prodotto prodotto = prodottoDAO.findById(id)
                .orElseThrow(() -> new NotFoundException("Prodotto non trovato con ID: " + id));
        return new ProdottoDTO(
                prodotto.getIdProdotto(),
                prodotto.getImmagine(),
                prodotto.getNome(),
                prodotto.getDescrizione(),
                prodotto.getPrezzo(),
                prodotto.getCategoria(),
                prodotto.getTipoAnimale()
        );
    }


    public Prodotto update(UUID id, ProdottoDTO body) {
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


    public void delete(UUID id) {
        prodottoDAO.deleteById(id);
    }
//query che mi ritorna tutti i prodotti del gatto in particolare solo i tirigraffi

    //1)SEZIONE QUERY PER  IL GATTO
    public List<Prodotto> getProdottiPerGattoETiragraffi() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Tiragraffi, TipoAnimale.Gatto);
    }
    public List<Prodotto> getProdottiPerGattoGiochi() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Giochi, TipoAnimale.Gatto);
    }
    public List<Prodotto> getProdottiPerGattoCrocchette() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Crocchette, TipoAnimale.Gatto);
    }
    public List<Prodotto> getProdottiPerGattoCiboUmido() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Cibo_umido, TipoAnimale.Gatto);
}
    public List<Prodotto> getProdottiPerGattoCiotole() {
    return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.CiotoleEDistributori, TipoAnimale.Gatto);
}
    public List<Prodotto> getProdottiPerGattoCuccie() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.CuccieELettini, TipoAnimale.Gatto);
    }

    //2)SEZIONE QUERY PER IL CANE
    public List<Prodotto> getProdottiPerCaneEGuinzaglio() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Guinzaglio, TipoAnimale.Cane);
    }
    public List<Prodotto> getProdottiPerCaneECiotole() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.CiotoleEDistributori, TipoAnimale.Cane);
    }
    public List<Prodotto> getProdottiPerCaneCiboUmido() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Cibo_umido, TipoAnimale.Cane);
    }
    public List<Prodotto> getProdottiPerCaneCrocchette() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Crocchette, TipoAnimale.Cane);
    }
    public List<Prodotto> getProdottiPerCaneAbbigliamento() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Abbigliamento_cane, TipoAnimale.Cane);
    }
    public List<Prodotto> getProdottiPerCaneEGiochi() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Giochi, TipoAnimale.Cane);
    }
    public List<Prodotto> getProdottiPerCaneCuccieELettini() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.CuccieELettini, TipoAnimale.Cane);
    }

    //3)SEZIONE QUERY PER L'UCCELLO
    public List<Prodotto> getProdottiPerUccelloMangime() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Mangime, TipoAnimale.Uccello);
    }
    public List<Prodotto> getProdottiPerUccelloGabbie() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.Gabbie, TipoAnimale.Uccello);
    }
    public List<Prodotto> getProdottiPerUccelloAccessoriPerGabbie() {
        return prodottoDAO.findByCategoriaAndTipoAnimale(Categoria.AccessoriPerGabbie, TipoAnimale.Uccello);
    }

    //4)QUERY GENERALI
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
