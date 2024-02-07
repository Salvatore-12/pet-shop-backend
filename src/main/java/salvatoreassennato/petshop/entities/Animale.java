package salvatoreassennato.petshop.entities;

import jakarta.persistence.*;
import lombok.*;
import salvatoreassennato.petshop.Enum.Taglia;

import java.util.List;
import java.util.UUID;
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Animale {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    protected UUID id;
    protected String nome;
    protected String razza;
    protected double peso;
    @Enumerated(EnumType.STRING)
    protected Taglia taglia;
    @OneToMany(mappedBy ="animaleAssociato",cascade= CascadeType.ALL)
    protected List<Prodotto>prodottiAssociati;

}
