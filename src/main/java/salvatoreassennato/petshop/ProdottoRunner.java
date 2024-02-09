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
        //CREAZIONE PRODOTTI PER IL CANE
          //PRODOTTI GUINZAGLI PER IL CANE
        Prodotto prodottoPerIlCane1=new Prodotto("https://t4.ftcdn.net/jpg/03/11/83/15/240_F_311831538_MRrgoonVcgLuqjyeGHJqKmpUCk1iA7OM.jpg","guinzaglio nero in pelle","comodo guinzaglio per il nostro amico a quattro zampe",10.00, Categoria.Guinzaglio, TipoAnimale.Cane);
        Prodotto prodottoPerIlCane2=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdJyhvfSVSJ-dtyXD3ONty_MMwIlmHomzGWw&usqp=CAU","guinzaglio blu in nylon","comodo guinzaglio per il nostro amico a quattro zampe",8.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane3=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2vH-QY2ap16bhHN5fHB3qaznzFJU29sWr-w&usqp=CAU","guinzaglio rosso in nylon","comodo guinzaglio per il nostro amico a quattro zampe",5.99,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane4=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWq6yhJzVQkXOG-880RldCBTeV85TKDnLOUg&usqp=CAU","guinzaglio verde in nylon","comodo guinzaglio per il nostro amico a quattro zampe",15.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane5=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrp_VHxuQClLopH4TMbPxvYDKDXubsLklusQ&usqp=CAU","guinzaglio fucsia in pelle","comodo guinzaglio per il nostro amico a quattro zampe",12.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane6=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6cogZCG-F0gV7Vf8-emgG-C_wcvULGjc_hA&usqp=CAU","guinzaglio rosa in pelle","comodo guinzaglio per il nostro amico a quattro zampe",11.99,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane7=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCvyhrLQSRhAI6MfpIkcPw4X_bCaRQJ4GBZg&usqp=CAU","guinzaglio marrone in cuoio","comodo guinzaglio per il nostro amico a quattro zampe",20.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane8=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMBSztqvMa83qeuXMdSNp4p7o5MGz3OfwtHA&usqp=CAU","guinzaglio lilla in nylon","comodo guinzaglio per il nostro amico a quattro zampe",10.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane9=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVX7afG0VXM1sUylhdZt5Yt8V-X2uVT1tSqw&usqp=CAU","guinzaglio viola in nylon","comodo guinzaglio per il nostro amico a quattro zampe",11.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane10=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHlzqVAdMaN5G7JZqxsoTvkNzMCh3-DYkuiQ&usqp=CAU","guinzaglio giallo in nylon","comodo guinzaglio per il nostro amico a quattro zampe",6.99,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane11=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGGOmzra8_oB6hpTiX_mVH99zb1XsS7yXjkULAv-HlmdOHnLdtDHX7QYG06Kf48tSghwE&usqp=CAU","guinzaglio azzurro in nylon","comodo guinzaglio per il nostro amico a quattro zampe",5.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane12=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjt_TAwazGrCKHJWNyGhi6FS0CVWbe2Y52-A&usqp=CAU","guinzaglio turchese in nylon","comodo guinzaglio per il nostro amico a quattro zampe",8.00,Categoria.Guinzaglio,TipoAnimale.Cane);
//        prodottoDAO.save(prodottoPerIlCane1);
//        prodottoDAO.save(prodottoPerIlCane2);
//        prodottoDAO.save(prodottoPerIlCane3);
//        prodottoDAO.save(prodottoPerIlCane4);
//        prodottoDAO.save(prodottoPerIlCane5);
//        prodottoDAO.save(prodottoPerIlCane6);
//        prodottoDAO.save(prodottoPerIlCane6);
//        prodottoDAO.save(prodottoPerIlCane7);
//        prodottoDAO.save(prodottoPerIlCane8);
//        prodottoDAO.save(prodottoPerIlCane9);
//        prodottoDAO.save(prodottoPerIlCane10);
//        prodottoDAO.save(prodottoPerIlCane11);
//        prodottoDAO.save(prodottoPerIlCane12);

        //CREAZIONE PRODOTTI GATTO
          //TIRAGRAFFIO PER IL GATTO
        Prodotto prodottoPerIlGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQdW9Kyi9BTdle2QwDldXUr2QqESSnEowh_w&usqp=CAU","Tiragraffi grigio","comodo tiragraffi per il nostro amico gattino",50.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRO4l3rYnpiz7Zo2M6m8Jb4JsXLKpgZxgG1w&usqp=CAU","Tiragraffi ad albero beige ","comodo tiragraffi ad albero per il nostro amico gattino",48.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyED00V-7rFWvFONW86TtFJENaASAUH5gvpw&usqp=CAU","Tiragraffi a forma di L","comodo tiragraffi a forma di L per il nostro amico gattino 68cm",35.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIOlD7Bcm_il52BFy5i5xt3ihhCKGnADbG9w&usqp=CAU","Tiragraffi a castello","comodo tiragraffi  a castello per il nostro amico gattino",130.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxtP2KXB3mX5ltEBnkrE44C-ba6sKw3tgb8Q&usqp=CAU","Tiragraffi a castello grigio ","comodo tiragraffi  a castello per il nostro amico gattino",60.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto6= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1PraeD8UU0gcM77j3zBABP63tGsdg7NRPKpNrnxp4aTt0KBXW_fRr2JG2x0wx0GguALY&usqp=CAU","Tiragraffi di lino ","comodo tiragraffi di lino per il nostro amico gattino",13.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto7= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7Lzt3X1JJnyHQqqZD38PwoQGUT8wnUY6J57i9OF6YliGqDEETNHBSdrNYfiYNsdmE81s&usqp=CAU","Tiragraffi con giochi e tunnel","comodo tiragraffi per il nostro amico gattino",40.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto8= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRdnyY-9GavfQQdsgp7bSxTvn-f8Rs2HGvQAg&usqp=CAU","tappetino tira Tiragraffi beige","comodo tappetino tiragraffi per il nostro amico gattino",30.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto9= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3L5WbOcwWy8cs0AcjpyMMappTmDzJKNzvPg&usqp=CAU","Tiragraffi ad albero  grigio chiaro","comodo tiragraffi ad albero multper il nostro amico gattino",55.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto10= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7g5OiS0JHQvh_mUNUr3_c1P9sCNPS0gDLRg&usqp=CAU","Tiragraffi in legno","comodo tiragraffi di legno per il nostro amico gattino",119.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
//        prodottoDAO.save(prodottoPerIlGatto1);
//        prodottoDAO.save(prodottoPerIlGatto2);
//        prodottoDAO.save(prodottoPerIlGatto3);
//        prodottoDAO.save(prodottoPerIlGatto4);
//        prodottoDAO.save(prodottoPerIlGatto5);
//        prodottoDAO.save(prodottoPerIlGatto6);
//        prodottoDAO.save(prodottoPerIlGatto7);
//        prodottoDAO.save(prodottoPerIlGatto8);
//        prodottoDAO.save(prodottoPerIlGatto9);
//        prodottoDAO.save(prodottoPerIlGatto10);

        //CUCCIE E LETTINI PER IL GATTO
        Prodotto prodottoCucciaGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT_-lMTpI3JvxmF0Jlko61ivMgFCbTiz16LYS4jkJYLcPwEb9qQfASLTkdD2MuXtFb65Q&usqp=CAU","Cuccia per Gatti Da Casa","comoda cuccia per il nostro gattino",20.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoCucciaGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2fL7Vzb055-y1vGkotZz6kZEEAVWrvGlPCiYqQ42znj5pncyE3UPzYG5jJZW5kRwYpKA&usqp=CAU","Cuccia Per Gatti Con Morbido Cuscino Interno","comoda cuccia per il gatto con cuscino",64.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoCucciaGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShn65Wo08oz3I26VTw93eS0QD9d7VxMo9Y6w&usqp=CAU","Cuccia Per Gatto A Forma Di Rana","comoda cuccia per il gatto",20.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoCucciaGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSxfi-PznHbi0LzsG98wCUENd8TUZMxVx_rA&usqp=CAU","Cuccia In Legno Con Balconcino per gatti","comoda cuccia in legno per il gatto",90.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoLettinoGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMoJJZE_Ta8EBEkCROknzHo0PwSz4iJg0-7A&usqp=CAU","Lettino Per Gatto","comodo lettino per gatto",58.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoLettinoGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTnF7dHK9PuhFXldZ5GXYHgvfDOonXZkza_Q&usqp=CAU","Lettino Per Gatto Con Cusino In Peluche","comodo lettino per gatto con cusino",50.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
//       prodottoDAO.save(prodottoCucciaGatto1);
//       prodottoDAO.save(prodottoCucciaGatto2);
//       prodottoDAO.save(prodottoCucciaGatto3);
//       prodottoDAO.save(prodottoCucciaGatto4);
//       prodottoDAO.save(prodottoLettinoGatto1);
//       prodottoDAO.save(prodottoLettinoGatto2);











    }
}
