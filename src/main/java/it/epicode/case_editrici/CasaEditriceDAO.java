package it.epicode.case_editrici;

import jakarta.persistence.EntityManager;

public class CasaEditriceDAO {
    private EntityManager em;

    public CasaEditriceDAO(EntityManager em) {
        this.em = em;
    }

    public CasaEditrice find(Long id) {
        return em.find(CasaEditrice.class, id);
    }

    public void insert(CasaEditrice ce) {
        em.getTransaction().begin();
        em.persist(ce);
        em.getTransaction().commit();
    }

    public void insertNoTx(CasaEditrice ce) {
        em.persist(ce);
    }

    public void update(CasaEditrice ce) {
        em.getTransaction().begin();
        em.merge(ce);
        em.getTransaction().commit();
    }

    public void updateNoTx(CasaEditrice ce) {
        em.merge(ce);
    }

    public void delete(Long id) {
        em.getTransaction().begin();
        CasaEditrice ce = find(id);
        em.remove(ce);
        em.getTransaction().commit();
    }

    public void deleteNoTx(Long id) {
        CasaEditrice ce = find(Cid);
        em.remove(ce);
    }
}
