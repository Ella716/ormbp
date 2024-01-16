package sr.unasat.bp24.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import sr.unasat.bp24.hibernate.entity.Categorie;

import java.util.List;


public class CategorieRepository {
    private EntityManager entityManager;

    public CategorieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Categorie> getCategorieen() {
        String query = "select c from Categorie c";
        TypedQuery<Categorie> typedQuery = entityManager.createQuery(query, Categorie.class);
        return typedQuery.getResultList();
    }

    public Categorie createCategorie(String categorieNaam) {
        try {
            // Controleer of de categorie al bestaat in de database
            TypedQuery<Categorie> query = entityManager.createQuery(
                            "SELECT c FROM Categorie c WHERE c.naam = :naam", Categorie.class)
                    .setParameter("naam", categorieNaam);

            List<Categorie> bestaandeCategorieen = query.getResultList();

            if (!bestaandeCategorieen.isEmpty()) {
                // Gebruik de bestaande categorie als deze al bestaat
                return bestaandeCategorieen.get(0);
            }

            // Als de categorie nog niet bestaat, maak een nieuwe categorie aan
            Categorie nieuweCategorie = new Categorie();
            nieuweCategorie.setNaam(categorieNaam);

            entityManager.getTransaction().begin();
            entityManager.persist(nieuweCategorie);
            entityManager.getTransaction().commit();

            return nieuweCategorie;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }
}
