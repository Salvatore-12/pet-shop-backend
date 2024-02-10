package salvatoreassennato.petshop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("idProdotto")
    private UUID idProdotto;
    @JsonProperty("immagine")
    private String immagine;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("descrizione")
    private String descrizione;
    @JsonProperty("prezzo")
    private double prezzo;
    @JsonProperty("categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @JsonProperty("tipoAnimale")
    @Enumerated(EnumType.STRING)
    private TipoAnimale tipoAnimale;

    public Prodotto(String immagine, String nome, String descrizione, double prezzo, Categoria categoria, TipoAnimale tipoAnimale) {
        this.immagine = immagine;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.tipoAnimale = tipoAnimale;
    }
}
