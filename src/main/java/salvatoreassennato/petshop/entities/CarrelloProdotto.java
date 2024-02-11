package salvatoreassennato.petshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private UUID carrelloid;
    @OneToMany
    @JoinColumn(name="carrello_id")
    private List<Prodotto> prodotti= new ArrayList<>();
    private LocalDateTime dataCreazione;
    @OneToOne
    @JoinColumn(name = "ordine_id")
    private Ordine ordine;

}
