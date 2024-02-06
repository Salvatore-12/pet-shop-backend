package salvatoreassennato.petshop.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prodotti {
    private String immagine;
    private String nome;
    private String descrizione;
    private double prezzo;
    private Categoria categoria;
}
