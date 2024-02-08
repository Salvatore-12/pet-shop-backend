package salvatoreassennato.petshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarrelloItemProdotti {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToMany
    @JoinColumn(name="prodotto_id")
    private List<Prodotto> prodotti= new ArrayList<>();
   @OneToOne
   @JoinColumn(name="ordine_id")
   private Ordine ordini;
   @ManyToOne
   @JoinColumn(name="utente_id")
   private Utente utente;
}
