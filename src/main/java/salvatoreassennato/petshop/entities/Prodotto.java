package salvatoreassennato.petshop.entities;

import jakarta.persistence.*;
import lombok.*;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.Enum.TipoAnimale;

import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prodotto {
    @Id
    @GeneratedValue
    private UUID id;
    private String immagine;
    private String nome;
    private String descrizione;
    private double prezzo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private TipoAnimale tipoAnimale;



}
