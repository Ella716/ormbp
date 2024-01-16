package sr.unasat.bp24.hibernate;

import sr.unasat.bp24.hibernate.entity.*;
import sr.unasat.bp24.hibernate.factory.ProductFactory;
import sr.unasat.bp24.hibernate.service.*;

import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

            //1: Categorie opslaan
//            CategorieService categorieService = new CategorieService();
//            Categorie categorie = categorieService.createCategorie("Electronics");


            //2: Product opslaan (met verwijzing naar Categorie)
            // Product maken met Factory pattern
//            Product product = ProductFactory.maakProduct("Smartphone", 699.99);
//            product.setCategorie(categorie);
            ProductService productService = new ProductService();
//            productService.createProduct(product);

            // 3: Gebruiker opslaan(singleton)
            GebruikerService gebruikerService = GebruikerService.getInstance();
//            Gebruiker gebruiker = new Gebruiker();
//            gebruiker.setNaam("Doe Doe");
//            gebruiker.setEmail("doe@example.com");
//            gebruiker.setWachtwoord("password147");
//            gebruikerService.createGebruiker(gebruiker);

            // 4: Beoordeling opslaan (met verwijzingen naar Gebruiker en Product)
//            BeoordelingService beoordelingService = new BeoordelingService();
//            Beoordeling beoordeling = new Beoordeling();
//            beoordeling.setOpmerking("Fantastisch product!");
//            beoordeling.setScore(5);
//            beoordeling.setGebruiker(gebruiker);
//            beoordeling.setProduct(product);
//            beoordelingService.createBeoordeling(beoordeling);

            // 5: Aankoop opslaan (met verwijzingen naar Gebruiker en Product)
            AankoopService aankoopService = new AankoopService();
//            Aankoop aankoop = new Aankoop();
//            aankoop.setDatum(new Date());
//            aankoop.setGebruiker(gebruiker);
//            aankoop.setProduct(product);
//            aankoopService.createAankoop(aankoop);

            // 6: GebruikerFavorieten opslaan
//            GebruikerFavorietenService favorietenService = new GebruikerFavorietenService();
//            GebruikerFavorieten favorieten = new GebruikerFavorieten();
//            favorieten.setGebruiker(gebruiker);
//            favorieten.setFavorieteProduct(product);
//            favorietenService.createGebruikerFavorieten(favorieten);

            // 7: SpecialeAanbieding opslaan (met verwijzing naar Product)
//            SpecialeAanbiedingService aanbiedingService = new SpecialeAanbiedingService();
//            SpecialeAanbieding aanbieding = new SpecialeAanbieding();
//            aanbieding.setAanbiedingTekst("Limited-edition!");
//            aanbieding.setSpeciaalProduct(product);
//            aanbiedingService.createSpecialeAanbieding(aanbieding);

//            //Read
//              int gebruikerId = 1;
//            Gebruiker gevondenGebruiker = gebruikerService.getGebruikerById(gebruikerId);
//
//            if (gevondenGebruiker != null) {
//                    System.out.println("Gebruiker gevonden: " + gevondenGebruiker.getNaam());
//            } else {
//                    System.out.println("Gebruiker niet gevonden.");
//            }

            //Update
//            Gebruiker teBewerkenGebruiker = gebruikerService.getGebruikerById(gebruikerId);
//
//            if (teBewerkenGebruiker != null) {
//                    teBewerkenGebruiker.setNaam("Nieuwe Naam");
//
//                    gebruikerService.updateGebruiker(teBewerkenGebruiker);
//
//                    System.out.println("Gebruiker bijgewerkt: " + teBewerkenGebruiker.getNaam());
//            } else {
//                    System.out.println("Gebruiker niet gevonden.");
//            }

            //Delete
//            Gebruiker teVerwijderenGebruiker = gebruikerService.getGebruikerById(gebruikerId);
//
//            if (teVerwijderenGebruiker != null) {
//                gebruikerService.deleteGebruiker(teVerwijderenGebruiker);
//
//                System.out.println("Gebruiker verwijderd: " + teVerwijderenGebruiker.getNaam());
//            } else {
//                System.out.println("Gebruiker niet gevonden.");
//            }

        //Zoekfunctie 1(gebruiker)
//        List<Gebruiker> gevondenGebruikers = gebruikerService.zoekGebruikersOpNaam("Jane Doe");
//
//        for (Gebruiker gebruiker : gevondenGebruikers) {
//            System.out.println("Gevonden gebruiker: " + gebruiker.getNaam());
//        }

        //Zoekfunctie 2(product)
//        List<Product> gevondenProducten = productService.zoekProductenOpNaam("Smart");

//        for (Product product : gevondenProducten) {
//            System.out.println("Gevonden product: " + product.getNaam());
//        }

        //Rapportage 1
        List<Aankoop> alleAankopen = aankoopService.getAankopen();

        System.out.println("---- Aankooprapportage ----");
        for (Aankoop aankoop : alleAankopen) {
            System.out.println("Aankoop door gebruiker " + aankoop.getGebruiker().getNaam() +
                    " op " + aankoop.getDatum() + " van product " + aankoop.getProduct().getNaam());
        }

//            Rapportage 2
        List<Gebruiker> alleGebruikers = gebruikerService.getGebruikers();

        System.out.println("---- Gebruikersrapportage ----");
        for (Gebruiker gebruiker : alleGebruikers) {
            System.out.println("Gebruiker: " + gebruiker.getNaam() + " (E-mail: " + gebruiker.getEmail() + ")");
        }







    }
}