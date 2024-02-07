package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.entities.Uccello;

import java.util.UUID;

@Repository
public interface UccelloDAO extends JpaRepository<Uccello, UUID> {
}
