package salvatoreassennato.petshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.Enum.TipoAnimale;
import salvatoreassennato.petshop.entities.Prodotto;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProdottoDAO extends JpaRepository<Prodotto,UUID> {

    List<Prodotto> findByCategoriaAndTipoAnimale(Categoria categoria, TipoAnimale tipoAnimale);
    List<Prodotto> findByNome(String nome);
    List<Prodotto> findByNomeContaining(String parteDelNome);
}
