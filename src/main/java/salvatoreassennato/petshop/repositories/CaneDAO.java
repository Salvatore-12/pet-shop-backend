package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.entities.Cane;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CaneDAO extends JpaRepository<Cane, UUID> {
    Optional<Cane>findById(UUID caneid);
}
