package sr.unasat.bp24.hibernate.repository;
import jakarta.persistence.TypedQuery;
import sr.unasat.bp24.hibernate.entity.Gebruiker;

import jakarta.persistence.EntityManager;
import java.util.List;

public class GebruikerRepository {

    private static GebruikerRepository instance;

    private GebruikerRepository() {
        // De constructor is privé, zodat er geen andere instanties van deze klasse kunnen worden gemaakt
    }

    public static GebruikerRepository getInstance() {
        if (instance == null) {
            instance = new GebruikerRepository();
        }

        return instance;
    }
    private EntityManager entityManager;

    public GebruikerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Gebruiker> getGebruikers() {
        String query = "select g from Gebruiker g";
        TypedQuery<Gebruiker> typedQuery = entityManager.createQuery(query, Gebruiker.class);
        return typedQuery.getResultList();
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gebruiker);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return gebruiker;
    }

    public Gebruiker getGebruikerById(int gebruikerId) {
        return entityManager.find(Gebruiker.class, gebruikerId);
    }

    public void updateGebruiker(Gebruiker gebruiker) {
        entityManager.getTransaction().begin();
        entityManager.merge(gebruiker);
        entityManager.getTransaction().commit();
    }

    public void deleteGebruiker(Gebruiker gebruiker) {
        // Begin een transactie en verwijder de gebruiker
        entityManager.getTransaction().begin();
        entityManager.remove(gebruiker);
        entityManager.getTransaction().commit();
    }

    public List<Gebruiker> zoekOpNaam(String naam) {
        String jpql = "SELECT g FROM Gebruiker g WHERE g.naam LIKE :naam";
        TypedQuery<Gebruiker> query = entityManager.createQuery(jpql, Gebruiker.class);
        query.setParameter("naam", "%" + naam + "%"); // Het '%' symbool staat voor wildcard en maakt gedeeltelijke overeenkomsten mogelijk
        return query.getResultList();
    }




}
