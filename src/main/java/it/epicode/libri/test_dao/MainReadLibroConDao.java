package it.epicode.libri.test_dao;

import it.epicode.libri.Libro;
import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainReadLibroConDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        // leggiamo tramite chieve primaria (id) IL LIBRO CON ID = 1
        LibroDAO libroDao = new LibroDAO(em);

        Libro l = libroDao.find(2L);

        System.out.println("Libro letto: " + l.getTitolo() + " " + l.getAutore() + " " + l.getAnnoPubblicazione());

        em.close();
        emf.close();

    }
}
