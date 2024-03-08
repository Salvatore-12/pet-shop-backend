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
            System.out.println("Vuoi procedere con la creazione dei vari prodotti? (y/n)");
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
        Prodotto prodottoPerIlCane1=new Prodotto("https://bellobau.com/cdn/shop/products/guinzaglio-nero-piatto_08.jpg?v=1642527774&width=2048","guinzaglio nero in pelle","comodo guinzaglio per il nostro amico a quattro zampe",10.00,"price_1OmveTC3pyi397sl1IUBMH7D", Categoria.Guinzaglio, TipoAnimale.Cane);
        Prodotto prodottoPerIlCane2=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdJyhvfSVSJ-dtyXD3ONty_MMwIlmHomzGWw&usqp=CAU","guinzaglio blu in nylon","comodo guinzaglio per il nostro amico a quattro zampe",8.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane3=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_RgLDs6sLHL69fqmLmrY2aZgFeKjM3bhftQ&usqp=CAU","guinzaglio rosso in nylon","comodo guinzaglio per il nostro amico a quattro zampe",5.99,"price_1OoM8HC3pyi397slql542GYi",Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane4=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3_2X5EdgNRoks0QiKnJ7qZlVVhxpwv9WxEg&usqp=CAU","guinzaglio verde in nylon","comodo guinzaglio per il nostro amico a quattro zampe",15.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane5=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrp_VHxuQClLopH4TMbPxvYDKDXubsLklusQ&usqp=CAU","guinzaglio fucsia in pelle","comodo guinzaglio per il nostro amico a quattro zampe",12.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane6=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6cogZCG-F0gV7Vf8-emgG-C_wcvULGjc_hA&usqp=CAU","guinzaglio rosa in pelle","comodo guinzaglio per il nostro amico a quattro zampe",11.99,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane7=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-S8T9-jvK4KlEPtpIvJQ8qzgdLIE3va3b8Q&usqp=CAU","guinzaglio marrone in cuoio","comodo guinzaglio per il nostro amico a quattro zampe",20.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane8=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMBSztqvMa83qeuXMdSNp4p7o5MGz3OfwtHA&usqp=CAU","guinzaglio lilla in nylon","comodo guinzaglio per il nostro amico a quattro zampe",10.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane9=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVX7afG0VXM1sUylhdZt5Yt8V-X2uVT1tSqw&usqp=CAU","guinzaglio viola in nylon","comodo guinzaglio per il nostro amico a quattro zampe",11.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane10=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHlzqVAdMaN5G7JZqxsoTvkNzMCh3-DYkuiQ&usqp=CAU","guinzaglio giallo in nylon","comodo guinzaglio per il nostro amico a quattro zampe",6.99,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane11=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGGOmzra8_oB6hpTiX_mVH99zb1XsS7yXjkULAv-HlmdOHnLdtDHX7QYG06Kf48tSghwE&usqp=CAU","guinzaglio azzurro in nylon","comodo guinzaglio per il nostro amico a quattro zampe",5.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        Prodotto prodottoPerIlCane12=new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjt_TAwazGrCKHJWNyGhi6FS0CVWbe2Y52-A&usqp=CAU","guinzaglio turchese in nylon","comodo guinzaglio per il nostro amico a quattro zampe",8.00,Categoria.Guinzaglio,TipoAnimale.Cane);
        prodottoDAO.save(prodottoPerIlCane1);
        prodottoDAO.save(prodottoPerIlCane2);
        prodottoDAO.save(prodottoPerIlCane3);
        prodottoDAO.save(prodottoPerIlCane4);
        prodottoDAO.save(prodottoPerIlCane5);
        prodottoDAO.save(prodottoPerIlCane6);
        prodottoDAO.save(prodottoPerIlCane6);
        prodottoDAO.save(prodottoPerIlCane7);
        prodottoDAO.save(prodottoPerIlCane8);
        prodottoDAO.save(prodottoPerIlCane9);
        prodottoDAO.save(prodottoPerIlCane10);
        prodottoDAO.save(prodottoPerIlCane11);
        prodottoDAO.save(prodottoPerIlCane12);

         //CIOTOLE PER CANE
        Prodotto prodottoCiotolaCane1= new Prodotto("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSgnSLkPtaKUGkXZ3rge5MPP9KsfcoOIiRfQS6vohQJvXppOfGrcwdRrYsZeqtpWUCM5izPCXuyXuuoW0CvoxhZObEourCvUAxL4F9ECtCBBQant6d-JQaXSp84Y37cbP9SS6X-vqrfBXk&usqp=CAc","Doppia ciotola per cani","bellissima doppia ciotola adattatta per i nostri amici a quattro zambe ",15.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfeNchlQODJvuK-3ftLFxyMeQrupUxZDftEg&usqp=CAU","CIOTOLA PER CANI IN ACCIAIO INOX","ciotola in acciaio inox per cani",8.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3fmFY4gsXHy7DejcCs1XFoA3guN0FX_tFdBO_5hE5ftFufHGYEIDGF35hfDzRhkKbpus&usqp=CAU","Ciotola da viaggio portatile per acqua e cibo per cani blu","Ciotola da viaggio portatile per acqua e cibo per i nostri amici a quattro zambe",16.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTM1Z_s_GL9MpupQMggIWbCN46lFJDNV00XHw&usqp=CAU","Ciotola per cane rossa","ciotala per cani rosa adatta per il nostro amico a quattro zambe",6.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShMyJFxo9bGacSXk8dQdaEvd3Nxiwk_hUoVQ&usqp=CAU","Ciotola per cane a forma di cuore rosa ","bellissima ciotola a forma  di cuore rosa adatto per il nostro amico a quattro zambe",4.99,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
        Prodotto prodottoCiotolaCane6= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpk-hFv5eRalKfv5KkgPd2N98PAyXKlLbGSA&usqp=CAU","Ciotola “Osso” in Plastica Cane blue","ciotola a forma di osso blu adatta per il nostro amico a quattro zambe ",6.00,Categoria.CiotoleEDistributori,TipoAnimale.Cane);
          prodottoDAO.save(prodottoCiotolaCane1);
          prodottoDAO.save(prodottoCiotolaCane2);
          prodottoDAO.save(prodottoCiotolaCane3);
          prodottoDAO.save(prodottoCiotolaCane4);
          prodottoDAO.save(prodottoCiotolaCane5);
          prodottoDAO.save(prodottoCiotolaCane6);

        //CROCCHETTE CANE
     Prodotto crocchetteCane1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2SVHBNf4Cea2neVBlUZqNhBMCqFGnwPt_3Q&usqp=CAU","Gemon All Breeds Crocchette Cane Adult con Agnello e Riso 15kg","crocchette per il cane",32.00,Categoria.Crocchette,TipoAnimale.Cane);
     Prodotto crocchetteCane2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9RtAmRpXF5hkak0vztkHMr7Bqx4H_yfaLhA&usqp=CAU","ROYAL CANIN CROCCHETTE CANE MINI PUPPY 800GR","crocchette per il cane",7.50,Categoria.Crocchette,TipoAnimale.Cane);
     Prodotto crocchetteCane3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_Lt6og2_JbUlK7wYvUCfqAAhiq-94E_9B6idnGEJK5R3C3ByMjS0hMTCfL50uqc4HbCA&usqp=CAU","FRISKIES CROCCHETTE CANE JUNIOR POLLO-VERDURE KG.1,5","crocchette per il cane",10.00,Categoria.Crocchette,TipoAnimale.Cane);
     Prodotto crocchetteCane4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQducbt6QXF640GRW3MYdn3uXN523Um6XIum11yRWGvoH4MTqP9Gs31QMpeDqvpLhiv2Yc&usqp=CAU","CROCCHETTE CANE FRISKIES KG.1,5 COMPLETE BALANCE POLLO VERDURE","crocchette per il cane",6.15,Categoria.Crocchette,TipoAnimale.Cane);
     Prodotto crocchetteCane5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMmb4sDbAvR_Dyg7B5SQm6LIXG6LBOIkfYGQ&usqp=CAU","CROCCHETTE SEMI UMIDE PER CANE CON MANZO, CAROTE E CEREALI 1,5 KG - FROLIC","crocchette per il cane",11.50,Categoria.Crocchette,TipoAnimale.Cane);
        prodottoDAO.save(crocchetteCane1);
        prodottoDAO.save(crocchetteCane2);
        prodottoDAO.save(crocchetteCane3);
        prodottoDAO.save(crocchetteCane4);
        prodottoDAO.save(crocchetteCane5);

        //CIBO UMIDO CANE
        Prodotto ciboUmidoCane1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBUMJjhsSn4tk_Guf5PtujLS16XId3JSo1tg&usqp=CAU","Marpet Equilibria cane cibo umido salmone 400gr","cibo umido salmone  per cani",2.50,Categoria.Cibo_umido,TipoAnimale.Cane);
        Prodotto ciboUmidoCane2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZk7hUpBOZMuEeahqGypqxlALB1B5OLMdEnA&usqp=CAU","Pedigree BISCROK Multi mix biscotti cane 200gr","cibo umido BISCROK biscotti per cani ",1.50,Categoria.Cibo_umido,TipoAnimale.Cane);
        Prodotto ciboUmidoCane3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV1DyJz4Zj3FzxvqBDm09Br9uQ32hyPiNq4g&usqp=CAU","Pura Natura pollo mele ed erbe officinali cibo umido per cani","cibo umido  pollo mele ed erbe officinali per cani ",1.80,Categoria.Cibo_umido,TipoAnimale.Cane);
        Prodotto ciboUmidoCane4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz2karhaJquK51H-htIiMXJzg5IRGQNTEFkacLmzk1v6dH-VAiXchs_0emYcgmGzpiuYE&usqp=CAU","Cibo Umido per Cani Natural Trainer Manzo 400 gr","cibo umido manzo per cani",3.50,Categoria.Cibo_umido,TipoAnimale.Cane);
        prodottoDAO.save(ciboUmidoCane1);
        prodottoDAO.save(ciboUmidoCane2);
        prodottoDAO.save(ciboUmidoCane3);
        prodottoDAO.save(ciboUmidoCane4);

        //GIOCHI CANE
        Prodotto GiochiCane1 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWqEGOW-AwygB0vht3j_38tXqqVzFG-9VwUVpEGYQxxiHMXGqV5nlHVB1XsNFFXvtZh_s&usqp=CAU","gioco per Cani KONG Squeezz Goomz a Forma di Pallina con Punte con Squeak Taglia XL","gioco pallina Squeak per cani",20.00,Categoria.Giochi,TipoAnimale.Cane);
        Prodotto GiochiCane2 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3Ae4xWraD3_kiY_G6XrB5j5YaV9gLuL50NQ&usqp=CAU","Pollo Gioco in Lattice per Cani","gioco pollo per cani",8.00,Categoria.Giochi,TipoAnimale.Cane);
        Prodotto GiochiCane3 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTHcpTVRU5Bu-gBfTFTkDS8qYwrYb-_CI6uKA&usqp=CAU","Gioco Osso Vinile Puppy Gioco Per Cani","gioco osso per cani",4.00,Categoria.Giochi,TipoAnimale.Cane);
        Prodotto GiochiCane4 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRs1x7z6rG-Wuzgn_o4wLvgRopGYnDqGypfA&usqp=CAU","Zolux Peluche di Ippopotamo/Rana/Giraffa Giochi per Cani da 23 cm","gioco prodotto da Zolux peluche per cani",7.30,Categoria.Giochi,TipoAnimale.Cane);
        Prodotto GiochiCane5 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYPYRwpuhAN45qsGiRnQU6U_XwmnQ8OfO8UsIpB2dghK_Iqdx8xwWIuXWHR5o4mfwmE-I&usqp=CAU","Peluche Imac a Forma Di Dinosauro Con Cresta In Plastica Cm 37 X 23","Gioco da cane a forma di dinosauro color arancione.",10.00,Categoria.Giochi,TipoAnimale.Cane);
        prodottoDAO.save(GiochiCane1);
        prodottoDAO.save(GiochiCane2);
        prodottoDAO.save(GiochiCane3);
        prodottoDAO.save(GiochiCane4);
        prodottoDAO.save(GiochiCane5);

        //CUCCIE CANE
        Prodotto CuccieCane1 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTit49BTWZT_-8bKM4Xw1OzRm19WFvCCn3eFA&usqp=CAU","Cadoca Cuccia da Esterno per Cani XXL Legno Massello Tetto Apribile 82cmx72cmx85cm","cuccia in legno per cani ",136.00,"price_1OoSJhC3pyi397slL7uMOyhO",Categoria.CuccieELettini,TipoAnimale.Cane);
        Prodotto CuccieCane2 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgmuO4BHg122aQV46DXNgByMFWgjBTJf3-Rg&usqp=CAU","Cuccia per cane Bobby - Cottage Douce","cuccia per cani a forma di piramide",36.99,Categoria.CuccieELettini,TipoAnimale.Cane);
        Prodotto CuccieCane3 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPqh4_BwAt5srsImOxQXUY6dc0Q-47P4DgvA&usqp=CAU","Cuccia Per Cani 4-Season","cuccia per cani adatta per tutte le stagioni essendo realizzate in termoisolate",326.00,Categoria.CuccieELettini,TipoAnimale.Cane);
        Prodotto CuccieCane4 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2k0Zc_0g4ZHgChe76g4kRtC-gdM-9tE946A&usqp=CAU","Cuccia In Ecopelle VENEZIA – Media","cuccia in ecopelle per cani",150.00,Categoria.CuccieELettini,TipoAnimale.Cane);
        Prodotto CuccieCane5 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTH-G5RMIGfQHfNy1DIWDahaauputnN--V9-h45BmbxnmeRgI-xCCUBEoyBd-NF8GUoId4&usqp=CAU","Cuccia per cane in peluche, cuscino morbido, marrone e beige","Cuccia in peluche con cuscino morbido per cani",82.00,Categoria.CuccieELettini,TipoAnimale.Cane);
         prodottoDAO.save(CuccieCane1);
         prodottoDAO.save(CuccieCane2);
         prodottoDAO.save(CuccieCane3);
         prodottoDAO.save(CuccieCane4);
         prodottoDAO.save(CuccieCane5);
       //ABBIGLIAMENTO CANE
      Prodotto AbbigliamentoCane1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeskZqVuL27u5NDU9S5BI5z560gUZ_yhzkig&usqp=CAU","Cappotto Antipioggia Per Cani Eleganti E Di Alta Qualità Giallo ", "cappotto per cani giallo",25.00,"price_1OoSoNC3pyi397slBsVS2WAa",Categoria.Abbigliamento_cane,TipoAnimale.Cane);
      Prodotto AbbigliamentoCane2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhlcGIBhiNfTJjzAYGc_qT_QqQqEY0p6lNETI0SEOYWVH85IAzAcLMAI_F_O3PcpDrgU4&usqp=CAU","  Maglione Grigio Per Cani", "caldo maglio per cani ",20.00,Categoria.Abbigliamento_cane,TipoAnimale.Cane);
      Prodotto AbbigliamentoCane3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5c3BEM4J8eSY5DC0WgYeJN8d1CdI95x8gfA&usqp=CAU ","Dolcevita Rosso Lavorazione Maglia Per Cani ", "dolcevita rossa per cani",20.00,Categoria.Abbigliamento_cane,TipoAnimale.Cane);
      prodottoDAO.save(AbbigliamentoCane1);
      prodottoDAO.save(AbbigliamentoCane2);
      prodottoDAO.save(AbbigliamentoCane3);






        // 2)CREAZIONE PRODOTTI GATTO
           //TIRAGRAFFIO PER IL GATTO
        Prodotto prodottoPerIlGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSapJHDWAO4FqZrT4j52phUboGzUJGgnrSNQw&usqp=CAU","Tiragraffi grigio ad albero","comodo tiragraffi per il nostro amico gattino",50.00,"price_1OmxFtC3pyi397sluUrlSbOc",Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRO4l3rYnpiz7Zo2M6m8Jb4JsXLKpgZxgG1w&usqp=CAU","Tiragraffi ad albero beige ","comodo tiragraffi ad albero per il nostro amico gattino",48.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZqkC-2N6FWyMPpWX19Xmaf2FJ0tXPw0YjKw&usqp=CAU","Tiragraffi a forma di L","comodo tiragraffi a forma di L per il nostro amico gattino 68cm",35.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLdPjvaUMNdd2NitUWSs_419EuLIZxR-Aamw&usqp=CAU","Tiragraffi a castello","comodo tiragraffi  a castello per il nostro amico gattino",130.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxtP2KXB3mX5ltEBnkrE44C-ba6sKw3tgb8Q&usqp=CAU","Tiragraffi a castello grigio ","comodo tiragraffi  a castello per il nostro amico gattino",60.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto6= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1PraeD8UU0gcM77j3zBABP63tGsdg7NRPKpNrnxp4aTt0KBXW_fRr2JG2x0wx0GguALY&usqp=CAU","Tiragraffi di lino ","comodo tiragraffi di lino per il nostro amico gattino",13.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto7= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7Lzt3X1JJnyHQqqZD38PwoQGUT8wnUY6J57i9OF6YliGqDEETNHBSdrNYfiYNsdmE81s&usqp=CAU","Tiragraffi con giochi e tunnel","comodo tiragraffi per il nostro amico gattino",40.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        Prodotto prodottoPerIlGatto8= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3L5WbOcwWy8cs0AcjpyMMappTmDzJKNzvPg&usqp=CAU","Tiragraffi ad albero  grigio chiaro","comodo tiragraffi ad albero multper il nostro amico gattino",55.00,Categoria.Tiragraffi,TipoAnimale.Gatto);
        prodottoDAO.save(prodottoPerIlGatto1);
        prodottoDAO.save(prodottoPerIlGatto2);
        prodottoDAO.save(prodottoPerIlGatto3);
        prodottoDAO.save(prodottoPerIlGatto4);
        prodottoDAO.save(prodottoPerIlGatto5);
        prodottoDAO.save(prodottoPerIlGatto6);
        prodottoDAO.save(prodottoPerIlGatto7);
        prodottoDAO.save(prodottoPerIlGatto8);



        //CUCCIE E LETTINI PER IL GATTO
        Prodotto prodottoCucciaGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT_-lMTpI3JvxmF0Jlko61ivMgFCbTiz16LYS4jkJYLcPwEb9qQfASLTkdD2MuXtFb65Q&usqp=CAU","Cuccia per Gatti Da Casa","comoda cuccia per il nostro gattino",20.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoCucciaGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZOdKWIyJ1axJZEaa7ok28lOMTo6g1ThrtLw&usqp=CAU","Cuccia Per Gatti Con Morbido Cuscino Interno","comoda cuccia per il gatto con cuscino",64.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoCucciaGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShn65Wo08oz3I26VTw93eS0QD9d7VxMo9Y6w&usqp=CAU","Cuccia Per Gatto A Forma Di Rana","comoda cuccia per il gatto",20.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoCucciaGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRv1N2xn6Y4Q51SlWUkFgLtnZQAjAi9xVpLw&usqp=CAU","Cuccia In Legno per gatti","comoda cuccia in legno per il gatto",140.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoLettinoGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMoJJZE_Ta8EBEkCROknzHo0PwSz4iJg0-7A&usqp=CAU","Lettino Per Gatto","comodo lettino per gatto",58.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
        Prodotto prodottoLettinoGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTnF7dHK9PuhFXldZ5GXYHgvfDOonXZkza_Q&usqp=CAU","Lettino Per Gatto Con Cusino In Peluche","comodo lettino per gatto con cusino",50.00,Categoria.CuccieELettini,TipoAnimale.Gatto);
       prodottoDAO.save(prodottoCucciaGatto1);
       prodottoDAO.save(prodottoCucciaGatto2);
       prodottoDAO.save(prodottoCucciaGatto3);
       prodottoDAO.save(prodottoCucciaGatto4);
       prodottoDAO.save(prodottoLettinoGatto1);
       prodottoDAO.save(prodottoLettinoGatto2);

        //GIOCHI PER IL GATTO
     Prodotto GiocoPerIlGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjvldkLYPIr1l7xtgdgyQp9Vm0Aok4HdJcjg&usqp=CAU","Tunnel Per Gatti","tunnel per gatti gioco ideale per il nostro amico peloso",34.99,"price_1OoSDxC3pyi397slk0JYTRtl",Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_xVdLE9Ma_cfLfsltPZ_Apcu8zL85HspVjA&usqp=CAU","Gioco Per Gatti Topo Su Molla","topo su molla per gatti gioco ideale per il nostro amico peloso",9.00,Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYU_tg3dnJdSzbPFDXQcS5BMA1bPren1TixBeoAwKUxdAN3YWLrtxRn7VCx4KM9Rfz3Js&usqp=CAU","Gioco Con Pallina Per Gatti","gioco con pallina per gatti giocho ideale per il nostro amico peloso",7.00,Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRDJvUiOXpltcA6dV7QvOGuvgP3ByV0nLQUw&usqp=CAU","Gioco Per Gatti Topini Strisce 3 pz","gioco topini a strisce ideale per il nostro amico peloso",2.30,Categoria.Giochi,TipoAnimale.Gatto);
     Prodotto GiocoPerIlGatto5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaJrNsiGVU6oKXqGBIjtDfAL0r68y8vAVtIQ&usqp=CAU","Campo giochi per gatto con graffiatoio e palline sonore - Triangulo","campo giochi ideale per il nostro amico peloso",19.99,Categoria.Giochi,TipoAnimale.Gatto);
        prodottoDAO.save(GiocoPerIlGatto1);
        prodottoDAO.save(GiocoPerIlGatto2);
        prodottoDAO.save(GiocoPerIlGatto3);
        prodottoDAO.save(GiocoPerIlGatto4);
        prodottoDAO.save(GiocoPerIlGatto5);

        //CIOTOLE PER IL GATTO
      Prodotto CiotolaGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNEWVg647ga0rq7aMF9M6kJRoKJ7yF208Jbw&usqp=CAU","CIOTOLA PER GATTI IN CERAMICA CON SUPPORTO IN LEGNO","ciotola in ceramica per gatto",10.00,Categoria.CiotoleEDistributori,TipoAnimale.Gatto);
      Prodotto CiotolaGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDndgF-mga04S7jmSZXuFa8YB0Ztwf2_i-ug&usqp=CAU","CIOTOLA Doppia PER GATTI ","bellissima ciotola doppia per gatto",44.00,Categoria.CiotoleEDistributori,TipoAnimale.Gatto);
      Prodotto CiotolaGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvzAPYBSjhsybT_XT-X1E_BYkgsrhkf9wZOw&usqp=CAU","Ciotola per Gatto in Plastica Bianca","ciotola in plastica per gatto",5.00,Categoria.CiotoleEDistributori,TipoAnimale.Gatto);
      Prodotto CiotolaGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQzwcH8uM6DmhboJwqNdiMw8pAfF7LIopLp3Q&usqp=CAU","Ciotola per Gatto  Rosa","bellissima ciotola per gatto rosa",8.00,Categoria.CiotoleEDistributori,TipoAnimale.Gatto);
      Prodotto CiotolaGatto5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSav0RsrDuLOnUOwQl4m3yWPOQLvsMbSLsMLw&usqp=CAU","Ciotola per Gatto in Plastica Blu Fiore","bellissima ciotola in plastica blu per gatto ",4.00,Categoria.CiotoleEDistributori,TipoAnimale.Gatto);
        prodottoDAO.save(CiotolaGatto1);
        prodottoDAO.save(CiotolaGatto2);
        prodottoDAO.save(CiotolaGatto3);
        prodottoDAO.save(CiotolaGatto4);
        prodottoDAO.save(CiotolaGatto5);

      //CROCCHETTE PER GATTO
     Prodotto CrocchetteGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBDYmOTY1v2ciYWeES7jS8IPXNviPYY7wM5vEMCbNbKARj_ngbvJz1qlz2mEDbVhtan0c&usqp=CAU","Crocchette Senza Cereali per Gatti Adulti Sensibili","crocchette per gatti",4.99,Categoria.Crocchette,TipoAnimale.Gatto);
     Prodotto CrocchetteGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReAjMAWEeqRvZA51K3krSE1FCjrQ3tccudwg&usqp=CAU","Crocchette Per Gatti Royal Canin Feline Mother And Babycat Gattini 400 Grammi","crocchette per gatti",7.90,Categoria.Crocchette,TipoAnimale.Gatto);
     Prodotto CrocchetteGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-FLFXeGVikd9Jc9g4h-cU5VbpfWKDWgXbGUXJgbMZg5jg0B4NHVvhxLyIs17hqS_cyIw&usqp=CAU","Crocchette per gatti pollo 2 kg","crocchette per gatti",4.00,Categoria.Crocchette,TipoAnimale.Gatto);
     Prodotto CrocchetteGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBNsCjT1t1rK-jTfh_8ta7bYL9XPxn2dJGlw&usqp=CAU","PURINAONE STERILCAT CROCCHETTE PER GATTO MANZO E FRUMENTO GR.800","crocchette per gatti",4.70,Categoria.Crocchette,TipoAnimale.Gatto);
     Prodotto CrocchetteGatto5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVG4KMmKXDuQEsJHNaM5TdPtILE0FxfBmAUA&usqp=CAU","Friskies Adult Crocchette Per Il Gatto, Con Coniglio, Pollo E Verdure Aggiunte, 2 Kg","crocchette per gatti ",9.90,Categoria.Crocchette,TipoAnimale.Gatto);
         prodottoDAO.save(CrocchetteGatto1);
         prodottoDAO.save(CrocchetteGatto2);
         prodottoDAO.save(CrocchetteGatto3);
         prodottoDAO.save(CrocchetteGatto4);
         prodottoDAO.save(CrocchetteGatto5);

        //CIBO UMIDO PER GATTO
        Prodotto CiboUmidoGatto1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHpKeazdOic8NAEsk1Svm5EKue3I8SAIflzQ&usqp=CAU","Bustine cibo umido gatto in gelatina – Vibrisse Kitten Busta Jelly 70g","cibo umido per gatto",1.20,Categoria.Cibo_umido,TipoAnimale.Gatto);
        Prodotto CiboUmidoGatto2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIfYYxkjxSQl5UJHATYob4y4r8yWrMnu8qPQ&usqp=CAU","Cibo Umido al Pesce e Pollo per Gatti","cibo umido per gatto",2.30,Categoria.Cibo_umido,TipoAnimale.Gatto);
        Prodotto CiboUmidoGatto3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPFTz57tac8YekQKrzgYF70kc0ufgkOoQAQQ&usqp=CAU","HILL'S - Prescription Diet I/D Digestive Care - Cibo Umido Per Gatti 82 G","cibo umido per gatto",1.30,Categoria.Cibo_umido,TipoAnimale.Gatto);
        Prodotto CiboUmidoGatto4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHD-Q1MlPcu66312IcGTl90_4YHS-ELlq3rQ&usqp=CAU","Gourmet mon petit, cibo umido per gatti, vari gusti, 6x50 gr","cibo umido per gatto",2.70,Categoria.Cibo_umido,TipoAnimale.Gatto);
        Prodotto CiboUmidoGatto5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSi3AZI8Pl44vHoOg-Np4JQZTtLosoIObTe8jLYU2UDs79ajULd4s3cOTMDFlRdKkieFvI&usqp=CAU","Leonardo Ricco di Pesce di Mare Cibo Umido per Gatti","cibo umido per gatto",2.00,Categoria.Cibo_umido,TipoAnimale.Gatto);
            prodottoDAO.save(CiboUmidoGatto1);
            prodottoDAO.save(CiboUmidoGatto2);
            prodottoDAO.save(CiboUmidoGatto3);
            prodottoDAO.save(CiboUmidoGatto4);
            prodottoDAO.save(CiboUmidoGatto5);



        //3)PRODOTTI PER UCCELLI

        //GABBIE PER UCCELLO
        Prodotto prododottoGabbia1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShNfY_JkldbgEeo7uYsjcdNoRWJPOSnRBclmzrr6z379D4y58X_BuvnP8pKKZHNEQWyaY&usqp=CAU","Gabbia Per Ucccelli Rossa","bellissima gabbia rossa,perfetta canarini, cocorite e uccelli in genere",30.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpUlnBi-okFR5kSqWXuGzLoM0ya_-O7Y_UUA&usqp=CAU","Gabbia Per Ucccelli Grigia","bellissima gabbia grigia,perfetta canarini, cocorite e uccelli in genere",40.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4m9rIgXc6_KZkFQ2163QJIfygO1ZBNCa_iQ&usqp=CAU","Imac Gabbia Sonia Blu/Bianco","bellissima gabbia blu/bianco,perfetta per canarini, cocorite e uccelli in genere",50.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLiTUOKfz6y4gJS1XOmhXtDflPnlBl7fI7fWe6OSz10UVwcYoXNedr621J9BtRkwm3IfA&usqp=CAU","Gabbia Per Ucccelli Blu","bellissima gabbia blu,perfetta per canarini, cocorite e uccelli in genere",35.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYuPiJHspa4I72Ysbm5GiGsFrMQxcSTT8IcA&usqp=CAU","Gabbia Per Ucccelli Gialla","bellissima gabbia gialla,perfetta per canarini, cocorite e uccelli in genere",23.99,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia6= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTu7Z6DvQsp0qi8WhtiOQJ3LivvRVZyAWlsFw&usqp=CAU","Gabbia Bergamo Arquivet. Gabbia Per Uccelli","bellissima gabbia bergamo arquivet,perfetta per canarini, cocorite e uccelli in genere",30.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia7= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4sewYSmin6LSpTXyetfFVkRrM78eq2BvKiQ&usqp=CAU","Gabbia Per Uccelli In Acciaio Con Posatoi, Vassoio Rimovibile E Maniglia,","bellissima gabbia in acciaio,perfetta per canarini, cocorite e uccelli in genere",32.00,Categoria.Gabbie,TipoAnimale.Uccello);
        Prodotto prododottoGabbia8= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSc30WA9eVll-JEmIdlhkkzBMpQShLbp53yKw&usqp=CAU","Gabbia Per Ucccelli Grigia","bellissima gabbia grigia,perfetta per canarini, cocorite e uccelli in genere",60.00,Categoria.Gabbie,TipoAnimale.Uccello);
         prodottoDAO.save(prododottoGabbia1);
         prodottoDAO.save(prododottoGabbia2);
         prodottoDAO.save(prododottoGabbia3);
         prodottoDAO.save(prododottoGabbia4);
         prodottoDAO.save(prododottoGabbia5);
         prodottoDAO.save(prododottoGabbia6);
         prodottoDAO.save(prododottoGabbia7);
         prodottoDAO.save(prododottoGabbia8);

        //ACCESSORI GABBIE PER UCCELLO
        Prodotto accessoriGabbie1 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5JhmAFoc79TAHbRbdcFN_4dkHNtMmGblhWg&usqp=CAU","BRAVA 2 Ferplast Mangiatoia rotante uccelli ","mangiatoia rotante  gabbie  per piccoli uccelli",9.99,Categoria.AccessoriPerGabbie,TipoAnimale.Uccello);
        Prodotto accessoriGabbie2 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFxW-ZjYwc-uIpTFHZ9jmVPX40nRFPlPkXfA&usqp=CAU","Sifone Firenze 200cc – per pappagalli e per volatili gli abbeveratoi e beverini","Sifone Firenze 200cc – per pappagalli e per volatili gli abbeveratoi e beverini",1.09,Categoria.AccessoriPerGabbie,TipoAnimale.Uccello);
        Prodotto accessoriGabbie3 = new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsZXbiPP3ayiRQBrl5tbk7A2Ag8Rq_AThnXg&usqp=CAU","Boisbresil 2PCS Accessori per Gabbie Uccelli Mangiatoie verde","mangiatoie verde per uccelli ",14.50,Categoria.AccessoriPerGabbie,TipoAnimale.Uccello);
          prodottoDAO.save(accessoriGabbie1);
          prodottoDAO.save(accessoriGabbie2);
          prodottoDAO.save(accessoriGabbie3);



        //MANGIMI PER UCCELLO
        Prodotto mangime1= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqd_1Wy6013U5c4dBLruXNEmqOub0bHe4Yow&usqp=CAU","Mangime per uccelli manitoba 2,5 kg","Mangime per uccelli manitoba ",9.80,"price_1OoSP1C3pyi397slgotZeini",Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime2= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLKb-KGziVtLxsTUDL0EwskkuMXd-9KU2pGQ&usqp=CAU","Wellness Mix Per Canarini Kg.1 Padovan","Mangime per  canerini da 1kg",6.40,Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime3= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXdqmfUTmoVV59MB54CBPkDCNQDCiPDg5F-Q&usqp=CAU","MultiFit Mangime per Canarini 1Kg","Mangime per canerini da 1kg",3.00,Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime4= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2pFNVxpV2abmfa5fp7tZxzaf_IrrGpI4IAA&usqp=CAU","RAFF QUALITY MIX ESOTICI 900 gr","mangime per uccelli da 900 gr",6.00,Categoria.Mangime,TipoAnimale.Uccello);
        Prodotto mangime5= new Prodotto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfmPCw68R3ZC32yGy2BcX3DWvn-1VVSVnn8A&usqp=CAU","Mangime Bonus Per Canarini","mangimi per canarini da 1kg",3.20,Categoria.Mangime,TipoAnimale.Uccello);
          prodottoDAO.save(mangime1);
          prodottoDAO.save(mangime2);
          prodottoDAO.save(mangime3);
          prodottoDAO.save(mangime4);
          prodottoDAO.save(mangime5);














    }
}
