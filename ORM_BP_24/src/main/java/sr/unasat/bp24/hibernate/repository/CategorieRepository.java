package sr.unasat.bp24.hibernate.repository;

import jakarta.persistence.EntityManager;
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

    public Categorie createCategorie(Categorie categorie) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(categorie);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return categorie;
    }}
