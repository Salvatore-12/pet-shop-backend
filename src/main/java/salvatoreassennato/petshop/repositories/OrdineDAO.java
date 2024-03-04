package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.entities.Ordine;
import salvatoreassennato.petshop.entities.Utente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrdineDAO extends JpaRepository<Ordine, UUID> {
    Optional<Ordine> findById(UUID id);
    List<Ordine> findByUtente(Utente utente);
}
