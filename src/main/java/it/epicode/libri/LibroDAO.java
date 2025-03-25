package it.epicode.libri;

import jakarta.persistence.EntityManager;

import java.util.List;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    // insert per inserire
    public void insert(Libro l) {
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }

    public void insertNoTx(Libro l) {
        em.persist(l);
    }

    // insert tramite array list
    public void insert(List<Libro> libri) {
        em.getTransaction().begin();
        for (Libro l : libri) {
            em.persist(l);
        }
        em.getTransaction().commit();
    }

    public void updateNoTx(Libro l) {
        em.merge(l);
    }

    public void deleteNoTx(Long id) {
        Libro l = em.find(Libro.class, id);
        em.remove(l);
    }
    // update per aggiornare
    public void update(Libro l) {
        em.getTransaction().begin();
        // se l'oggetto esiste lo aggiorna, se non esiste lo crea come il persist
        em.merge(l);
        em.getTransaction().commit();
    }

    // delete per eliminare il libro tramite id
    public void delete(Long id) {
        Libro l = em.find(Libro.class, id);
        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
    }

    // find per cercare tramite chiave primaria
    public Libro find(Long id) {
        return em.find(Libro.class, id);
    }

}
