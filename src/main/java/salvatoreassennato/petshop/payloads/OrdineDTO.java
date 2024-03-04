package salvatoreassennato.petshop.payloads;



import java.util.List;
import java.util.UUID;

public record OrdineDTO(
        List<UUID> listaProdotti


) {

}
