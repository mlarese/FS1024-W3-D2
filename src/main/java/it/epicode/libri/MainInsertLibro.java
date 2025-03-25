package it.epicode.libri;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class MainInsertLibro {
    public static void main(String[] args) {

        // usiamo entity maneger per inserire un libro nel db
        // la persistence unit è epicode come specificatpo nel file persistence.xml
        // <persistence-unit name="epicode">

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        // creiamo un entity manager
        EntityManager em = emf.createEntityManager();

        Libro l = new Libro("Il signore degli anelli", "J.R.R. Tolkien", 1954);
        // iniziamo una transazione
        em.getTransaction().begin();
        // inseriamo il libro
        em.persist(l);
        // commit della transazione
        em.getTransaction().commit();
        // chiudiamo l'entity manager
        em.close();
        // chiudiamo l'entity manager factory
        emf.close();

    }
}
