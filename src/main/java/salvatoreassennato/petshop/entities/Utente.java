package salvatoreassennato.petshop.entities;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utente {
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String avatar;
    private Ruolo ruolo;

}
