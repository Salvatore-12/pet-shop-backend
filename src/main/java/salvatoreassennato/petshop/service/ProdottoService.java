package salvatoreassennato.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.Enum.TipoAnimale;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.exceptions.NotFoundException;
import salvatoreassennato.petshop.payloads.ProdottoDTO;
import salvatoreassennato.petshop.repositories.ProdottoDAO;

import java.util.List;
import java.util.UUID;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoDAO prodottoDAO;


    public Page<Prodotto> getBill(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return prodottoDAO.findAll(pageable);
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
