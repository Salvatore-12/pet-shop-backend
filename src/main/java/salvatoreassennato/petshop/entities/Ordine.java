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
    private UUID idOrdine;
    @OneToOne(mappedBy="ordine")
    private CarrelloProdotto carrelloProdotti;
    private double totaleDaPagare;
    @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;
}
