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
public class CarrelloProdotto {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "carrello_id")
    private Carrello carrello;
    @OneToMany
    @JoinColumn(name="carrello_item_id")
    private List<Prodotto> prodotti= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "ordine_id")
    private Ordine ordine;


}
