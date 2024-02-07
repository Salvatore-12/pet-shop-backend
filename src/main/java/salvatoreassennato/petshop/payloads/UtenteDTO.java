package salvatoreassennato.petshop.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UtenteDTO(@NotEmpty(message="nome obbligatorio!")
                        @Size(min=4,max=25,message="il nome deve essere almeno di 4 caratteri e non più di 25!")
                        String nome,
                        @NotEmpty(message="cognome obbligatorio!")
                        @Size(min=4,max=25,message="il cognome deve essere almeno di 4 caratteri e non più di 25!")
                        String cognome,
                        @Email(message="questo indirizzo email non è valido!")
                        @NotEmpty(message="campo email obbligatorio!")
                        String email,
                        @NotEmpty(message = "la password è obbligatorio!")
                         @Size(min=4,max=25,message="la password deve avere un minimo di 4 carateri e un massino 25!")
                        String password) {
}
