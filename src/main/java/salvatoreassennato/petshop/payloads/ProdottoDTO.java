package salvatoreassennato.petshop.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import salvatoreassennato.petshop.Enum.Categoria;

public record ProdottoDTO(
        @NotEmpty(message="inserisci il nome")
        String nome,
        @NotEmpty(message="inserisci la descrizione")
        String descrizione,
        @NotNull(message="inserisci il prezzo")
        double prezzo,
        @NotEmpty(message="metti la categoria")
        Categoria categoria) {
}
