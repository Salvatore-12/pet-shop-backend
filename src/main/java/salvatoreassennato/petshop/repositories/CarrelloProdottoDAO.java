package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.entities.CarrelloProdotto;

import java.util.UUID;

@Repository
public interface CarrelloProdottoDAO extends JpaRepository<CarrelloProdotto,UUID> {
}
