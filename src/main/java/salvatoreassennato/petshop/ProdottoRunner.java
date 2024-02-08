package salvatoreassennato.petshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import salvatoreassennato.petshop.Enum.Categoria;
import salvatoreassennato.petshop.Enum.TipoAnimale;
import salvatoreassennato.petshop.entities.Prodotto;
import salvatoreassennato.petshop.repositories.ProdottoDAO;
import salvatoreassennato.petshop.service.ProdottoService;

import java.util.Scanner;

@Component
@Order(1)
public class ProdottoRunner implements CommandLineRunner {
    @Autowired
    private ProdottoService prodottoService;
    @Autowired
    private ProdottoDAO prodottoDAO;
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean errors = false;
        do {
            System.out.println("Vuoi Procedere Con la Creazione dei prodotti? (y/n)");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y" -> {
                    createProdotti();
                    errors = false;
                    System.out.println("prodotti creati con successo!");
                }
                case "n" -> errors = false;
                default -> {
                    System.out.println("Input non valido. Riprova.");
                    errors = true;
                }
            }
        } while (errors);

    }
    public void createProdotti(){
        Prodotto prodottoPerIlCane1=new Prodotto("https://t4.ftcdn.net/jpg/03/11/83/15/240_F_311831538_MRrgoonVcgLuqjyeGHJqKmpUCk1iA7OM.jpg","guinzaglio nero in pelle","comodo guinzaglio per il nosro amico a quattro zampe",10.00, Categoria.Guinzaglio, TipoAnimale.Cane);
        prodottoDAO.save(prodottoPerIlCane1);



    }
}
