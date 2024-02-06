package salvatoreassennato.petshop.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Animali {
    protected String immagine;
    protected String nome;
    protected String descrizione;
    protected double prezzo;

}
