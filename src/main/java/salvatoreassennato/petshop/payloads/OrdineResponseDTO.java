package salvatoreassennato.petshop.payloads;

import java.util.List;
import java.util.UUID;

public record OrdineResponseDTO(
        UUID idOrdine,
        List<ProdottoDTO> prodotti,
        double totaleDaPagare
) {
}
