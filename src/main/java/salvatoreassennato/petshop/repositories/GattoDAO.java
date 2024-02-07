package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.entities.Gatto;

import java.util.UUID;

@Repository
public interface GattoDAO extends JpaRepository<Gatto, UUID> {
}
