package salvatoreassennato.petshop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DettaglioOrdine {
    @Id
    @GeneratedValue
    private UUID idDettaglio;
    @ManyToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;
    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;
    private int quantità;

    public DettaglioOrdine(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantità = quantita;
    }
}
