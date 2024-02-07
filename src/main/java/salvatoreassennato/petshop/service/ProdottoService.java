package salvatoreassennato.petshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.entities.Cane;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.payloads.ProdottoDTO;
import salvatoreassennato.petshop.repositories.CaneDAO;
import salvatoreassennato.petshop.repositories.ProdottoDAO;

import java.util.List;
import java.util.UUID;

@Service
public class ProdottoService {
    @Autowired
    private ProdottoDAO prodottoDAO;
    @Autowired
    private CaneDAO caneDAO;

    public Prodotto save(ProdottoDTO body, UUID id) {
        Prodotto newProdotto= new Prodotto();
        newProdotto.setNome(body.nome());
        newProdotto.setDescrizione(body.descrizione());
        newProdotto.setPrezzo(body.prezzo());
        return prodottoDAO.save(newProdotto);
    }

    public List<Prodotto>getProdottiByAnimaleAndCategoriaAndNome(UUID animaleId, Categoria categoria,String nome){
        return prodottoDAO.findByAnimaleAssociatoIdAndCategoriaAndNomeContaining(animaleId, categoria, nome);
    }
    public void creaProdottiGiochiPerCane(Cane cane){
        Prodotto prodottoGiochi=new Prodotto();
        prodottoGiochi.setNome("pallina da giochi per cane");
        prodottoGiochi.setDescrizione("pallina resistente per giocare con il cane");
        prodottoGiochi.setImmagine(null);
        prodottoGiochi.setPrezzo(8.99);
        prodottoGiochi.setCategoria(Categoria.Giochi);
        prodottoDAO.save(prodottoGiochi);

    }

}
