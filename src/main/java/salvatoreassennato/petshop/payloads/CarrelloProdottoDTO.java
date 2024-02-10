package salvatoreassennato.petshop.payloads;

import java.time.LocalDateTime;

public record CarrelloProdottoDTO(
        LocalDateTime dataCreazione,
        double totale) {
}
