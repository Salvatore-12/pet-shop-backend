package salvatoreassennato.petshop.payloads;

import java.util.UUID;

public record DettaglioOrdineDTO(
         UUID idProdotto,
         int quantità
) {
}
