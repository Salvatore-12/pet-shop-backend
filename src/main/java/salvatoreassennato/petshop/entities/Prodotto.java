package salvatoreassennato.petshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.Enum.TipoAnimale;

import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"ordineList"})
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
    private String priceId;
    @JsonProperty("categoria")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @JsonProperty("tipoAnimale")
    @Enumerated(EnumType.STRING)
    private TipoAnimale tipoAnimale;
    @ManyToMany
    @JoinTable(name="ordine_prodotto",joinColumns = @JoinColumn(name="prodotto_id"),inverseJoinColumns = @JoinColumn(name="ordine_id"))
    private List<Ordine> ordineList;


    public Prodotto(String immagine, String nome, String descrizione, double prezzo, Categoria categoria, TipoAnimale tipoAnimale) {
        this.immagine = immagine;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.tipoAnimale = tipoAnimale;
    }

    public Prodotto(String immagine, String nome, String descrizione, double prezzo, String priceId, Categoria categoria, TipoAnimale tipoAnimale) {
        this.immagine = immagine;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.priceId = priceId;
        this.categoria = categoria;
        this.tipoAnimale = tipoAnimale;
    }
}
