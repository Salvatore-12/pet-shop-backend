package salvatoreassennato.petshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ordine {
    @Id
    @GeneratedValue
    private UUID idOrdine;
    private double totaleDaPagare;
    @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;
    @ManyToMany
    @JoinTable(name="ordine_prodotto",joinColumns = @JoinColumn(name="ordine_id"),inverseJoinColumns = @JoinColumn(name="prodotto_id"))
    private List<Prodotto> dettagliOrdine;

}
