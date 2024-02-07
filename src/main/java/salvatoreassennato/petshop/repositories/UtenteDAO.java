package salvatoreassennato.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salvatoreassennato.petshop.entities.Utente;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UtenteDAO extends JpaRepository<Utente, UUID> {
    Optional<Utente> findByEmail(String email);
    Optional<Utente> findBynome(String nome);
}
