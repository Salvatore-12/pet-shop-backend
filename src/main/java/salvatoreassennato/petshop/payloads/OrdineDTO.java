package salvatoreassennato.petshop.payloads;

import salvatoreassennato.petshop.entities.CarrelloProdotto;

import java.util.List;
import java.util.UUID;

public record OrdineDTO(
        UUID idUtente,
        UUID idCarrello,
        List<DettaglioOrdineDTO> dettagliOrdine

) {
}
