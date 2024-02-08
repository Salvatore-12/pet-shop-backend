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
//    @Query("SELECT m FROM Prodotto m WHERE m.tipoAnimale =: tipoAnimale")
//    Page<Prodotto> findByProdottoPerAnimale(Pageable pageable, @Param("tipoAnimale") TipoAnimale tipoAnimale);
//
//    @Query("SELECT p FROM Prodotto p WHERE p.categoria = 'Cibo_umido' AND p.tipoAnimale = 'Cane'")
//    List<Prodotto> findCiboUmidoForCane();
//
//    @Query("SELECT m FROM Prodotto m WHERE m.categoria =: categories")
//    Page<Prodotto> findByCategoriaAndAnimals(Pageable pageable, @Param("categoria") Categoria categoria);
}
