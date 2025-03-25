package it.epicode.libri.test;

import it.epicode.libri.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDelete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        Libro l = em.find(Libro.class, 1L);

        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();


        em.close();
        emf.close();


    }
}
