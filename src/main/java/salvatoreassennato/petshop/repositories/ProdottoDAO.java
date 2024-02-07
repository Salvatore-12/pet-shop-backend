package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.entities.Prodotto;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProdottoDAO extends JpaRepository<Prodotto,UUID> {
    List<Prodotto>findByAnimaleAssociatoIdAndCategoriaAndNomeContaining(UUID animaleId, Categoria categoria,String nome);
}
