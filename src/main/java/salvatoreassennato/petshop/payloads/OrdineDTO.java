package salvatoreassennato.petshop.payloads;

import salvatoreassennato.petshop.entities.CarrelloProdotto;

import java.util.List;
import java.util.UUID;

public record OrdineDTO(
        UUID idUtente,
        UUID idCarrello,
        String indirizzo,
        List<DettaglioOrdineDTO> dettagliOrdine


) {
    public OrdineDTO withIndirizzo(String indirizzo) {
        return new OrdineDTO(idUtente, idCarrello,indirizzo,dettagliOrdine);
    }
}
