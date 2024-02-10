package salvatoreassennato.petshop.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.Enum.TipoAnimale;

public record ProdottoDTO(
        String immagine,
        @NotEmpty(message="inserisci il nome")
        String nome,
        @NotEmpty(message="inserisci la descrizione")
        String descrizione,
        @NotNull(message="inserisci il prezzo")
        double prezzo,
        @NotEmpty(message="metti la categoria")
        Categoria categoria,
        TipoAnimale tipoAnimale) {




}
