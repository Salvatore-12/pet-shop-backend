package salvatoreassennato.petshop.payloads;

import java.util.UUID;

public record UtenteResponseDTO(
        UUID id ,
        String accessToken) {
}
