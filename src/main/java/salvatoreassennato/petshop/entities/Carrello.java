package salvatoreassennato.petshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Carrello {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToMany(mappedBy = "carrello")
    private List<CarrelloProdotto> carrelloItemProdotti = new ArrayList<>();
    private LocalDateTime dataCreazione;
    private double totale;

}
