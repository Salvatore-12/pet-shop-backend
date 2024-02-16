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
        //1) CREAZIONE PRODOTTI PER IL CANE
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

         //CIOTOLE PER CANE
        Prodotto prodottoCiotolaCane1= new Prodotto("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSgnSLkPtaKUGkXZ3rge5MPP9KsfcoOIiRfQS6vohQJvXppOfGrcwdRrYsZeqtpWUCM5izPCXuyXuuoW0CvoxhZObEourCvUAxL4F9ECtCBBQant6d-JQaXSp84Y37cbP9SS6X-vqrfBXk&usqp=CAc","Doppia ciotola per cani","bellissima doppia ciotola adattatta per i nostri amici a quattro zambe ",15.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfeNchlQODJvuK-3ftLFxyMeQrupUxZDftEg&usqp=CAU","CIOTOLA PER CANI IN ACCIAIO INOX","ciotola in acciaio inox per cani",8.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3fmFY4gsXHy7DejcCs1XFoA3guN0FX_tFdBO_5hE5ftFufHGYEIDGF35hfDzRhkKbpus&usqp=CAU","Ciotola da viaggio portatile per acqua e cibo per cani blu","Ciotola da viaggio portatile per acqua e cibo per i nostri amici a quattro zambe",16.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTM1Z_s_GL9MpupQMggIWbCN46lFJDNV00XHw&usqp=CAU","Ciotola per cane rossa","ciotala per cani rosa adatta per il nostro amico a quattro zambe",6.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShMyJFxo9bGacSXk8dQdaEvd3Nxiwk_hUoVQ&usqp=CAU","Ciotola per cane a forma di cuore rosa ","bellissima ciotola a forma  di cuore rosa adatto per il nostro amico a quattro zambe",4.99,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane6= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpk-hFv5eRalKfv5KkgPd2N98PAyXKlLbGSA&usqp=CAU","Ciotola “Osso” in Plastica Cane blue","ciotola a forma di osso blu adatta per il nostro amico a quattro zambe ",6.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
//          prodottoDAO.save(prodottoCiotolaCane1);
//          prodottoDAO.save(prodottoCiotolaCane2);
//          prodottoDAO.save(prodottoCiotolaCane3);
//          prodottoDAO.save(prodottoCiotolaCane4);
//          prodottoDAO.save(prodottoCiotolaCane5);
//          prodottoDAO.save(prodottoCiotolaCane6);
        // 2)CREAZIONE PRODOTTI GATTO
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

     //GIOCHI PER IL GATTO
     Prodotto GiocoPerIlGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvtR0qp7aC5bhzeD_m8PWHyDtY6NzqGSx3MwK1CK_Qob1xPm_lENaZaajsEpAQeqW6R-w&usqp=CAU","Tunnel Per Gatti","tunnel per gatti giocho ideale per il nostro amico peloso",34.99,Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_xVdLE9Ma_cfLfsltPZ_Apcu8zL85HspVjA&usqp=CAU","Gioco Per Gatti Topo Su Molla","topo su molla per gatti giocho ideale per il nostro amico peloso",9.00,Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYU_tg3dnJdSzbPFDXQcS5BMA1bPren1TixBeoAwKUxdAN3YWLrtxRn7VCx4KM9Rfz3Js&usqp=CAU","Gioco Con Pallina Per Gatti","gioco con pallina per gatti giocho ideale per il nostro amico peloso",7.00,Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRDJvUiOXpltcA6dV7QvOGuvgP3ByV0nLQUw&usqp=CAU","Gioco Per Gatti Topini Strisce 3 pz","gioco topini a strisce ideale per il nostro amico peloso",2.30,Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaJrNsiGVU6oKXqGBIjtDfAL0r68y8vAVtIQ&usqp=CAU","Campo giochi per gatto con graffiatoio e palline sonore - Triangulo","campo giochi ideale per il nostro amico peloso",19.99,Categoria.Giochi,TipoAnimale.Gatto);
//        prodottoDAO.save(GiocoPerIlGatto1);
//        prodottoDAO.save(GiocoPerIlGatto2);
//        prodottoDAO.save(GiocoPerIlGatto3);
//        prodottoDAO.save(GiocoPerIlGatto4);
//        prodottoDAO.save(GiocoPerIlGatto5);


       //3)PRODOTTI PER UCCELLI
        //GABBIE PER UCCELLO
        Prodotto prododottoGabbia1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdzFcQCyKsq2lQNztlujFPGhmSIq17LiT-kg&usqp=CAU","Gabbia Per Ucccelli","bellissima gabbia,perfetta canarini, cocorite e uccelli in genere",30.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEfxq9tRKdW-NnointpJp1AhDFwO6SsUlUvbbLWCIfqnZW_jH-K743AAwV1-9EkM8-Jfs&usqp=CAU","Gabbia Per Ucccelli","bellissima gabbia,perfetta canarini, cocorite e uccelli in genere",40.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8qflAu7ZkOoTMvTk0udEHV_APBr84qR0WKw&usqp=CAU","Gabbia Per Ucccelli","bellissima gabbia,perfetta canarini, cocorite e uccelli in genere",32.99,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLiTUOKfz6y4gJS1XOmhXtDflPnlBl7fI7fWe6OSz10UVwcYoXNedr621J9BtRkwm3IfA&usqp=CAU","Gabbia Per Ucccelli","bellissima gabbia,perfetta canarini, cocorite e uccelli in genere",35.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYuPiJHspa4I72Ysbm5GiGsFrMQxcSTT8IcA&usqp=CAU","Gabbia Per Ucccelli","bellissima gabbia,perfetta canarini, cocorite e uccelli in genere",23.99,Categoria.Gabbie,TipoAnimale.Uccello);
//         prodottoDAO.save(prododottoGabbia1);
//         prodottoDAO.save(prododottoGabbia2);
//         prodottoDAO.save(prododottoGabbia3);
//         prodottoDAO.save(prododottoGabbia4);
//         prodottoDAO.save(prododottoGabbia5);
        //MANGIMI PER UCCELLO
        Prodotto mangime1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaOEHWAoUq33ziWp5tVl57bw-yqxn0V55VwkH18--XXLh00Y9rwDmDTTlc7gEwrMeiDQU&usqp=CAU","Mangime per uccelli carduelidi manitoba gr. 800","Mangime per uccelli carduelidi ",7.50,Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLKb-KGziVtLxsTUDL0EwskkuMXd-9KU2pGQ&usqp=CAU","Wellness Mix Per Canarini Kg.1 Padovan","Mangime per  canerini da 1kg",6.40,Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVqxcA3Cnv6oBiZP0mbAlq-Cv6R5ha3ADkKg&usqp=CAU","Versele Laga Prestige Mangime composto per canarini uccelli 1Kg","Mangime per  canerini da 1kg",3.00,Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMzXqAELx1NQBgCLdt8_cHJGZ9h2zjKhGqbA&usqp=CAU","Elevage - Canarios Mix per Canarini 2,5 kg","mangime Canarios Mix per Canarini da 2,5 kg",8.00,Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfmPCw68R3ZC32yGy2BcX3DWvn-1VVSVnn8A&usqp=CAU","Mangime Bonus Per Canarini","mangimi per canarini da 1kg",3.20,Categoria.Mangime,TipoAnimale.Uccello);
//          prodottoDAO.save(mangime1);
//          prodottoDAO.save(mangime2);
//          prodottoDAO.save(mangime3);
//          prodottoDAO.save(mangime4);
//          prodottoDAO.save(mangime5);














    }
}
