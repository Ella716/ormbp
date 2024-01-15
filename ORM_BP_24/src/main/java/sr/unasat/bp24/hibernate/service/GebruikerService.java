package sr.unasat.bp24.hibernate.service;

import sr.unasat.bp24.hibernate.configuration.JPAConfiguration;
import sr.unasat.bp24.hibernate.entity.Gebruiker;
import sr.unasat.bp24.hibernate.repository.GebruikerFavorietenRepository;
import sr.unasat.bp24.hibernate.repository.GebruikerRepository;


import java.util.List;

public class GebruikerService {
    private final GebruikerRepository repository;

    public GebruikerService() {
        this.repository = new GebruikerRepository(JPAConfiguration.getEntityManager());
    }

    public List<Gebruiker> getGebruikers() {
        return repository.getGebruikers();
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker) {
        return repository.createGebruiker(gebruiker);
    }

    public Gebruiker getGebruikerById(int gebruikerId) {
        return repository.getGebruikerById(gebruikerId);
    }

    public void updateGebruiker(Gebruiker gebruiker) {
        repository.updateGebruiker(gebruiker);
    }

    public void deleteGebruiker(Gebruiker gebruiker) {
        // Gebruik de repository om de gebruiker te verwijderen
        repository.deleteGebruiker(gebruiker);
    }

    public List<Gebruiker> zoekGebruikersOpNaam(String naam) {
        // Roep de repository-methode aan die de zoekopdracht uitvoert
        return repository.zoekOpNaam(naam);
    }




}


