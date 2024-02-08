package salvatoreassennato.petshop.entities;

import jakarta.persistence.*;
import lombok.*;

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
    private UUID id;
    @OneToOne
    @JoinColumn(name="carrello_id")
    private CarrelloItemProdotti CarrelloItemProdotti;
    private double pagamento;
}
