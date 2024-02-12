package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.entities.Ordine;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrdineDAO extends JpaRepository<Ordine, UUID> {
    Optional<Ordine> findById(UUID id);
}
