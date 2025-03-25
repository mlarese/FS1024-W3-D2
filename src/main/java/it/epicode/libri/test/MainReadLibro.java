package it.epicode.libri.test;

import it.epicode.libri.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainReadLibro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        // creiamo un entity manager
        EntityManager em = emf.createEntityManager();

        // leggiamo tramite chieve primaria (id) IL LIBRO CON ID = 1

        Libro l = em.find(Libro.class, 1L);

        System.out.println("Libro letto: " + l.getTitolo() + " " + l.getAutore() + " " + l.getAnnoPubblicazione());

        // chiudiamo l'entity manager
        em.close();
        // chiudiamo l'entity manager factory
        emf.close();

    }
}
