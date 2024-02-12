package salvatoreassennato.petshop.payloads;

import java.util.List;
import java.util.UUID;

public record OrdineResponseDTO(
        UUID idOrdine,
        List<ProdottoDTO> prodotti,
        UUID idUtente,
        String nomeUtente,
        String cognomeUtente,
        String emailUtente,
        String indirizzo,
        double totaleDaPagare
) {
}
